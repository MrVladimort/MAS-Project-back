package pl.pjatk.mas.project.control.entity;

import lombok.*;
import pl.pjatk.mas.project.control.entity.enums.DocumentType;

import javax.persistence.*;
import java.time.LocalDate;

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

    @Builder
    public AttenderEntity(String name, String surname, LocalDate birthdate, String documentNumber, DocumentType street) {
        super(name, surname);
        this.birthdate = birthdate;
        this.documentNumber = documentNumber;
        this.street = street;
    }
}