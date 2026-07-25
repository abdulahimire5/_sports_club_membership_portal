package com.example.sports_club_membership_portal.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionPlanRequestDTO {

    @NotBlank(message = "planName is required")
    private String planName;

    @NotBlank(message = "durationMonths is required")
    private Integer durationMonths;

    @NotBlank(message = "price is required")
    private BigDecimal price;

    @NotBlank(message = "description is required")
    private String description;

}
