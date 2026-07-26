package com.example.sports_club_membership_portal.controller;

import com.example.sports_club_membership_portal.dto.AttendanceRequestDTO;
import com.example.sports_club_membership_portal.dto.AttendanceResponseDTO;
import com.example.sports_club_membership_portal.service.AttendanceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attendance")
@RequiredArgsConstructor
public class AttendanceController {
    private final AttendanceService attendanceService;
    @GetMapping public List<AttendanceResponseDTO> getAll() { return attendanceService.getAll(); }
    @GetMapping("/member/{memberId}") public List<AttendanceResponseDTO> getByMember(@PathVariable Integer memberId) { return attendanceService.getByMember(memberId); }
    @PostMapping public AttendanceResponseDTO create(@Valid @RequestBody AttendanceRequestDTO request) { return attendanceService.create(request); }
    @PatchMapping("/{id}/status") public AttendanceResponseDTO updateStatus(@PathVariable Long id, @RequestParam String status) { return attendanceService.updateStatus(id, status); }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id) { attendanceService.delete(id); }
}
