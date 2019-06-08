package pl.pjatk.mas.project.control.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@Entity
@Table(name = "ARTISTS")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", unique = true)
    private String name;

    @Column(name = "STYLE")
    private String style;

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE", nullable = false)
    private ArtistType type;

    public enum ArtistType {
        SPEAKER,
        MUSICIAN
    }

    @Builder
    public Artist(String name, String style, ArtistType type) {
        this.name = name;
        this.style = style;
        this.type = type;
    }
}
