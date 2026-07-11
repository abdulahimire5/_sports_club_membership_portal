package com.example.sports_club_membership_portal.repository;
import com.example.sports_club_membership_portal.entity.trainingsession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
    public interface TrainingSessionRepository extends JpaRepository<trainingsession, Long> {

        // Find by session name
        List<trainingsession> findBySessionName(String sessionName);

        // Find by trainer name
        List<trainingsession> findByTrainerName(String trainerName);

        // Find by training date
        List<trainingsession> findByTrainingDate(LocalDate trainingDate);

        // Find by training type
        List<trainingsession> findByTrainingType(String trainingType);

        // Find by location
        List<trainingsession> findByLocation(String location);

        // Check if session exists
        boolean existsBySessionName(String sessionName);
    }

