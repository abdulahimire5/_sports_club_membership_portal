package com.example.sports_club_membership_portal.service;

import com.example.sports_club_membership_portal.dto.EventRequestDTO;
import com.example.sports_club_membership_portal.dto.EventResponseDTO;
import com.example.sports_club_membership_portal.entity.Event;
import com.example.sports_club_membership_portal.exception.ResourceNotFoundException;
import com.example.sports_club_membership_portal.repository.EventRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<EventResponseDTO> getAllEvents() {
        return eventRepository.findAll().stream()
                .map(EventResponseDTO::fromEntity)
                .toList();
    }

    public EventResponseDTO getEventById(Integer id) {
        return eventRepository.findById(id)
                .map(EventResponseDTO::fromEntity)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found with ID: " + id));
    }

    public EventResponseDTO createEvent(EventRequestDTO requestDTO) {
        Event event = requestDTO.toEntity();
        Event saved = eventRepository.save(event);
        return EventResponseDTO.fromEntity(saved);
    }

    public EventResponseDTO updateEvent(Integer id, EventRequestDTO requestDTO) {
        Event existing = eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found with ID: " + id));

        existing.setEventName(requestDTO.getEventName());
        existing.setEventDate(requestDTO.getEventDate());
        existing.setStartTime(requestDTO.getStartTime());
        existing.setEndTime(requestDTO.getEndTime());
        existing.setLocation(requestDTO.getLocation());
        existing.setDescription(requestDTO.getDescription());

        Event saved = eventRepository.save(existing);
        return EventResponseDTO.fromEntity(saved);
    }

    public void deleteEvent(Integer id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found with ID: " + id));
        eventRepository.delete(event);
    }
}
