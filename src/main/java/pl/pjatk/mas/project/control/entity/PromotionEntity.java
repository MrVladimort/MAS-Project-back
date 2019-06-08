package pl.pjatk.mas.project.control.entity;

import lombok.*;
import pl.pjatk.mas.project.control.entity.enums.EventType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PromotionEntity extends AuditingEntity {
    @Id
    @Column(name = "PROMOTION_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROMOTION_SQ")
    @SequenceGenerator(name = "PROMOTION_SQ", sequenceName = "PROMOTIONS_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "DISCOUNT_PERCENT")
    private Integer discountPercent;

    @Column(name = "EVENT_TYPES")
    @Enumerated(EnumType.STRING)
    @ElementCollection
    private Set<EventType> types = new HashSet<>();

    @ManyToOne(targetEntity = ClientEntity.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private ClientEntity client;

    @Builder
    public PromotionEntity(Integer discountPercent, Set<EventType> types, ClientEntity client) {
        this.discountPercent = discountPercent;
        this.types = types;
        this.client = client;
    }
}