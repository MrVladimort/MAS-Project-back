package pl.pjatk.mas.project.boundary.dto;

import lombok.*;
import pl.pjatk.mas.project.control.entity.Order;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private List<TicketDTO> tickets;
    private Order.OrderStatus status;
    private LocalDateTime dateTime;
    private Double totalPrice;
}
