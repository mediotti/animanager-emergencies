package com.animanager.emergencies.entities.medical;


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
    @Enumerated(EnumType.STRING)
    private Bay bay;
    private String symptoms;
    private String procedures;
    private UUID responsible;
    @Enumerated(EnumType.STRING)
    private Status status;
    private UUID animal;
}
