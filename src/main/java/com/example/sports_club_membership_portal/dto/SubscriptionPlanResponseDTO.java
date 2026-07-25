package com.example.sports_club_membership_portal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionPlanResponseDTO {

    private String planName;

    private Integer durationMonths;

    private BigDecimal price;

    private String description;
}
