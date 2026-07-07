package com.example.sports_club_membership_portal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.sports_club_membership_portal.entity.Event;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventResponseDTO {

    private Integer eventID;
    private String eventName;
    private LocalDate eventDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private String location;
    private String description;

    public static EventResponseDTO fromEntity(Event event) {
        if (event == null) return null;
        EventResponseDTO dto = new EventResponseDTO();
        dto.setEventID(event.getEventID());
        dto.setEventName(event.getEventName());
        dto.setEventDate(event.getEventDate());
        dto.setStartTime(event.getStartTime());
        dto.setEndTime(event.getEndTime());
        dto.setLocation(event.getLocation());
        dto.setDescription(event.getDescription());
        return dto;
    }
}
