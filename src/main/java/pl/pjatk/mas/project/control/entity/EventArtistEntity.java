package pl.pjatk.mas.project.control.entity;

import lombok.*;
import pl.pjatk.mas.project.boundary.ArtistController;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class EventArtistEntity extends AuditingEntity {
    @EmbeddedId
    EventArtistKey id;

    @ManyToOne(targetEntity = ArtistEntity.class)
    @MapsId("ARTIST_ID")
    @JoinColumn(name = "ARTIST_ID")
    private ArtistEntity artist;

    @ManyToOne(targetEntity = EventEntity.class)
    @MapsId("EVENT_ID")
    @JoinColumn(name = "EVENT_ID")
    private EventEntity event;

    private Integer timeOfPerformance;

    @Builder
    public EventArtistEntity(ArtistEntity artist, EventEntity event, Integer timeOfPerformance) {
        this.artist = artist;
        this.event = event;
        this.timeOfPerformance = timeOfPerformance;
    }

    @Embeddable
    @Getter
    @Setter
    @EqualsAndHashCode(callSuper = false)
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    class EventArtistKey implements Serializable {
        @Column(name = "EVENT_ID")
        Long eventId;

        @Column(name = "ARTIST_ID")
        Long artistId;
    }
}
