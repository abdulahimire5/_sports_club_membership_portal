package com.example.sports_club_membership_portal.service;

import com.example.sports_club_membership_portal.entity.SubscriptionPlan;
import com.example.sports_club_membership_portal.exception.ResourceNotFoundException;
import com.example.sports_club_membership_portal.repository.SubscriptionPlanRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionPlanService {
    @Autowired
    private SubscriptionPlanRepository planRepository;
    public List<SubscriptionPlan> getAllPlans() {
        return planRepository.findAll();
    }
    public SubscriptionPlan getPlanById(Integer id) {
        return planRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Plan not found: " + id));
    }
    public SubscriptionPlan createPlan(SubscriptionPlan plan) {
        return planRepository.save(plan);
    }
    public SubscriptionPlan updatePlan(Integer id, SubscriptionPlan updated) {
        SubscriptionPlan existing = getPlanById(id);
        existing.setPlanName(updated.getPlanName());
        existing.setDurationMonths(updated.getDurationMonths());
        existing.setPrice(updated.getPrice());
        existing.setDescription(updated.getDescription());
        return planRepository.save(existing);
    }
    public void deletePlan(Integer id) {
        planRepository.deleteById(id);
    }

}
