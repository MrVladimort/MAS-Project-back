package pl.pjatk.mas.project.boundary.dto;

import lombok.*;
import pl.pjatk.mas.project.control.entity.Ticket;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TicketDTO {
    private Double price;
    private Integer placeNumber;
    private Ticket.TicketType type;
}
