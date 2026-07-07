package com.example.sports_club_membership_portal.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.sports_club_membership_portal.entity.Event;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventRequestDTO {

    @NotBlank(message = "eventName is required")
    private String eventName;

    @NotNull(message = "eventDate is required")
    private LocalDate eventDate;

    private LocalTime startTime;

    private LocalTime endTime;

    private String location;

    private String description;

    public Event toEntity() {
        Event event = new Event();
        event.setEventName(this.eventName);
        event.setEventDate(this.eventDate);
        event.setStartTime(this.startTime);
        event.setEndTime(this.endTime);
        event.setLocation(this.location);
        event.setDescription(this.description);
        return event;
    }
}
