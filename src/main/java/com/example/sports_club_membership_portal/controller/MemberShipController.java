package com.example.sports_club_membership_portal.controller;

import com.example.sports_club_membership_portal.dto.MemberShipRequestDTO;
import com.example.sports_club_membership_portal.dto.MemberShipResponseDTO;
import com.example.sports_club_membership_portal.service.MembershipService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/memberships")
public class MemberShipController {

    @Autowired
    private MembershipService membershipService;

    @GetMapping
    public List<MemberShipResponseDTO> getAll() {
        return membershipService.getAllMemberships();
    }

    @GetMapping("/{id}")
    public MemberShipResponseDTO getOne(@PathVariable Integer id) {
        return membershipService.getMembershipById(id);
    }

    @PostMapping
    public MemberShipResponseDTO create(@Valid @RequestBody MemberShipRequestDTO requestDTO) {
        return membershipService.createMembership(requestDTO);
    }

    @PutMapping("/{id}")
    public MemberShipResponseDTO update(@PathVariable Integer id, @Valid @RequestBody MemberShipRequestDTO requestDTO) {
        return membershipService.updateMembership(id, requestDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        membershipService.deleteMembership(id);
    }
}
