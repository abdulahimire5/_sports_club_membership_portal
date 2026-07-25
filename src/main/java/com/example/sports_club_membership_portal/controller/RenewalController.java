package com.example.sports_club_membership_portal.controller;
import com.example.sports_club_membership_portal.dto.RenewalRequestDTO;
import com.example.sports_club_membership_portal.dto.RenewalResponseDTO;
import com.example.sports_club_membership_portal.service.RenewalService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/renewals")
@RequiredArgsConstructor
public class RenewalController {



        private final RenewalService renewalService;

        @PostMapping
        public RenewalResponseDTO createRenewal(
                @Valid @RequestBody RenewalRequestDTO requestDTO) {
            return renewalService.createRenewal(requestDTO);
        }

        @GetMapping
        public List<RenewalResponseDTO> getAllRenewals() {
            return renewalService.getAllRenewals();
        }

        @GetMapping("/{id}")
        public RenewalResponseDTO getRenewalById(@PathVariable Long id) {
            return renewalService.getRenewalById(id);
        }

        @PutMapping("/{id}")
        public String updateRenewal(
                @PathVariable Long id){
            return "renewal update succesfully";
        }

        @DeleteMapping("/{id}")
        public String deleteRenewal(@PathVariable Long id) {
                    return "Renewal deleted successfully";
        }
    }

