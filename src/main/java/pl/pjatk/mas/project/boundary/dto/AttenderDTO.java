package pl.pjatk.mas.project.boundary.dto;

import lombok.*;
import pl.pjatk.mas.project.control.entity.Attender;

import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AttenderDTO {
    private Integer age;
    private LocalDate birthdate;
    private String name;
    private String surname;
    private Attender.DocumentType documentType;
    private String documentNumber;
}
