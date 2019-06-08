package pl.pjatk.mas.project.control.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@Table(name = "TICKETS")
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "PLACE_NUMBER", nullable = false)
    private Integer placeNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE", nullable = false)
    private TicketType type;

    @Column(name = "PRICE", nullable = false)
    private Double price;

    public enum TicketType {
        VIP, REGULAR, FAN_ZONE
    }

    @Builder
    public Ticket(Integer placeNumber, TicketType type, Double price) {
        this.placeNumber = placeNumber;
        this.type = type;
        this.price = price;
    }
}