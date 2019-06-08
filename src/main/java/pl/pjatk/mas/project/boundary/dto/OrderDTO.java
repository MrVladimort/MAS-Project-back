package pl.pjatk.mas.project.boundary.dto;

import lombok.*;
import pl.pjatk.mas.project.control.entity.OrderEntity;
import pl.pjatk.mas.project.control.entity.enums.OrderStatus;

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
    private OrderStatus status;
    private LocalDateTime dateTime;
    private Double totalPrice;
}
