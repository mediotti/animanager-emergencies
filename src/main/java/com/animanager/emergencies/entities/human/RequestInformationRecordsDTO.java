package com.animanager.emergencies.entities.human;

public record RequestInformationRecordsDTO(String first_name, String last_name, String phone_number, String ssn, Role record_role, String zip_code, String address_complements) {
}