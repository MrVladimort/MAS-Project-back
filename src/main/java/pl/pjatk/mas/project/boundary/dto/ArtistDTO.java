package pl.pjatk.mas.project.boundary.dto;

import lombok.*;
import pl.pjatk.mas.project.control.entity.ArtistEntity;
import pl.pjatk.mas.project.control.entity.enums.ArtistType;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ArtistDTO {
    private String name;
    private String style;
    private ArtistType type;
}
