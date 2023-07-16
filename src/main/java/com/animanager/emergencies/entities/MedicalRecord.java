package com.animanager.emergencies.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Table(name= "medical_records")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MedicalRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Enumerated(EnumType.STRING)
    private Priorities priority;
    private Bay bay;
    private String symptoms;
    private String procedures;
    private UUID responsible;
    private Status status;
}
