package pl.pjatk.mas.project.control.entity;

import lombok.*;
import pl.pjatk.mas.project.control.entity.enums.EventType;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class EventEntity extends AuditingEntity {
    @Id
    @Column(name = "EVENT_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EVENT_SQ")
    @SequenceGenerator(name = "EVENT_SQ", sequenceName = "EVENTS_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "NAME", unique = true)
    private String name;

    @Column(name = "DATE_TIME", nullable = false)
    private LocalDateTime dateTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE", nullable = false)
    private EventType type;

    @Column(name = "PLACE_COUNT", nullable = false)
    private Integer placeCount;

    @Column(name = "PRICE", nullable = false)
    private Double price;

    @OneToMany(mappedBy = "event",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @EqualsAndHashCode.Exclude
    private Set<EventArtistEntity> artists = new HashSet<>();

    @ManyToOne(targetEntity = LocalizationEntity.class,
            cascade = CascadeType.MERGE,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "LOCALIZATION_ID", referencedColumnName = "LOCALIZATION_ID")
    @EqualsAndHashCode.Exclude
    private LocalizationEntity localization;

    @OneToMany(
            targetEntity = CommentEntity.class,
            mappedBy = "event",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<CommentEntity> comments = new HashSet<>();

    @OneToMany(
            targetEntity = TicketEntity.class,
            mappedBy = "event",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<TicketEntity> tickets = new HashSet<>();

    public void addArtist(ArtistEntity artist, Integer timeOfPerfomance) {
        EventArtistEntity eventArtistEntity = EventArtistEntity.builder().event(this).artist(artist).timeOfPerformance(timeOfPerfomance).build();
        artists.add(eventArtistEntity);
        artist.getEvents().add(eventArtistEntity);
    }

    public void removeArtist(ArtistEntity artist) {
        for (Iterator<EventArtistEntity> iterator = artists.iterator();
             iterator.hasNext(); ) {
            EventArtistEntity eventArtist = iterator.next();

            if (eventArtist.getEvent().equals(this) &&
                    eventArtist.getArtist().equals(artist)) {
                iterator.remove();
                eventArtist.getArtist().getEvents().remove(eventArtist);
                eventArtist.setArtist(null);
                eventArtist.setEvent(null);
            }
        }
    }


    @Builder

    public EventEntity(String name, LocalDateTime dateTime, EventType type, Integer placeCount, Double price, LocalizationEntity localization, Set<TicketEntity> tickets) {
        this.name = name;
        this.dateTime = dateTime;
        this.type = type;
        this.placeCount = placeCount;
        this.price = price;
        this.localization = localization;
        this.tickets = tickets;
    }
}