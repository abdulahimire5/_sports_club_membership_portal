package com.example.sports_club_membership_portal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class MembershipValidityResponseDTO {
    private Integer memberId;
    private Integer membershipId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String membershipStatus;
    private long daysRemaining;
    private boolean canBook;
    private boolean renewalRequired;
}
