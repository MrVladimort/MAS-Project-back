package pl.pjatk.mas.project.control.entity;

import lombok.*;
import pl.pjatk.mas.project.control.entity.enums.EventType;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class EventEntity  extends AuditingEntity {
    @Id
    @Column(name = "EVENT_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EVENT_SQ")
    @SequenceGenerator(name = "EVENT_SQ", sequenceName = "EVENTS_SEQ", allocationSize = 1)
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

    @OneToMany(mappedBy = "event")
    private Set<EventArtistEntity> artists = new HashSet<>();

    @Builder
    public EventEntity(String text, LocalDateTime dateTime, EventType type, Integer placeCount, Set<EventArtistEntity> artists) {
        this.text = text;
        this.dateTime = dateTime;
        this.type = type;
        this.placeCount = placeCount;
        this.artists = artists;
    }
}