package pl.pjatk.mas.project.control.service;

import pl.pjatk.mas.project.boundary.dto.EventDTO;

import java.util.List;

public interface EventService {
    List<EventDTO> getAllEvents();

    EventDTO getEventById(Long eventId);
}
