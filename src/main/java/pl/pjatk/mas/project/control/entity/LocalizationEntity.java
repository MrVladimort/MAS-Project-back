package pl.pjatk.mas.project.control.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class LocalizationEntity  extends AuditingEntity {
    @Id
    @Column(name = "LOCALIZATION_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LOCALIZATION_SQ")
    @SequenceGenerator(name = "LOCALIZATION_SQ", sequenceName = "LOCALIZATIONS_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "NAME", unique = true)
    private String text;

    @Column(name = "CITY", nullable = false)
    private String city;

    @Column(name = "STREET", nullable = false)
    private String street;

    @Column(name = "BUILDING_NUMBER", nullable = false)
    private String buildingNumber;

    @Builder
    public LocalizationEntity(String text, String city, String street, String buildingNumber) {
        this.text = text;
        this.city = city;
        this.street = street;
        this.buildingNumber = buildingNumber;
    }
}