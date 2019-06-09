package pl.pjatk.mas.project.boundary.dto;

import lombok.*;
import pl.pjatk.mas.project.control.entity.enums.TicketType;

import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TicketDTO {
    private Long id;
    private Double price;
    private Integer placeNumber;
    private TicketType type;
    private AttenderDTO attender;
    private String eventName;
    private LocalDateTime eventDate;
    private Long eventId;
}
