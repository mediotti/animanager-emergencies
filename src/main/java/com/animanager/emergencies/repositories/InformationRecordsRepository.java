package com.animanager.emergencies.repositories;

import com.animanager.emergencies.entities.human.InformationRecords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

public interface InformationRecordsRepository extends JpaRepository<InformationRecords, UUID> {
    @Query(value = "SELECT * FROM information_records WHERE record_role in ('NURSE','MEDICAL')", nativeQuery = true)
    List<InformationRecords> findAllMedicalDepartment();



}
