package com.example.sports_club_membership_portal.controller;

import com.example.sports_club_membership_portal.dto.auth.LoginRequest;
import com.example.sports_club_membership_portal.dto.auth.LoginResponse;
import com.example.sports_club_membership_portal.dto.auth.RegisterRequest;
import com.example.sports_club_membership_portal.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public LoginResponse register(@Valid @RequestBody RegisterRequest request) { return authService.register(request); }

    @PostMapping("/login")
    public LoginResponse login(@Valid @RequestBody LoginRequest request) { return authService.login(request); }

    @GetMapping("/me")
    public com.example.sports_club_membership_portal.entity.Member me(@AuthenticationPrincipal UserDetails user) {
        if (user == null) throw new com.example.sports_club_membership_portal.exception.UnauthorizedException("Authentication is required");
        return authService.getCurrentMember(user.getUsername());
    }
}
