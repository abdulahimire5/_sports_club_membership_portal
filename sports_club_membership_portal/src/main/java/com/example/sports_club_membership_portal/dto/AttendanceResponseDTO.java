package com.example.sports_club_membership_portal.dto;

import com.example.sports_club_membership_portal.entity.Attendance;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AttendanceResponseDTO {
    private Long id;
    private Integer memberId;
    private Long trainingSessionId;
    private String status;
    private LocalDateTime bookedAt;

    public static AttendanceResponseDTO fromEntity(Attendance attendance) {
        AttendanceResponseDTO dto = new AttendanceResponseDTO();
        dto.setId(attendance.getId());
        dto.setMemberId(attendance.getMember().getMemberId());
        dto.setTrainingSessionId(attendance.getTrainingSession().getId());
        dto.setStatus(attendance.getStatus());
        dto.setBookedAt(attendance.getBookedAt());
        return dto;
    }
}
