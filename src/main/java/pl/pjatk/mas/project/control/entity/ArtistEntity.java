package pl.pjatk.mas.project.control.entity;

import lombok.*;
import pl.pjatk.mas.project.control.entity.enums.ArtistType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ArtistEntity extends AuditingEntity {
    @Id
    @Column(name = "ARTIST_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ARTIST_SQ")
    @SequenceGenerator(name = "ARTIST_SQ", sequenceName = "ARTISTS_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "NAME", unique = true)
    private String name;

    @Column(name = "STYLE")
    private String style;

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE", nullable = false)
    private ArtistType type;

    @OneToMany(mappedBy = "artist")
    private Set<EventArtistEntity> events = new HashSet<>();

    @Builder
    public ArtistEntity(String name, String style, ArtistType type, Set<EventArtistEntity> events) {
        this.name = name;
        this.style = style;
        this.type = type;
        this.events = events;
    }
}
