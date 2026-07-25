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
public class PaymentRequestDTO {

    @NotNull(message = "amount is required")
    private Double amount;

    @NotNull(message = "paymentDate is required")
    private LocalDate paymentDate;

    @NotBlank(message = "status is required")
    private String status;

    private Long memberId;
}