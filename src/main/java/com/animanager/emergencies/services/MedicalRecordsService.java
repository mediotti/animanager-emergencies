package com.animanager.emergencies.services;


import com.animanager.emergencies.entities.medical.MedicalRecord;
import com.animanager.emergencies.repositories.AnimalInformationRecordsRepository;
import com.animanager.emergencies.repositories.InformationRecordsRepository;
import com.animanager.emergencies.repositories.MedicalRecordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
public class MedicalRecordsService {
    @Autowired
    private MedicalRecordsRepository medicalRecordsRepository;

    @Autowired
    private AnimalInformationRecordsRepository animalInformationRecordsRepository;

    @Autowired
    private InformationRecordsRepository informationRecordsRepository;

    public List<MedicalRecord> findAll(){
        return medicalRecordsRepository.findAll();
    }

    public MedicalRecord findById(UUID id) throws NoSuchElementException {
        Optional<MedicalRecord> result = medicalRecordsRepository.findById(id);
        return result.get();
    }

    public MedicalRecord insert(MedicalRecord obj) throws NoSuchElementException{
        if (informationRecordsRepository.findById(obj.getResponsible()).isPresent() && animalInformationRecordsRepository.findById(obj.getAnimal()).isPresent()) {
            return medicalRecordsRepository.save(obj);
        }
        else throw new NoSuchElementException();
    }
}
