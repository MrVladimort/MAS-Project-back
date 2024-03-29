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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EVENT_ID", referencedColumnName = "EVENT_ID")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private EventEntity event;

    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private UserEntity user;

    @Builder
    public CommentEntity(String text, @Min(1) @Max(5) Integer grade, EventEntity event, UserEntity user) {
        this.text = text;
        this.grade = grade;
        this.event = event;
        this.user = user;
    }
}
