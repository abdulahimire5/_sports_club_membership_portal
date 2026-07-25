package com.example.sports_club_membership_portal.service;

import com.example.sports_club_membership_portal.repository.AttendanceRepository;
import com.example.sports_club_membership_portal.entity.Attendance;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.sports_club_membership_portal.exception.ResourceNotFoundException;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;
    public List<Attendance> getAllAttendance() {
        return attendanceRepository.findAll();


    }
    public Attendance getAttendanceById(Long id) {
        return attendanceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Attendance not found: " + id));

    }
    public Attendance createAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);

    }

    public Attendance updateAttendance(Long id, Attendance updatedAttendance) {
        Attendance existing = getAttendanceById(id);

        existing.setAttendanceDate(updatedAttendance.getAttendanceDate());
        existing.setStatus(updatedAttendance.getStatus());
        existing.setMember(updatedAttendance.getMember());

        return attendanceRepository.save(existing);
    }
    public void deleteAttendance(Long id) {
        attendanceRepository.deleteById(id);
    }

}