package com.example.sports_club_membership_portal.service;

import com.example.sports_club_membership_portal.dto.auth.LoginRequest;
import com.example.sports_club_membership_portal.dto.auth.LoginResponse;
import com.example.sports_club_membership_portal.dto.auth.RegisterRequest;
import com.example.sports_club_membership_portal.entity.Member;
import com.example.sports_club_membership_portal.exception.UnauthorizedException;
import com.example.sports_club_membership_portal.repository.MemberRepository;
import com.example.sports_club_membership_portal.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public LoginResponse register(RegisterRequest request) {
        if (memberRepository.findByEmail(request.getEmail()).isPresent()) throw new IllegalArgumentException("Email is already registered");
        Member member = new Member();
        member.setFullName(request.getFullName());
        member.setEmail(request.getEmail());
        member.setPhone(request.getPhone());
        member.setPasswordHash(passwordEncoder.encode(request.getPassword()));
        member.setRole("MEMBER");
        member.setJoinDate(LocalDate.now());
        member.setStatus("ACTIVE");
        Member saved = memberRepository.save(member);
        return responseFor(saved);
    }

    public LoginResponse login(LoginRequest request) {
        Member member = memberRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UnauthorizedException("Invalid email or password"));
        boolean passwordMatches = passwordEncoder.matches(request.getPassword(), member.getPasswordHash());
        if (!passwordMatches && request.getPassword().equals(member.getPasswordHash())) {
            // Upgrade an account created before password hashing was introduced.
            member.setPasswordHash(passwordEncoder.encode(request.getPassword()));
            memberRepository.save(member);
            passwordMatches = true;
        }
        if (!passwordMatches) throw new UnauthorizedException("Invalid email or password");
        return responseFor(member);
    }

    public Member getCurrentMember(String email) {
        return memberRepository.findByEmail(email).orElseThrow(() -> new UnauthorizedException("Member not found"));
    }

    private LoginResponse responseFor(Member member) {
        return new LoginResponse(jwtService.generateToken(member.getEmail()), member.getMemberId(), member.getFullName(), member.getRole());
    }
}
