package com.example.sports_club_membership_portal.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class PaymentRequestDTO {
    @NotNull(message = "Member ID is required")
    private Integer memberId;
    @NotNull(message = "Amount is required")
    private BigDecimal amount;
    @NotNull(message = "Payment date is required")
    private LocalDate paymentDate;
    @NotBlank(message = "Payment method is required")
    private String paymentMethod;
    @NotBlank(message = "Status is required")
    private String status;
}
