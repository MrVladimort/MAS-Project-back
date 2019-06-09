package pl.pjatk.mas.project.control.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
class EventArtistKey implements Serializable {
    @Column(name = "EVENT_ID")
    Long eventId;

    @Column(name = "ARTIST_ID")
    Long artistId;

    @Builder
    public EventArtistKey(Long eventId, Long artistId) {
        this.eventId = eventId;
        this.artistId = artistId;
    }
}