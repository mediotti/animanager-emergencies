package com.animanager.emergencies.entities.animal;

import com.animanager.emergencies.entities.human.InformationRecords;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Table(name="animal_information_records")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class AnimalInformationRecords {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String name;
    private String age;
    private String species;
    private String breed;
    private Boolean neutered;
    private String vaccination_records;
    private String procedures_records;
    @JsonIgnore()
    @ManyToOne
    @JoinColumn(name = "caregiver_id")
    private InformationRecords caregiver;

    public AnimalInformationRecords(RequestAnimalInformationRecordsDTO data, InformationRecords caregiver_obj){
        this.name = data.name();
        this.gender = data.gender();
        this.age = data.age();
        this.procedures_records = data.procedures_records();
        this.vaccination_records = data.vaccination_records();
        this.breed = data.breed();
        this.neutered = data.neutered();
        this.species = data.species();
        this.caregiver = caregiver_obj;
    }

    public InformationRecords getCaregiver() {
        return caregiver;
    }

    public void setCaregiver(InformationRecords caregiver) {
        this.caregiver = caregiver;
    }

}
