package com.example.sports_club_membership_portal.service;
import com.example.sports_club_membership_portal.dto.TrainingSessionRequestDTO;
import com.example.sports_club_membership_portal.dto.TrainingSessionResponseDTO;
import com.example.sports_club_membership_portal.entity.trainingsession;
import com.example.sports_club_membership_portal.exception.ResourceNotFoundException;
import com.example.sports_club_membership_portal.repository.TrainingSessionRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class TrainingSessionService {




        private TrainingSessionRepository trainingSessionRepository;

        public List<TrainingSessionResponseDTO> getAllTrainingSessions() {
            return trainingSessionRepository.findAll().stream()
                    .map(TrainingSessionResponseDTO::fromEntity)
                    .toList();
        }

        public TrainingSessionResponseDTO getTrainingSessionById(Long id) {
            return trainingSessionRepository.findById(id)
                    .map(TrainingSessionResponseDTO::fromEntity)
                    .orElseThrow(() ->
                            new ResourceNotFoundException("Training Session not found with ID: " + id));
        }

        public TrainingSessionResponseDTO createTrainingSession(TrainingSessionRequestDTO requestDTO) {
            trainingsession trainingSession = requestDTO.toEntity();
            trainingsession savedTrainingSession = trainingSessionRepository.save(trainingSession);
            return TrainingSessionResponseDTO.fromEntity(savedTrainingSession);
        }

        public TrainingSessionResponseDTO updateTrainingSession(Long id, TrainingSessionRequestDTO requestDTO) {

            trainingsession existingTrainingSession = trainingSessionRepository.findById(id)
                    .orElseThrow(() ->
                            new ResourceNotFoundException("Training Session not found with ID: " + id));

            existingTrainingSession.setSessionName(requestDTO.getSessionName());
            existingTrainingSession.setTrainerName(requestDTO.getTrainerName());
            existingTrainingSession.setTrainingDate(requestDTO.getTrainingDate());
            existingTrainingSession.setStartTime(requestDTO.getStartTime());
            existingTrainingSession.setEndTime(requestDTO.getEndTime());
            existingTrainingSession.setLocation(requestDTO.getLocation());
            existingTrainingSession.setTrainingType(requestDTO.getTrainingType());
            existingTrainingSession.setDescription(requestDTO.getDescription());

            trainingsession updatedTrainingSession = trainingSessionRepository.save(existingTrainingSession);
            return TrainingSessionResponseDTO.fromEntity(updatedTrainingSession);
        }

        public void deleteTrainingSession(Long id) {

            trainingsession trainingSession = trainingSessionRepository.findById(id)
                    .orElseThrow(() ->
                            new ResourceNotFoundException("Training Session not found with ID: " + id));

            trainingSessionRepository.delete(trainingSession);
        }
    }

