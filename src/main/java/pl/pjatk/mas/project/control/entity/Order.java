package pl.pjatk.mas.project.control.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@Table(name = "ORDERS")
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "DATE_TIME", nullable = false)
    private LocalDateTime dateTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "ORDER_STATUS", nullable = false)
    private OrderStatus status = OrderStatus.CONFIRMED;

    public enum OrderStatus {
        CONFIRMED,
        PAID,
        CANCELED,
        REFUNDED,
        REALISED
    }

    @Builder
    public Order(LocalDateTime dateTime, OrderStatus status) {
        this.dateTime = dateTime;
        this.status = status;
    }
}
