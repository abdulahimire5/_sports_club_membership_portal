package com.example.sports_club_membership_portal.repository;


import com.example.sports_club_membership_portal.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface EventRepository extends JpaRepository<Event, Integer> {

    }

