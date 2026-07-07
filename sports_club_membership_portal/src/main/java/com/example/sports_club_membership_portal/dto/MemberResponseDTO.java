package com.example.sports_club_membership_portal.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberResponseDTO {
    private String fullName;

    private String email;

    private String phone;

    private String role;

    private LocalDate joinDate;

    private String status;

}
