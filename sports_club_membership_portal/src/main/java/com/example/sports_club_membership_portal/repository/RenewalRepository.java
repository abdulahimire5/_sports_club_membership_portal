package com.example.sports_club_membership_portal.repository;
import com.example.sports_club_membership_portal.entity.Renewal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository


    public interface RenewalRepository extends JpaRepository<Renewal, Long> {

        // Find all renewals by member ID
        List<Renewal> findByMemberId(Long memberId);

        // Find renewals by payment status
        List<Renewal> findByPaymentStatus(String paymentStatus);

        // Find renewals by renewal date
        List<Renewal> findByRenewalDate(LocalDate renewalDate);

        // Find renewals by expiry date
        List<Renewal> findByExpiryDate(LocalDate expiryDate);

        // Check if a renewal exists for a member
        boolean existsByMemberId(Long memberId);
    }

