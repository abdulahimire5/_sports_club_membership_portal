package com.example.sports_club_membership_portal.service;

import com.example.sports_club_membership_portal.dto.PaymentRequestDTO;
import com.example.sports_club_membership_portal.dto.PaymentResponseDTO;
import com.example.sports_club_membership_portal.entity.Member;
import com.example.sports_club_membership_portal.entity.Payment;
import com.example.sports_club_membership_portal.exception.ResourceNotFoundException;
import com.example.sports_club_membership_portal.repository.MemberRepository;
import com.example.sports_club_membership_portal.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final MemberRepository memberRepository;

    public List<PaymentResponseDTO> getAll() { return paymentRepository.findAll().stream().map(PaymentResponseDTO::fromEntity).toList(); }
    public List<PaymentResponseDTO> getByMember(Integer memberId) { return paymentRepository.findByMemberMemberId(memberId).stream().map(PaymentResponseDTO::fromEntity).toList(); }

    public PaymentResponseDTO create(PaymentRequestDTO request) {
        Member member = getMember(request.getMemberId());
        Payment payment = new Payment(null, member, request.getAmount(), request.getPaymentDate(), request.getPaymentMethod(), request.getStatus());
        return PaymentResponseDTO.fromEntity(paymentRepository.save(payment));
    }

    public PaymentResponseDTO update(Long id, PaymentRequestDTO request) {
        Payment payment = paymentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Payment not found: " + id));
        payment.setMember(getMember(request.getMemberId()));
        payment.setAmount(request.getAmount());
        payment.setPaymentDate(request.getPaymentDate());
        payment.setPaymentMethod(request.getPaymentMethod());
        payment.setStatus(request.getStatus());
        return PaymentResponseDTO.fromEntity(paymentRepository.save(payment));
    }

    public void delete(Long id) {
        if (!paymentRepository.existsById(id)) throw new ResourceNotFoundException("Payment not found: " + id);
        paymentRepository.deleteById(id);
    }

    private Member getMember(Integer id) { return memberRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Member not found: " + id)); }
}
