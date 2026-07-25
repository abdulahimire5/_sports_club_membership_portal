package com.example.sports_club_membership_portal.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "SubscriptionPlans")
public class SubscriptionPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer planId;
    @Column(nullable = false)
    private String planName;
    @Column(nullable = false)
    private Integer durationMonths;
    @Column(nullable = false)
    private BigDecimal price;
    private String description;

}
