package pl.pjatk.mas.project.control.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ClientEntity extends UserEntity {
    @Column(name = "PHONE", nullable = false)
    private String phone;

    @Column(name = "ADDRESS")
    private String address;

    @OneToMany(targetEntity = AttenderEntity.class, mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<AttenderEntity> attenders = new HashSet<>();

    @OneToMany(targetEntity = PromotionEntity.class, mappedBy = "client",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
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

    public void addPromotion(PromotionEntity promotion) {
        promotions.add(promotion);
        promotion.setClient(this);
    }

    public void removeArtist(TicketEntity ticket) {

    }

    @Builder
    public ClientEntity(String name, String surname, String email, String password, String phone, String address) {
        super(name, surname, email, password);
        this.phone = phone;
        this.address = address;
    }
}
