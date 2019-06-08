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
public class ClientEntity extends UserEntity {
    @Column(name = "PHONE", nullable = false)
    private String phone;

    @Column(name = "ADDRESS")
    private String address;

    @Builder
    public ClientEntity(String name, String surname, String email, String password, UserRole role, String phone, String address) {
        super(name, surname, email, password, role);
        this.phone = phone;
        this.address = address;
    }
}
