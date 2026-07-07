package com.example.sports_club_membership_portal.repository;

import com.example.sports_club_membership_portal.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Integer> {
        Optional<Member> findByEmail(String email);
    }


