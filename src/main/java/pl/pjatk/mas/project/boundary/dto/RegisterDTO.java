package pl.pjatk.mas.project.boundary.dto;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class RegisterDTO {
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String password;
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
