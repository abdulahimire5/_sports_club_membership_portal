package com.example.sports_club_membership_portal.service;

import com.example.sports_club_membership_portal.dto.AttendanceRequestDTO;
import com.example.sports_club_membership_portal.dto.AttendanceResponseDTO;
import com.example.sports_club_membership_portal.entity.Attendance;
import com.example.sports_club_membership_portal.entity.Member;
import com.example.sports_club_membership_portal.entity.trainingsession;
import com.example.sports_club_membership_portal.exception.ResourceNotFoundException;
import com.example.sports_club_membership_portal.repository.AttendanceRepository;
import com.example.sports_club_membership_portal.repository.MemberRepository;
import com.example.sports_club_membership_portal.repository.TrainingSessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendanceService {
    private final AttendanceRepository attendanceRepository;
    private final MemberRepository memberRepository;
    private final TrainingSessionRepository trainingSessionRepository;

    public List<AttendanceResponseDTO> getAll() {
        return attendanceRepository.findAll().stream().map(AttendanceResponseDTO::fromEntity).toList();
    }

    public List<AttendanceResponseDTO> getByMember(Integer memberId) {
        return attendanceRepository.findByMemberMemberId(memberId).stream().map(AttendanceResponseDTO::fromEntity).toList();
    }

    public AttendanceResponseDTO create(AttendanceRequestDTO request) {
        if (attendanceRepository.existsByMemberMemberIdAndTrainingSessionId(request.getMemberId(), request.getTrainingSessionId())) {
            throw new IllegalArgumentException("This member already has a booking for the training session");
        }
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new ResourceNotFoundException("Member not found: " + request.getMemberId()));
        trainingsession session = trainingSessionRepository.findById(request.getTrainingSessionId())
                .orElseThrow(() -> new ResourceNotFoundException("Training session not found: " + request.getTrainingSessionId()));
        Attendance attendance = new Attendance(null, member, session, request.getStatus(), LocalDateTime.now());
        return AttendanceResponseDTO.fromEntity(attendanceRepository.save(attendance));
    }

    public AttendanceResponseDTO updateStatus(Long id, String status) {
        Attendance attendance = attendanceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Attendance not found: " + id));
        attendance.setStatus(status);
        return AttendanceResponseDTO.fromEntity(attendanceRepository.save(attendance));
    }

    public void delete(Long id) {
        if (!attendanceRepository.existsById(id)) throw new ResourceNotFoundException("Attendance not found: " + id);
        attendanceRepository.deleteById(id);
    }
}
