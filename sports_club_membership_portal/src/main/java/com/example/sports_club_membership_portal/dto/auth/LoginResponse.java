package com.example.sports_club_membership_portal.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse {
    private String token;
    private Integer memberId;
    private String fullName;
    private String role;
}
