package com.example.sports_club_membership_portal.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberRequestDTO {
    @NotBlank(message = "fullName is required")
    private String fullName;

    @Email(message = "Invalid email address")
    private String email;

    @NotBlank(message = "phone is required")
    private String phone;

    @Size(min = 6, message = "Password must be at least 6 characters")
    private String passwordHash;

    @NotBlank(message = "role is required")
    private String role;

    @NotBlank(message = "joinDate is required")
    private LocalDate joinDate;

    @NotBlank(message = "status is required")
    private String status;

}
