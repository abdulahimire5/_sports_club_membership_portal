package com.example.sports_club_membership_portal.repository;

import com.example.sports_club_membership_portal.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    List<Attendance> findByMemberMemberId(Integer memberId);
    boolean existsByMemberMemberIdAndTrainingSessionId(Integer memberId, Long trainingSessionId);
}
