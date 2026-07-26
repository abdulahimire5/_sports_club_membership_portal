package com.example.sports_club_membership_portal.security;

import com.example.sports_club_membership_portal.entity.Member;
import com.example.sports_club_membership_portal.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String email) {
        Member member = memberRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Member not found: " + email));
        String role = member.getRole() == null ? "MEMBER" : member.getRole();
        return new User(member.getEmail(), member.getPasswordHash(), List.of(new SimpleGrantedAuthority("ROLE_" + role)));
    }
}
