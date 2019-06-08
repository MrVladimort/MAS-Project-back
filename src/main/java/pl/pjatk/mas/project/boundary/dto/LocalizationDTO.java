package pl.pjatk.mas.project.boundary.dto;

import lombok.*;

import javax.persistence.Column;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LocalizationDTO {
    private String text;
    private String city;
    private String street;
    private String buildingNumber;
}
