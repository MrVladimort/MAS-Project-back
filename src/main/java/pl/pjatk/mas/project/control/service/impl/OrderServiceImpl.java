package pl.pjatk.mas.project.control.service.impl;

import io.swagger.models.auth.In;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.pjatk.mas.project.boundary.dto.AttenderDTO;
import pl.pjatk.mas.project.boundary.dto.OrderDTO;
import pl.pjatk.mas.project.control.dao.AttenderDAO;
import pl.pjatk.mas.project.control.dao.ClientDAO;
import pl.pjatk.mas.project.control.dao.EventDAO;
import pl.pjatk.mas.project.control.dao.OrderDAO;
import pl.pjatk.mas.project.control.entity.*;
import pl.pjatk.mas.project.control.entity.enums.OrderStatus;
import pl.pjatk.mas.project.control.mapper.ProjectMapper;
import pl.pjatk.mas.project.control.service.OrderService;
import pl.pjatk.mas.project.controller.exceptions.EntityNotFoundException;
import pl.pjatk.mas.project.controller.exceptions.SomeException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    @NonNull ClientDAO clientDao;
    @NonNull EventDAO eventDao;
    @NonNull OrderDAO orderDao;
    @NonNull AttenderDAO attenderDao;
    @NonNull ProjectMapper mapper;

    @Override
    public List<OrderDTO> getAllClientOrders(Long clientId) {
        return orderDao.findAllByClient_Id(clientId).stream().map(mapper::orderEntityToDto).collect(Collectors.toList());
    }

    @Override
    public List<AttenderDTO> getAllClientAttenders(Long clientId) {
        return attenderDao.findAllByClient_Id(clientId).stream().map(mapper::attenderEntityToDto).collect(Collectors.toList());
    }

    @Override
    public AttenderDTO createAttender(Long clientId, AttenderDTO attenderDto) {
        ClientEntity client = clientDao.findById(clientId).orElseThrow(EntityNotFoundException::new);
        AttenderEntity attenderEntity = mapper.attenderDtoToEntity(attenderDto);
        attenderEntity.setClient(client);
        return mapper.attenderEntityToDto(attenderDao.save(attenderEntity));
    }

    @Override
    public OrderDTO createOrder(Long clientId, Long eventId, OrderDTO orderDto) {
        ClientEntity client = clientDao.findById(clientId).orElseThrow(EntityNotFoundException::new);
        EventEntity event = eventDao.findById(eventId).orElseThrow(EntityNotFoundException::new);
        OrderEntity order = OrderEntity.builder()
                .totalPrice(orderDto.getTotalPrice())
                .status(OrderStatus.CONFIRMED)
                .client(client)
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
    public OrderDTO payForOrder(Long clientId, Long orderId, Integer amount) {
        OrderEntity order = orderDao.findByIdAndStatusAndClient_Id(orderId, OrderStatus.CONFIRMED, clientId).orElseThrow(EntityNotFoundException::new);
        if (amount.equals(order.getTotalPrice())) {
            order.setStatus(OrderStatus.PAID);
            log.info("Paid for order: {}", orderId);
            return mapper.orderEntityToDto(orderDao.save(order));
        } else throw new SomeException("amount: " + amount + " is dif then totalPrice: " + order.getTotalPrice());
    }


}
