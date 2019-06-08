package pl.pjatk.mas.project.control.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CommentEntity  extends AuditingEntity {
    @Id
    @Column(name = "COMMENT_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMMENT_SQ")
    @SequenceGenerator(name = "COMMENT_SQ", sequenceName = "COMMENTS_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "TEXT", unique = true)
    private String text;

    @Column(name = "GRADE")
    @Min(1)
    @Max(5)
    private Integer grade;

    @Builder
    public CommentEntity(String text, @Min(1) @Max(5) Integer grade) {
        this.text = text;
        this.grade = grade;
    }
}