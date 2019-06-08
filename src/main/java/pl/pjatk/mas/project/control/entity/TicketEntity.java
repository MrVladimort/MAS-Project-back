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
    private Double price;

    @Builder
    public TicketEntity(Integer placeNumber, TicketType type, Double price) {
        this.placeNumber = placeNumber;
        this.type = type;
        this.price = price;
    }
}