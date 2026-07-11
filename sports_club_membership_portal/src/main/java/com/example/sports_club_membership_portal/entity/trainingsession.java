package com.example.sports_club_membership_portal.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name = " trainingsession")
public class trainingsession {





        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotBlank(message = "Session name is required")
        @Column(nullable = false)
        private String sessionName;

        @NotBlank(message = "Trainer name is required")
        @Column(nullable = false)
        private String trainerName;

        @NotNull(message = "Training date is required")
        @FutureOrPresent(message = "Training date must be today or future")
        @Column(nullable = false)
        private LocalDate trainingDate;

        @NotNull(message = "Start time is required")
        @Column(nullable = false)
        private LocalTime startTime;

        @NotNull(message = "End time is required")
        @Column(nullable = false)
        private LocalTime endTime;

        @NotBlank(message = "Location is required")
        @Column(nullable = false)
        private String location;

        @NotBlank(message = "Training type is required")
        @Column(nullable = false)
        private String trainingType;

        @Column(length = 500)
        private String description;

}
