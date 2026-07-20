package com.example.sports_club_membership_portal.controller;
import com.example.sports_club_membership_portal.dto.TrainingSessionRequestDTO;
import com.example.sports_club_membership_portal.dto.TrainingSessionResponseDTO;
import com.example.sports_club_membership_portal.service.TrainingSessionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/training-sessions")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class TrainingSessionController {

        private final TrainingSessionService trainingSessionService;

        // Create Training Session
        @PostMapping
        public TrainingSessionResponseDTO createTrainingSession(
                @Valid @RequestBody TrainingSessionRequestDTO requestDTO) {
            return trainingSessionService.createTrainingSession(requestDTO);
        }

        // Get All Training Sessions
        @GetMapping
        public List<TrainingSessionResponseDTO> getAllTrainingSessions() {
            return trainingSessionService.getAllTrainingSessions();
        }


        @GetMapping("/{id}")
        public TrainingSessionResponseDTO getTrainingSessionById(@PathVariable Long id) {
            return trainingSessionService.getTrainingSessionById(id);
        }

        // Update Training Session
        @PutMapping("/{id}")
        public TrainingSessionResponseDTO updateTrainingSession(
                @PathVariable Long id,
                @Valid @RequestBody TrainingSessionRequestDTO requestDTO) {
            return trainingSessionService.updateTrainingSession(id, requestDTO);
        }

        // Delete Training Session
        @DeleteMapping("/{id}")
        public String deleteTrainingSession(@PathVariable Long id) {
            trainingSessionService.deleteTrainingSession(id);
            return "Training Session deleted successfully.";
        }
    }

