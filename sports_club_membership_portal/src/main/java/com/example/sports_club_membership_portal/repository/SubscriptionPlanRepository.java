package com.example.sports_club_membership_portal.repository;

import com.example.sports_club_membership_portal.entity.SubscriptionPlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionPlanRepository extends JpaRepository<SubscriptionPlan, Integer> {
}
