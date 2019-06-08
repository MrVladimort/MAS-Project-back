package pl.pjatk.mas.project.boundary.dto;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDTO {
    private String name;
    private String surname;
    private String email;
    private String password;
    private String repeatPassword;
}
