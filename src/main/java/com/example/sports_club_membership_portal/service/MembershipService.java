package com.example.sports_club_membership_portal.service;

import com.example.sports_club_membership_portal.dto.MemberShipRequestDTO;
import com.example.sports_club_membership_portal.dto.MemberShipResponseDTO;
import com.example.sports_club_membership_portal.entity.Member;
import com.example.sports_club_membership_portal.entity.MemberShip;
import com.example.sports_club_membership_portal.entity.SubscriptionPlan;
import com.example.sports_club_membership_portal.exception.ResourceNotFoundException;
import com.example.sports_club_membership_portal.repository.MemberRepository;
import com.example.sports_club_membership_portal.repository.MemberShipRepository;
import com.example.sports_club_membership_portal.repository.SubscriptionPlanRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class MembershipService {

        @Autowired
        private MemberShipRepository membershipRepository;

        @Autowired
        private MemberRepository memberRepository;

        @Autowired
        private SubscriptionPlanRepository subscriptionPlanRepository;

        // Get All Memberships
        public List<MemberShipResponseDTO> getAllMemberships() {
            return membershipRepository.findAll().stream()
                    .map(MemberShipResponseDTO::fromEntity)
                    .toList();
        }

        // Get Membership By ID
        public MemberShipResponseDTO getMembershipById(Integer id) {
            return membershipRepository.findById(id)
                    .map(MemberShipResponseDTO::fromEntity)
                    .orElseThrow(() ->
                            new ResourceNotFoundException("Membership not found with ID: " + id));
        }

        // Create Membership
        public MemberShipResponseDTO createMembership(MemberShipRequestDTO requestDTO) {
            Member member = memberRepository.findById(requestDTO.getMemberID())
                    .orElseThrow(() ->
                            new ResourceNotFoundException("Member not found with ID: " + requestDTO.getMemberID()));

            SubscriptionPlan plan = subscriptionPlanRepository.findById(requestDTO.getPlanID())
                    .orElseThrow(() ->
                            new ResourceNotFoundException("Subscription Plan not found with ID: " + requestDTO.getPlanID()));

            MemberShip membership = new MemberShip();
            membership.setMember(member);
            membership.setSubscriptionPlan(plan);
            membership.setStartDate(requestDTO.getStartDate());
            membership.setEndDate(requestDTO.getEndDate());
            membership.setStatus(requestDTO.getStatus());

            MemberShip saved = membershipRepository.save(membership);
            return MemberShipResponseDTO.fromEntity(saved);
        }

        // Update Membership
        public MemberShipResponseDTO updateMembership(Integer id, MemberShipRequestDTO requestDTO) {
            MemberShip existing = membershipRepository.findById(id)
                    .orElseThrow(() ->
                            new ResourceNotFoundException("Membership not found with ID: " + id));

            Member member = memberRepository.findById(requestDTO.getMemberID())
                    .orElseThrow(() ->
                            new ResourceNotFoundException("Member not found with ID: " + requestDTO.getMemberID()));

            SubscriptionPlan plan = subscriptionPlanRepository.findById(requestDTO.getPlanID())
                    .orElseThrow(() ->
                            new ResourceNotFoundException("Subscription Plan not found with ID: " + requestDTO.getPlanID()));

            existing.setMember(member);
            existing.setSubscriptionPlan(plan);
            existing.setStartDate(requestDTO.getStartDate());
            existing.setEndDate(requestDTO.getEndDate());
            existing.setStatus(requestDTO.getStatus());

            MemberShip saved = membershipRepository.save(existing);
            return MemberShipResponseDTO.fromEntity(saved);
        }

        // Delete Membership
        public void deleteMembership(Integer id) {
            MemberShip membership = membershipRepository.findById(id)
                    .orElseThrow(() ->
                            new ResourceNotFoundException("Membership not found with ID: " + id));
            membershipRepository.delete(membership);
        }
}
