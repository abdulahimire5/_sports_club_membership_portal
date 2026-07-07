package com.example.sports_club_membership_portal.repository;

import com.example.sports_club_membership_portal.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;



public interface MemberRepository extends JpaRepository<Member, Integer> {
    }


