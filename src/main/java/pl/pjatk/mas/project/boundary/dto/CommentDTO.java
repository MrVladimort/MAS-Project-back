package pl.pjatk.mas.project.boundary.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class CommentDTO {
    private Long id;
    private String text;
    private Integer grade;
    private String eventName;
    private String userName;
    private String userSurname;
    private LocalDateTime createdAt;

    @Builder
    public CommentDTO(Long id, String text, Integer grade, LocalDateTime createdAt) {
        this.id = id;
        this.text = text;
        this.grade = grade;
        this.createdAt = createdAt;
    }
}
