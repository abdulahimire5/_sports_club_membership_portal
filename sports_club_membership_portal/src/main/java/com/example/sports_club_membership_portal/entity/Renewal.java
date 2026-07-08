package com.example.sports_club_membership_portal.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Entity
@Data




@Table(name = "renewals")
public class Renewal {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotNull(message = "Member ID is required")
        @Column(nullable = false)
        private Long memberId;

        @NotNull(message = "Renewal date is required")
        @Column(nullable = false)
        private LocalDate renewalDate;

        @NotNull(message = "Expiry date is required")
        @FutureOrPresent(message = "Expiry date must be today or in the future")
        @Column(nullable = false)
        private LocalDate expiryDate;

        @NotNull(message = "Amount is required")
        @Column(nullable = false)
        private Double amount;

        @Column(nullable = false)
        private String paymentStatus;

        public Renewal() {
        }

        public Renewal(Long id, Long memberId, LocalDate renewalDate,
                       LocalDate expiryDate, Double amount,
                       String paymentStatus) {
            this.id = id;
            this.memberId = memberId;
            this.renewalDate = renewalDate;
            this.expiryDate = expiryDate;
            this.amount = amount;
            this.paymentStatus = paymentStatus;
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
            this.paymentStatus = paymentStatus;
        }
    }

