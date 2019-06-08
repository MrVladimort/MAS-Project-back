package pl.pjatk.mas.project.boundary.dto;

import lombok.*;
import pl.pjatk.mas.project.control.entity.Artist;

import javax.persistence.Column;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ArtistDTO {
    private String name;
    private String style;
    private Artist.ArtistType type;
}
