package pl.pjatk.mas.project.control.service.impl;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.pjatk.mas.project.boundary.dto.OrderDTO;
import pl.pjatk.mas.project.control.dao.OrderDAO;
import pl.pjatk.mas.project.control.mapper.ProjectMapper;
import pl.pjatk.mas.project.control.service.OrderService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    @NonNull OrderDAO orderDao;
    @NonNull ProjectMapper mapper;

    @Override
    public List<OrderDTO> getAllClientOrders(Long clientId) {
        return orderDao.findAllByClient_Id(clientId).stream().map(mapper::orderEntityToDto).collect(Collectors.toList());
    }
}
