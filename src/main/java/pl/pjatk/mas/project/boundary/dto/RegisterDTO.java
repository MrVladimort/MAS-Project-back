package pl.pjatk.mas.project.boundary.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class RegisterDTO {
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @NotBlank
    private String email;
    private String phone;
    @NotBlank
    private String password;
    @NotBlank
    private String repeatPassword;

    @Builder
    public RegisterDTO(String name, String surname, String email, String phone, String password, String repeatPassword) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.repeatPassword = repeatPassword;
    }
}
