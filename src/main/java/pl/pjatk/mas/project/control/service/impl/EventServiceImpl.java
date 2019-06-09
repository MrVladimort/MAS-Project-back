package pl.pjatk.mas.project.control.service.impl;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import pl.pjatk.mas.project.boundary.dto.EventDTO;
import pl.pjatk.mas.project.control.dao.EventDAO;
import pl.pjatk.mas.project.control.entity.AdminEntity;
import pl.pjatk.mas.project.control.entity.ClientEntity;
import pl.pjatk.mas.project.control.entity.EventEntity;
import pl.pjatk.mas.project.control.mapper.ProjectMapper;
import pl.pjatk.mas.project.control.service.EventService;
import pl.pjatk.mas.project.controller.exceptions.EntityNotFoundException;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Slf4j
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    @NonNull EventDAO eventDao;
    @NonNull ProjectMapper mapper;

    @Override
    public List<EventDTO> getAllEvents() {
        List<EventEntity> interviewEntities = StreamSupport.stream(eventDao.findAll().spliterator(), false).collect(Collectors.toList());

        log.info("Events: {}", interviewEntities);

        return interviewEntities.stream()
                .map(mapper::eventEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public EventDTO getEventById(Long eventId) {
        EventEntity interviewEntity = eventDao.findById(eventId).orElseThrow(EntityNotFoundException::new);
        log.info("Event: {}", interviewEntity);

        return mapper.eventEntityToDto(interviewEntity);
    }
}
