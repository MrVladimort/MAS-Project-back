package pl.pjatk.mas.project.control.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString
@NoArgsConstructor
@Table(name = "ATTENDERS")
@Entity
public class Attender extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "BIRTHDATE", nullable = false)
    private LocalDate birthdate;

    @Column(name = "DOCUMENT_NUMBER", nullable = false)
    private String documentNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "DOCUMENT_TYPE", nullable = false)
    private DocumentType street;

    public enum DocumentType {
        PASSPORT,
        ID_CARD,
        DRIVER_LICENCE
    }

    @Builder
    public Attender(String name, String surname, LocalDate birthdate, String documentNumber, DocumentType street) {
        super(name, surname);
        this.birthdate = birthdate;
        this.documentNumber = documentNumber;
        this.street = street;
    }
}