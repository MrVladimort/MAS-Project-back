package pl.pjatk.mas.project.control.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@Table(name = "EVENTS")
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", unique = true)
    private String text;

    @Column(name = "DATE_TIME", nullable = false)
    private LocalDateTime dateTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE", nullable = false)
    private EventType type;

    @Column(name = "PLACE_COUNT", nullable = false)
    private Integer placeCount;

    public enum EventType {
        TRAINING, CONCERT
    }

    @Builder
    public Event(String text, LocalDateTime dateTime, EventType type, Integer placeCount) {
        this.text = text;
        this.dateTime = dateTime;
        this.type = type;
        this.placeCount = placeCount;
    }
}