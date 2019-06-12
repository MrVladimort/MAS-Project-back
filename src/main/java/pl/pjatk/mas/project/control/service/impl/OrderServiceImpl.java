package pl.pjatk.mas.project.control.service.impl;

import io.swagger.models.auth.In;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.pjatk.mas.project.boundary.dto.AttenderDTO;
import pl.pjatk.mas.project.boundary.dto.OrderDTO;
import pl.pjatk.mas.project.control.dao.*;
import pl.pjatk.mas.project.control.entity.*;
import pl.pjatk.mas.project.control.entity.enums.OrderStatus;
import pl.pjatk.mas.project.control.mapper.ProjectMapper;
import pl.pjatk.mas.project.control.service.OrderService;
import pl.pjatk.mas.project.controller.exceptions.EntityNotFoundException;
import pl.pjatk.mas.project.controller.exceptions.SomeException;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    @NonNull UserDAO userDao;
    @NonNull ClientDAO clientDao;
    @NonNull EventDAO eventDao;
    @NonNull OrderDAO orderDao;
    @NonNull AttenderDAO attenderDao;
    @NonNull ProjectMapper mapper;

    @Override
    public List<OrderDTO> getAllClientOrders(Long userId) {
        UserEntity user = userDao.findById(userId).orElseThrow(EntityNotFoundException::new);
        log.info("User data: {}", user);
        return orderDao.findAllByClient_Id(user.getClient().getId()).stream()
                .map(mapper::orderEntityToDto)
                .sorted(Comparator.comparing(OrderDTO::getId).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public List<AttenderDTO> getAllClientAttenders(Long userId) {
        UserEntity user = userDao.findById(userId).orElseThrow(EntityNotFoundException::new);
        log.info("User data: {}", user);
        return attenderDao.findAllByClient_Id(user.getClient().getId()).stream()
                .map(mapper::attenderEntityToDto)
                .sorted(Comparator.comparing(AttenderDTO::getId).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public AttenderDTO createAttender(Long clientId, AttenderDTO attenderDto) {
        UserEntity user = userDao.findById(clientId).orElseThrow(EntityNotFoundException::new);
        log.info("User data: {}", user);
        AttenderEntity attenderEntity = mapper.attenderDtoToEntity(attenderDto);
        attenderEntity.setClient(user.getClient());
        return mapper.attenderEntityToDto(attenderDao.save(attenderEntity));
    }

    @Override
    public OrderDTO createOrder(Long clientId, Long eventId, OrderDTO orderDto) {
        UserEntity user = userDao.findById(clientId).orElseThrow(EntityNotFoundException::new);
        log.info("User data: {}", user);
        EventEntity event = eventDao.findById(eventId).orElseThrow(EntityNotFoundException::new);
        OrderEntity order = OrderEntity.builder()
                .totalPrice(orderDto.getTotalPrice())
                .status(OrderStatus.CONFIRMED)
                .client(user.getClient())
                .build();

        orderDto.getTickets().forEach(ticketDto -> {
            TicketEntity ticketEntity = mapper.ticketDtoToEntity(ticketDto);
            ticketEntity.addEvent(event);
            order.addTicket(ticketEntity);
        });

        log.info("Order data: {}", order);

        return mapper.orderEntityToDto(orderDao.save(order));
    }

    @Override
    public OrderDTO payForOrder(Long userId, Long orderId, Integer amount) {
        UserEntity user = userDao.findById(userId).orElseThrow(EntityNotFoundException::new);
        log.info("User data: {}", user);
        OrderEntity order = orderDao.findByIdAndStatusAndClient_Id(orderId, OrderStatus.CONFIRMED, user.getClient().getId()).orElseThrow(EntityNotFoundException::new);
        if (amount.equals(order.getTotalPrice())) {
            order.setStatus(OrderStatus.PAID);
            log.info("Paid for order: {}", orderId);
            return mapper.orderEntityToDto(orderDao.save(order));
        } else throw new SomeException("amount: " + amount + " is dif then totalPrice: " + order.getTotalPrice());
    }


}
