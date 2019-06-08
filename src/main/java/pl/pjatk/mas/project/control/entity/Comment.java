package pl.pjatk.mas.project.control.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@Table(name = "COMMENTS")
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TEXT", unique = true)
    private String text;

    @Column(name = "GRADE")
    @Min(1)
    @Max(5)
    private Integer grade;

    @Builder
    public Comment(String text, @Min(1) @Max(5) Integer grade) {
        this.text = text;
        this.grade = grade;
    }
}
