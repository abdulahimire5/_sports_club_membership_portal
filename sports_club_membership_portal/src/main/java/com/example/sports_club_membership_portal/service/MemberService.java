package com.example.sports_club_membership_portal.service;

import com.example.sports_club_membership_portal.entity.Member;
import com.example.sports_club_membership_portal.exception.ResourceNotFoundException;
import com.example.sports_club_membership_portal.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }
    public Member getMemberById(Integer id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Member not found: " + id));
    }
    public Member createMember(Member member) {

        member.setJoinDate(LocalDate.now());
        member.setStatus("ACTIVE");

        // 🔐 encrypt password before saving
        member.setPasswordHash(passwordEncoder.encode(member.getPasswordHash()));

        return memberRepository.save(member);
    }
    public Member updateMember(Integer id, Member updated) {
        Member existing = getMemberById(id);
        existing.setFullName(updated.getFullName());
        existing.setPhone(updated.getPhone());
        existing.setStatus(updated.getStatus());
        return memberRepository.save(existing);
    }
    public void deleteMember(Integer id) {
        memberRepository.deleteById(id);
    }

}
