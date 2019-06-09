package pl.pjatk.mas.project.boundary;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.mas.project.boundary.dto.*;
import pl.pjatk.mas.project.control.security.CurrentUser;
import pl.pjatk.mas.project.control.security.UserPrincipal;
import pl.pjatk.mas.project.control.service.AuthService;
import pl.pjatk.mas.project.control.service.EventService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping({"/api/events"})
@RequiredArgsConstructor
@Slf4j
public class EventController {
    @NonNull EventService eventService;

    @GetMapping
    public ResponseEntity<List<EventDTO>> getAllEvents() {
        return ResponseEntity.ok(eventService.getAllEvents());
    }

    @GetMapping("/{eventId}")
    public ResponseEntity<EventDTO> getEventById(@Valid @PathVariable Long eventId) {
        return ResponseEntity.ok(eventService.getEventById(eventId));
    }
}
