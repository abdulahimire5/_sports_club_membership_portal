package com.example.sports_club_membership_portal.dto;
import com.example.sports_club_membership_portal.entity.Renewal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data

public class RenewalResponseDTO {




        private Long id;
        private Long memberId;
        private LocalDate renewalDate;
        private LocalDate expiryDate;
        private Double amount;
        private String paymentStatus;

        public RenewalResponseDTO() {
        }

        public RenewalResponseDTO(Long id, Long memberId, LocalDate renewalDate,
                                  LocalDate expiryDate, Double amount,
                                  String paymentStatus) {
            this.id = id;
            this.memberId = memberId;
            this.renewalDate = renewalDate;
            this.expiryDate = expiryDate;
            this.amount = amount;
            this.paymentStatus = paymentStatus;
        }

        public static RenewalResponseDTO fromEntity(Renewal renewal) {
            RenewalResponseDTO dto = new RenewalResponseDTO();
            dto.setId(renewal.getId());
            dto.setMemberId(renewal.getMemberId());
            dto.setRenewalDate(renewal.getRenewalDate());
            dto.setExpiryDate(renewal.getExpiryDate());
            dto.setAmount(renewal.getAmount());
            dto.setPaymentStatus(renewal.getPaymentStatus());
            return dto;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Long getMemberId() {
            return memberId;
        }

        public void setMemberId(Long memberId) {
            this.memberId = memberId;
        }

        public LocalDate getRenewalDate() {
            return renewalDate;
        }

        public void setRenewalDate(LocalDate renewalDate) {
            this.renewalDate = renewalDate;
        }

        public LocalDate getExpiryDate() {
            return expiryDate;
        }

        public void setExpiryDate(LocalDate expiryDate) {
            this.expiryDate = expiryDate;
        }

        public Double getAmount() {
            return amount;
        }

        public void setAmount(Double amount) {
            this.amount = amount;
        }

        public String getPaymentStatus() {
            return paymentStatus;
        }

        public void setPaymentStatus(String paymentStatus) {
            this.paymentStatus = getPaymentStatus();
        }}
