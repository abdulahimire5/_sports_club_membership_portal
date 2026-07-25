package com.example.sports_club_membership_portal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResponseDTO {

    private Long paymentId;

    private Double amount;

    private LocalDate paymentDate;

    private String status;

    private Long memberId;

    private String memberName;
}