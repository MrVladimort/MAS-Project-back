package pl.pjatk.mas.project.control.entity;

import lombok.*;
import pl.pjatk.mas.project.control.entity.enums.OrderStatus;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OrderEntity  extends AuditingEntity {
    @Id
    @Column(name = "ORDER_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDER_SQ")
    @SequenceGenerator(name = "ORDER_SQ", sequenceName = "ORDERS_SEQ", allocationSize = 1)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "ORDER_STATUS", nullable = false)
    private OrderStatus status;

    @Column(name = "TOTAL_PRICE", nullable = false) // Include promotions
    private Double totalPrice;

    @OneToMany(targetEntity = TicketEntity.class, mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    private Set<TicketEntity> tickets = new HashSet<>();

    @ManyToOne(targetEntity = ClientEntity.class)
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    @EqualsAndHashCode.Exclude
    private ClientEntity client;

    public void addTicket(TicketEntity ticket) {
        tickets.add(ticket);
        ticket.setOrder(this);
    }

    public void removeArtist(TicketEntity ticket) {

    }

    @Builder
    public OrderEntity(OrderStatus status, Double totalPrice, ClientEntity client) {
        this.status = status;
        this.totalPrice = totalPrice;
        this.client = client;
    }
}
