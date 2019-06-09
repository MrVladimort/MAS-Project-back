package pl.pjatk.mas.project.control.service;

import pl.pjatk.mas.project.boundary.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    List<OrderDTO> getAllClientOrders(Long clientId);
}
