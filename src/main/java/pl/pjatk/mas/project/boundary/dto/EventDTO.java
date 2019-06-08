package pl.pjatk.mas.project.boundary.dto;

import lombok.*;
import pl.pjatk.mas.project.control.entity.Event;

import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EventDTO {
    private String name;
    private LocalDateTime dateTime;
    private Event.EventType type;
    private Integer placeCount;
    private LocalizationDTO localization;
}
