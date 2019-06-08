package pl.pjatk.mas.project.control.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@Table(name = "PROMOTIONS")
@Entity
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "DISCOUNT_PERCENT")
    private Integer discountPercent;

    @Enumerated(EnumType.STRING)
    @Column(name = "EVENT_TYPE")
    private Event.EventType type;

    @Builder
    public Promotion(Integer discountPercent, Event.EventType type) {
        this.discountPercent = discountPercent;
        this.type = type;
    }
}