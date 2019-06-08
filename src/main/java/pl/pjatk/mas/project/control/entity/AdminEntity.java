package pl.pjatk.mas.project.control.entity;

import lombok.*;
import pl.pjatk.mas.project.control.entity.enums.UserRole;

import javax.persistence.Column;
import javax.persistence.Entity;

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
    public AdminEntity(String name, String surname, String email, String password, UserRole role, String identifier) {
        super(name, surname, email, password, role);
        this.identifier = identifier;
    }
}
