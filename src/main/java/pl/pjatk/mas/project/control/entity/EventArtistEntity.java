package pl.pjatk.mas.project.control.entity;

import lombok.*;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("ARTIST_ID")
    @JoinColumn(name = "ARTIST_ID")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private ArtistEntity artist;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("EVENT_ID")
    @JoinColumn(name = "EVENT_ID")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private EventEntity event;

    private Integer timeOfPerformance;

    @PrePersist
    private void prePersist() {
        if (getId() == null) {
            EventArtistKey pk = new EventArtistKey();
            pk.setArtistId(getArtist().getId());
            pk.setEventId(getEvent().getId());
            setId(pk);
        }
    }

    @Builder
    public EventArtistEntity(ArtistEntity artist, EventEntity event, Integer timeOfPerformance) {
        this.artist = artist;
        this.event = event;
        this.timeOfPerformance = timeOfPerformance;
    }
}
