package pl.pjatk.mas.project.control.service;

import pl.pjatk.mas.project.boundary.dto.LoginDTO;
import pl.pjatk.mas.project.boundary.dto.RegisterDTO;
import pl.pjatk.mas.project.boundary.dto.UserDTO;

public interface AuthService {
    UserDTO login(LoginDTO loginDTO);
    UserDTO register(RegisterDTO registerDTO);
}
