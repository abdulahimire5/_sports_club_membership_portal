package com.example.sports_club_membership_portal.controller;

import com.example.sports_club_membership_portal.entity.Member;
import com.example.sports_club_membership_portal.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")

public class MemberController {
    @Autowired
    private MemberService memberService;
    @GetMapping
    public List<Member> getAll() {
        return memberService.getAllMembers();
    }
    @GetMapping("/{id}")
    public Member getOne(@PathVariable Integer id) {
        return memberService.getMemberById(id);
    }
    @PostMapping
    public Member create(@Valid @RequestBody Member member) {
        return memberService.createMember(member);
    }
    @PutMapping("/{id}")
    public Member update(@PathVariable Integer id, @RequestBody Member member) {
        return memberService.updateMember(id, member);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        memberService.deleteMember(id);
    }

}
