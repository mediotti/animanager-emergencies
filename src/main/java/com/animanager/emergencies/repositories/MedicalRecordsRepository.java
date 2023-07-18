package com.animanager.emergencies.repositories;

import com.animanager.emergencies.entities.medical.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MedicalRecordsRepository extends JpaRepository<MedicalRecord, UUID> {
}
