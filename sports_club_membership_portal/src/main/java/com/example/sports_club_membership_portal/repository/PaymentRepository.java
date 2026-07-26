package com.example.sports_club_membership_portal.repository;

import com.example.sports_club_membership_portal.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByMemberMemberId(Integer memberId);
}
