package pl.pjatk.mas.project.boundary.dto;

import lombok.*;
import pl.pjatk.mas.project.control.entity.EventEntity;
import pl.pjatk.mas.project.control.entity.enums.EventType;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class EventDTO {
    private Long id;
    private String name;
    private LocalDateTime dateTime;
    private EventType type;
    private Integer placeCount;
    private Double price;
    private List<ArtistDTO> artists;
    private List<CommentDTO> comments;
    private LocalizationDTO localization;

    @Builder
    public EventDTO(Long id, String name, LocalDateTime dateTime, EventType type, Integer placeCount, Double price, List<ArtistDTO> artists, List<CommentDTO> comments, LocalizationDTO localization) {
        this.id = id;
        this.name = name;
        this.dateTime = dateTime;
        this.type = type;
        this.placeCount = placeCount;
        this.price = price;
        this.artists = artists;
        this.comments = comments;
        this.localization = localization;
    }
}
