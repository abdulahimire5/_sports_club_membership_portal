package com.example.sports_club_membership_portal.controller;

import com.example.sports_club_membership_portal.dto.EventRequestDTO;
import com.example.sports_club_membership_portal.dto.EventResponseDTO;
import com.example.sports_club_membership_portal.service.EventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping
    public List<EventResponseDTO> getAll() {
        return eventService.getAllEvents();
    }

    @GetMapping("/{id}")
    public EventResponseDTO getOne(@PathVariable Integer id) {
        return eventService.getEventById(id);
    }

    @PostMapping
    public EventResponseDTO create(@Valid @RequestBody EventRequestDTO requestDTO) {
        return eventService.createEvent(requestDTO);
    }

    @PutMapping("/{id}")
    public EventResponseDTO update(@PathVariable Integer id, @Valid @RequestBody EventRequestDTO requestDTO) {
        return eventService.updateEvent(id, requestDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        eventService.deleteEvent(id);
    }
}
