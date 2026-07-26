package com.example.sports_club_membership_portal.controller;

import com.example.sports_club_membership_portal.dto.PaymentRequestDTO;
import com.example.sports_club_membership_portal.dto.PaymentResponseDTO;
import com.example.sports_club_membership_portal.service.PaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;
    @GetMapping public List<PaymentResponseDTO> getAll() { return paymentService.getAll(); }
    @GetMapping("/member/{memberId}") public List<PaymentResponseDTO> getByMember(@PathVariable Integer memberId) { return paymentService.getByMember(memberId); }
    @PostMapping public PaymentResponseDTO create(@Valid @RequestBody PaymentRequestDTO request) { return paymentService.create(request); }
    @PutMapping("/{id}") public PaymentResponseDTO update(@PathVariable Long id, @Valid @RequestBody PaymentRequestDTO request) { return paymentService.update(id, request); }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id) { paymentService.delete(id); }
}
