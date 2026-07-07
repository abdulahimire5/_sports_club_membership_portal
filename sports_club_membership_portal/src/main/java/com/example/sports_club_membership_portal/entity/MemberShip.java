package com.example.sports_club_membership_portal.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Memberships")
public class MemberShip {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "MembershipID")
        private Integer membershipID;

        @ManyToOne
        @JoinColumn(name = "MemberID", nullable = false)
        private Member member;

        @ManyToOne
        @JoinColumn(name = "PlanID", nullable = false)
        private SubscriptionPlan subscriptionPlan;

        @Column(name = "StartDate")
        private LocalDate startDate;

        @Column(name = "EndDate")
        private LocalDate endDate;

        @Column(name = "Status")
        private String status;

    }

