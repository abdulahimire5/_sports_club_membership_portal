package com.example.sports_club_membership_portal.service;
import com.example.sports_club_membership_portal.dto.RenewalRequestDTO;
import com.example.sports_club_membership_portal.dto.RenewalResponseDTO;
import com.example.sports_club_membership_portal.entity.Renewal;
import com.example.sports_club_membership_portal.exception.ResourceNotFoundException;
import com.example.sports_club_membership_portal.repository.RenewalRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class RenewalService {

        @Autowired
        private RenewalRepository renewalRepository;

        // Get All Renewals
        public List<RenewalResponseDTO> getAllRenewals() {
            return renewalRepository.findAll()
                    .stream()
                    .map(RenewalResponseDTO::fromEntity)
                    .toList();
        }

        // Get Renewal By ID
        public RenewalResponseDTO getRenewalById(Long id) {
            return renewalRepository.findById(id)
                    .map(RenewalResponseDTO::fromEntity)
                    .orElseThrow(() ->
                            new ResourceNotFoundException("Renewal not found with ID: " + id));
        }

        // Create Renewal
        public RenewalResponseDTO createRenewal(RenewalRequestDTO requestDTO) {
            Renewal renewal = requestDTO.toEntity();
            Renewal savedRenewal = renewalRepository.save(renewal);
            return RenewalResponseDTO.fromEntity(savedRenewal);
        }

        // Update
}
