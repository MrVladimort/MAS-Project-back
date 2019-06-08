package pl.pjatk.mas.project.control.service;

import pl.pjatk.mas.project.boundary.dto.AdminDTO;
import pl.pjatk.mas.project.boundary.dto.ClientDTO;
import pl.pjatk.mas.project.boundary.dto.LoginDTO;
import pl.pjatk.mas.project.boundary.dto.UserDTO;
import pl.pjatk.mas.project.control.entity.ClientEntity;
import pl.pjatk.mas.project.control.security.UserPrincipal;

public interface AuthService {
    UserDTO login(LoginDTO loginDTO);
    ClientDTO registerClient(ClientDTO clientDto);
    AdminDTO registerAdmin(AdminDTO adminDto);
    UserDTO getUserData(UserPrincipal currentUser);
}
