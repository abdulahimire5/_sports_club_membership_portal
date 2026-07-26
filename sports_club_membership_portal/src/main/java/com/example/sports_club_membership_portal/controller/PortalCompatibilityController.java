package com.example.sports_club_membership_portal.controller;

import com.example.sports_club_membership_portal.dto.EventRequestDTO;
import com.example.sports_club_membership_portal.dto.EventResponseDTO;
import com.example.sports_club_membership_portal.dto.MemberShipResponseDTO;
import com.example.sports_club_membership_portal.dto.PaymentResponseDTO;
import com.example.sports_club_membership_portal.dto.RenewalResponseDTO;
import com.example.sports_club_membership_portal.dto.TrainingSessionRequestDTO;
import com.example.sports_club_membership_portal.dto.TrainingSessionResponseDTO;
import com.example.sports_club_membership_portal.entity.Member;
import com.example.sports_club_membership_portal.entity.SubscriptionPlan;
import com.example.sports_club_membership_portal.repository.AttendanceRepository;
import com.example.sports_club_membership_portal.repository.MemberRepository;
import com.example.sports_club_membership_portal.repository.PaymentRepository;
import com.example.sports_club_membership_portal.service.EventService;
import com.example.sports_club_membership_portal.service.MembershipService;
import com.example.sports_club_membership_portal.service.PaymentService;
import com.example.sports_club_membership_portal.service.RenewalService;
import com.example.sports_club_membership_portal.service.SubscriptionPlanService;
import com.example.sports_club_membership_portal.service.TrainingSessionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/** Routes retained for the frontend that was built against the ZIP backend. */
@RestController
@RequiredArgsConstructor
public class PortalCompatibilityController {
    private final MemberRepository memberRepository;
    private final PaymentRepository paymentRepository;
    private final AttendanceRepository attendanceRepository;
    private final EventService eventService;
    private final TrainingSessionService trainingSessionService;
    private final SubscriptionPlanService subscriptionPlanService;
    private final MembershipService membershipService;
    private final PaymentService paymentService;
    private final RenewalService renewalService;

    @GetMapping("/api/admin/members")
    public List<Member> adminMembers() { return memberRepository.findAll(); }

    @GetMapping("/api/admin/stats")
    public Map<String, Object> stats() {
        BigDecimal totalRevenue = paymentRepository.findAll().stream()
                .filter(payment -> "COMPLETED".equalsIgnoreCase(payment.getStatus()))
                .map(payment -> payment.getAmount())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        Map<String, Object> result = new LinkedHashMap<>();
        result.put("totalMembers", memberRepository.count());
        result.put("activeMemberships", membershipService.getAllMemberships().stream()
                .filter(membership -> "ACTIVE".equalsIgnoreCase(membership.getStatus())).count());
        result.put("totalRevenue", totalRevenue);
        result.put("upcomingEvents", eventService.getAllEvents().size());
        result.put("totalBookings", attendanceRepository.count());
        return result;
    }

    @PostMapping("/api/admin/events")
    public EventResponseDTO createAdminEvent(@Valid @RequestBody EventRequestDTO request) {
        return eventService.createEvent(request);
    }

    @PostMapping("/api/admin/sessions")
    public TrainingSessionResponseDTO createAdminSession(@Valid @RequestBody TrainingSessionRequestDTO request) {
        return trainingSessionService.createTrainingSession(request);
    }

    @GetMapping("/api/sessions")
    public List<TrainingSessionResponseDTO> sessions() { return trainingSessionService.getAllTrainingSessions(); }

    @GetMapping("/api/billing/plans")
    public List<SubscriptionPlan> plans() { return subscriptionPlanService.getAllPlans(); }

    @GetMapping("/api/billing/membership")
    public List<MemberShipResponseDTO> memberships() { return membershipService.getAllMemberships(); }

    @GetMapping("/api/billing/payments")
    public List<PaymentResponseDTO> payments() { return paymentService.getAll(); }

    @GetMapping("/api/billing/renewals")
    public List<RenewalResponseDTO> renewals() { return renewalService.getAllRenewals(); }
}
