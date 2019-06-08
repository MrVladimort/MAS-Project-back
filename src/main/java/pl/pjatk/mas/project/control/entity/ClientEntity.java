package pl.pjatk.mas.project.control.entity;

import lombok.*;
import org.springframework.core.annotation.Order;
import pl.pjatk.mas.project.control.entity.enums.UserRole;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    @OneToMany(
            targetEntity = AttenderEntity.class,
            mappedBy = "client",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<AttenderEntity> attenders = new HashSet<>();

    @OneToMany(
            targetEntity = PromotionEntity.class,
            mappedBy = "client",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<PromotionEntity> promotions = new HashSet<>();

    @OneToMany(
            targetEntity = OrderEntity.class,
            mappedBy = "client",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<OrderEntity> orders = new HashSet<>();

    @Builder
    public ClientEntity(String name, String surname, String email, String password, UserRole role, String phone, String address, Set<AttenderEntity> attenders, Set<PromotionEntity> promotions, Set<OrderEntity> orders) {
        super(name, surname, email, password, role);
        this.phone = phone;
        this.address = address;
        this.attenders = attenders;
        this.promotions = promotions;
        this.orders = orders;
    }
}
