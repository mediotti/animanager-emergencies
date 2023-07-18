package com.animanager.emergencies.repositories;

import com.animanager.emergencies.entities.animal.AnimalInformationRecords;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AnimalInformationRecordsRepository extends JpaRepository<AnimalInformationRecords, UUID> {
}
