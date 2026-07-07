package com.example.sports_club_membership_portal.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberShipRequestDTO {

        @NotNull(message = "memberID is required")
        private Integer memberID;

        @NotNull(message = "planID is required")
        private Integer planID;

        @NotNull(message = "startDate is required")
        private LocalDate startDate;

        @NotNull(message = "endDate is required")
        private LocalDate endDate;

        @NotBlank(message = "status is required")
        private String status;

}
