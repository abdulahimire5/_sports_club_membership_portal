package com.example.sports_club_membership_portal.dto;
import com.example.sports_club_membership_portal.entity.trainingsession;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class TrainingSessionRequestDTO {


        @NotBlank(message = "Session name is required")
        private String sessionName;

        @NotBlank(message = "Trainer name is required")
        private String trainerName;

        @NotNull(message = "Training date is required")
        @FutureOrPresent(message = "Training date must be today or future")
        private LocalDate trainingDate;

        @NotNull(message = "Start time is required")
        private LocalTime startTime;

        @NotNull(message = "End time is required")
        private LocalTime endTime;

        @NotBlank(message = "Location is required")
        private String location;

        @NotBlank(message = "Training type is required")
        private String trainingType;

        private String description;

        public trainingsession toEntity() {
                trainingsession session = new trainingsession();
                session.setSessionName(sessionName);
                session.setTrainerName(trainerName);
                session.setTrainingDate(trainingDate);
                session.setStartTime(startTime);
                session.setEndTime(endTime);
                session.setLocation(location);
                session.setTrainingType(trainingType);
                session.setDescription(description);
                return session;
        }
}


