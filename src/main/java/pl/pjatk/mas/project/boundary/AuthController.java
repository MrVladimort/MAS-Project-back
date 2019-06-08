package pl.pjatk.mas.project.boundary;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.mas.project.boundary.dto.LoginDTO;
import pl.pjatk.mas.project.boundary.dto.RegisterDTO;
import pl.pjatk.mas.project.boundary.dto.UserDTO;
import pl.pjatk.mas.project.control.service.AuthService;

@RestController
@RequestMapping({"/api/auth"})
@RequiredArgsConstructor
@Slf4j
public class AuthController {
    @NonNull AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody LoginDTO loginDto) {
        return ResponseEntity.ok(authService.login(loginDto));

    }

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@RequestBody RegisterDTO registerDto) {
        return ResponseEntity.ok(authService.register(registerDto));
    }
}
