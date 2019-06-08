package pl.pjatk.mas.project.control.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString
@NoArgsConstructor
@Table(name = "USERS")
@Entity
public class User extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "PASSWORD", nullable = false)
    private LocalDateTime password;

    @Column(name = "REGISTER_DATE_TIME")
    private LocalDateTime registerDateTime;

    @Builder
    public User(String name, String surname, String email, LocalDateTime password, LocalDateTime registerDateTime) {
        super(name, surname);
        this.email = email;
        this.password = password;
        this.registerDateTime = registerDateTime;
    }
}
