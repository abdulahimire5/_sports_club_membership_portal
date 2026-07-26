package com.example.sports_club_membership_portal.dto;

import com.example.sports_club_membership_portal.entity.Payment;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class PaymentResponseDTO {
    private Long id;
    private Integer memberId;
    private BigDecimal amount;
    private LocalDate paymentDate;
    private String paymentMethod;
    private String status;

    public static PaymentResponseDTO fromEntity(Payment payment) {
        PaymentResponseDTO dto = new PaymentResponseDTO();
        dto.setId(payment.getId());
        dto.setMemberId(payment.getMember().getMemberId());
        dto.setAmount(payment.getAmount());
        dto.setPaymentDate(payment.getPaymentDate());
        dto.setPaymentMethod(payment.getPaymentMethod());
        dto.setStatus(payment.getStatus());
        return dto;
    }
}
