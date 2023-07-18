package com.animanager.emergencies.resources;


import com.animanager.emergencies.entities.medical.MedicalRecord;
import com.animanager.emergencies.services.MedicalRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "animanager/emergencies")
public class MedicalRecordsResource {

    @Autowired
    private MedicalRecordsService medicalRecordsService;

    @GetMapping
    public ResponseEntity<List<MedicalRecord>> findAll(){
        return ResponseEntity.ok().body(medicalRecordsService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MedicalRecord> findById(@PathVariable UUID id){
        return ResponseEntity.ok().body(medicalRecordsService.findById(id));
    }

    @PostMapping
    public ResponseEntity<MedicalRecord> insert(@RequestBody MedicalRecord obj){
        return ResponseEntity.ok().body(medicalRecordsService.insert(obj));
    }



}
