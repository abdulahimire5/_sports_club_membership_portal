package com.example.sports_club_membership_portal.dto;
import com.example.sports_club_membership_portal.entity.trainingsession;

import java.time.LocalDate;
import java.time.LocalTime;

public class TrainingSessionResponseDTO {




        private Long id;
        private String sessionName;
        private String trainerName;
        private LocalDate trainingDate;
        private LocalTime startTime;
        private LocalTime endTime;
        private String location;
        private String trainingType;
        private String description;

        public TrainingSessionResponseDTO() {
        }

        public TrainingSessionResponseDTO(Long id, String sessionName, String trainerName,
                                          LocalDate trainingDate, LocalTime startTime,
                                          LocalTime endTime, String location,
                                          String trainingType, String description) {
            this.id = id;
            this.sessionName = sessionName;
            this.trainerName = trainerName;
            this.trainingDate = trainingDate;
            this.startTime = startTime;
            this.endTime = endTime;
            this.location = location;
            this.trainingType = trainingType;
            this.description = description;
        }

    public static TrainingSessionResponseDTO fromEntity(trainingsession savedTrainingSession) {
                return null;
    }

    public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getSessionName() {
            return sessionName;
        }

        public void setSessionName(String sessionName) {
            this.sessionName = sessionName;
        }

        public String getTrainerName() {
            return trainerName;
        }

        public void setTrainerName(String trainerName) {
            this.trainerName = trainerName;
        }

        public LocalDate getTrainingDate() {
            return trainingDate;
        }

        public void setTrainingDate(LocalDate trainingDate) {
            this.trainingDate = trainingDate;
        }

        public LocalTime getStartTime() {
            return startTime;
        }

        public void setStartTime(LocalTime startTime) {
            this.startTime = startTime;
        }

        public LocalTime getEndTime() {
            return endTime;
        }

        public void setEndTime(LocalTime endTime) {
            this.endTime = endTime;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getTrainingType() {
            return trainingType;
        }

        public void setTrainingType(String trainingType) {
            this.trainingType = trainingType;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

