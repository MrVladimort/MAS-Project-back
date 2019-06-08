package pl.pjatk.mas.project.control.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@Table(name = "LOCALIZATIONS")
@Entity
public class Localization {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
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
    public Localization(String text, String city, String street, String buildingNumber) {
        this.text = text;
        this.city = city;
        this.street = street;
        this.buildingNumber = buildingNumber;
    }
}