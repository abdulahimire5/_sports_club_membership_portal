package com.example.sports_club_membership_portal.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AttendanceRequestDTO {
    @NotNull(message = "Member ID is required")
    private Integer memberId;

    @NotNull(message = "Training session ID is required")
    private Long trainingSessionId;

    private String status = "BOOKED";
}
