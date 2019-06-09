package pl.pjatk.mas.project.boundary.dto;

import lombok.*;
import pl.pjatk.mas.project.control.entity.ArtistEntity;
import pl.pjatk.mas.project.control.entity.enums.ArtistType;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class ArtistDTO {
    private Long id;
    private String name;
    private String style;
    private ArtistType type;

    @Builder
    public ArtistDTO(Long id, String name, String style, ArtistType type) {
        this.id = id;
        this.name = name;
        this.style = style;
        this.type = type;
    }
}
