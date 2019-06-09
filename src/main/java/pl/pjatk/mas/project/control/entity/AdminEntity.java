package pl.pjatk.mas.project.control.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AdminEntity extends UserEntity {
    @Column(name = "IDENTIFIER", nullable = false, unique = true)
    private String identifier;

    @Builder
    public AdminEntity(String name, String surname, String email, String password, String identifier) {
        super(name, surname, email, password);
        this.identifier = identifier;
    }
}
