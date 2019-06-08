package pl.pjatk.mas.project.control.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import pl.pjatk.mas.project.boundary.dto.LoginDTO;
import pl.pjatk.mas.project.boundary.dto.RegisterDTO;
import pl.pjatk.mas.project.boundary.dto.UserDTO;
import pl.pjatk.mas.project.control.dao.UserDAO;
import pl.pjatk.mas.project.control.service.AuthService;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    @NonNull private UserDAO userDao;

    public UserDTO login(LoginDTO loginDTO) {
        log.info("User credentials: {}", loginDTO);
        return null;
    }

    @Override
    public UserDTO register(RegisterDTO registerDTO) {
        log.info("Register data: {}", registerDTO);

        return null;
    }
}
