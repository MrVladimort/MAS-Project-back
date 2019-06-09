package pl.pjatk.mas.project.control.entity;

import lombok.*;
import pl.pjatk.mas.project.control.entity.enums.TicketType;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TicketEntity extends AuditingEntity {
    @Id
    @Column(name = "TICKET_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TICKET_SQ")
    @SequenceGenerator(name = "TICKET_SQ", sequenceName = "TICKETS_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "PLACE_NUMBER", nullable = false)
    private Integer placeNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE", nullable = false)
    private TicketType type;

    @Column(name = "PRICE", nullable = false)
    private Integer price;

    @ManyToOne(targetEntity = EventEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "EVENT_ID", referencedColumnName = "EVENT_ID")
    @EqualsAndHashCode.Exclude
    private EventEntity event;

    @ManyToOne(targetEntity = AttenderEntity.class)
    @JoinColumn(name = "ATTENDER_ID", referencedColumnName = "ATTENDER_ID")
    @EqualsAndHashCode.Exclude
    private AttenderEntity attender;

    @ManyToOne(targetEntity = OrderEntity.class)
    @JoinColumn(name = "ORDER_ID", referencedColumnName = "ORDER_ID")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private OrderEntity order;

    public void addEvent(EventEntity entity) {
        setPlaceNumber(entity.getTickets().size() + 1);
        setEvent(entity);
        entity.getTickets().add(this);
    }

    @Builder
    public TicketEntity(Integer placeNumber, TicketType type, Integer price, EventEntity event, AttenderEntity attender, OrderEntity order) {
        this.placeNumber = placeNumber;
        this.type = type;
        this.price = price;
        this.event = event;
        this.attender = attender;
        this.order = order;
    }
}