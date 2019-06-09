package pl.pjatk.mas.project.control.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
    private String name;

    @Column(name = "CITY", nullable = false)
    private String city;

    @Column(name = "STREET", nullable = false)
    private String street;

    @Column(name = "BUILDING_NUMBER", nullable = false)
    private String buildingNumber;

    @OneToMany(targetEntity = EventEntity.class, mappedBy = "localization", cascade = CascadeType.MERGE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<EventEntity> events = new HashSet<>();

    @Builder
    public LocalizationEntity(String name, String city, String street, String buildingNumber) {
        this.name = name;
        this.city = city;
        this.street = street;
        this.buildingNumber = buildingNumber;
    }
}