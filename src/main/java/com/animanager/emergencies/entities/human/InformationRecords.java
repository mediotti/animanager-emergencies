package com.animanager.emergencies.entities.human;

import com.animanager.emergencies.entities.animal.AnimalInformationRecords;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Table(name="information_records")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class InformationRecords {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Enumerated(EnumType.STRING)
    private Role record_role;

    private String first_name;
    private String last_name;
    private String phone_number;
    private String ssn;
    private String zip_code;
    private String address_complements;

    @OneToMany(mappedBy = "caregiver")
    private List<AnimalInformationRecords> animals = new ArrayList<>();

    public InformationRecords(RequestInformationRecordsDTO data){
        this.first_name = data.first_name();
        this.last_name = data.last_name();
        this.phone_number = data.phone_number();
        this.ssn = data.ssn();
        this.record_role = data.record_role();
        this.zip_code = data.zip_code();
        this.address_complements = data.address_complements();
    }

}
