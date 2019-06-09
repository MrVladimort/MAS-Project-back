package pl.pjatk.mas.project.control.service;

import pl.pjatk.mas.project.boundary.dto.AttenderDTO;
import pl.pjatk.mas.project.boundary.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    List<OrderDTO> getAllClientOrders(Long clientId);

    List<AttenderDTO> getAllClientAttenders(Long clientId);

    AttenderDTO createAttender(Long clientId, AttenderDTO attenderDto);

    OrderDTO createOrder(Long clientId, Long eventId, OrderDTO orderDto);

    OrderDTO payForOrder(Long clientId, Long orderId, Integer amount);
}
