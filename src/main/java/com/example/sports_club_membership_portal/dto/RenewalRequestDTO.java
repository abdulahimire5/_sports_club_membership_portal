package com.example.sports_club_membership_portal.dto;
import com.example.sports_club_membership_portal.entity.Renewal;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class RenewalRequestDTO {


        @NotNull(message = "Member ID is required")
        private Long memberId;

        @NotNull(message = "Renewal date is required")
        private LocalDate renewalDate;

        @NotNull(message = "Expiry date is required")
        @FutureOrPresent(message = "Expiry date must be today or in the future")
        private LocalDate expiryDate;

        @NotNull(message = "Amount is required")
        private Double amount;

        @NotNull(message = "Payment status is required")
        private String paymentStatus;

        public RenewalRequestDTO() {
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
            this.paymentStatus = paymentStatus;
        }

        public Renewal toEntity() {
            Renewal renewal = new Renewal();
            renewal.setMemberId(this.memberId);
            renewal.setRenewalDate(this.renewalDate);
            renewal.setExpiryDate(this.expiryDate);
            renewal.setAmount(this.amount);
            renewal.setPaymentStatus(this.paymentStatus);
            return renewal;
        }
    }

