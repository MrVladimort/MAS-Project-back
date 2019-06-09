package pl.pjatk.mas.project.control.entity;

import lombok.*;
import pl.pjatk.mas.project.control.entity.enums.EventType;

import javax.persistence.*;

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

    @Column(name = "EVENT_TYPE")
    @Enumerated(EnumType.STRING)
    private EventType type;

    @ManyToOne(targetEntity = ClientEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private ClientEntity client;

    @Builder
    public PromotionEntity(Integer discountPercent, EventType type, ClientEntity client) {
        this.discountPercent = discountPercent;
        this.type = type;
        this.client = client;
    }
}