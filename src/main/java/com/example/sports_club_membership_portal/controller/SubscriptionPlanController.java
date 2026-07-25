package com.example.sports_club_membership_portal.controller;


import com.example.sports_club_membership_portal.entity.SubscriptionPlan;
import com.example.sports_club_membership_portal.service.SubscriptionPlanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plans")

public class SubscriptionPlanController {

    @Autowired
    private SubscriptionPlanService planService;
    @GetMapping
    public List<SubscriptionPlan> getAll() {
        return planService.getAllPlans();
    }
    @GetMapping("/{id}")
    public SubscriptionPlan getOne(@PathVariable Integer id) {
        return planService.getPlanById(id);
    }
    @PostMapping
    public SubscriptionPlan create(@Valid @RequestBody SubscriptionPlan plan) {
        return planService.createPlan(plan);
    }
    @PutMapping("/{id}")
    public SubscriptionPlan update(@PathVariable Integer id, @RequestBody SubscriptionPlan
            plan) {
        return planService.updatePlan(id, plan);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        planService.deletePlan(id);
    }

}
