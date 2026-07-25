package com.example.sports_club_membership_portal.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "Events")
public class Event {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "EventID")
        private Integer eventID;

        @Column(name = "EventName", nullable = false)
        private String eventName;

        @Column(name = "EventDate", nullable = false)
        private LocalDate eventDate;

        @Column(name = "StartTime")
        private LocalTime startTime;

        @Column(name = "EndTime")
        private LocalTime endTime;

        @Column(name = "Location")
        private String location;

        @Column(name = "Description")
        private String description;



    }

