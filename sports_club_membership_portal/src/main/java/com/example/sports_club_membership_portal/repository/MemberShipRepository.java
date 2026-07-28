package com.example.sports_club_membership_portal.repository;

import com.example.sports_club_membership_portal.entity.MemberShip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberShipRepository extends JpaRepository<MemberShip,Integer> {
    Optional<MemberShip> findFirstByMemberMemberIdAndStatusIgnoreCaseOrderByEndDateDesc(Integer memberId, String status);

}
