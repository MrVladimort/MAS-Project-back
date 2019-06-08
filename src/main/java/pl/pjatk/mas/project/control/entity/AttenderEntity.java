package pl.pjatk.mas.project.control.entity;

import lombok.*;
import pl.pjatk.mas.project.control.entity.enums.DocumentType;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AttenderEntity extends PersonEntity {
    @Id
    @Column(name = "ATTENDER_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ATTENDER_SQ")
    @SequenceGenerator(name = "ATTENDER_SQ", sequenceName = "ATTENDERS_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "BIRTHDATE", nullable = false)
    private LocalDate birthdate;

    @Column(name = "DOCUMENT_NUMBER", nullable = false)
    private String documentNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "DOCUMENT_TYPE", nullable = false)
    private DocumentType street;

    @OneToMany(
            targetEntity = TicketEntity.class,
            mappedBy = "attender",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<TicketEntity> tickets = new HashSet<>();

    @ManyToOne(targetEntity = ClientEntity.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private ClientEntity client;

    @Builder
    public AttenderEntity(String name, String surname, LocalDate birthdate, String documentNumber, DocumentType street, Set<TicketEntity> tickets, ClientEntity client) {
        super(name, surname);
        this.birthdate = birthdate;
        this.documentNumber = documentNumber;
        this.street = street;
        this.tickets = tickets;
        this.client = client;
    }
}