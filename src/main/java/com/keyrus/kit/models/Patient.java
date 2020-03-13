package com.keyrus.kit.models;

import com.keyrus.kit.models.enums.BloodType;
import com.keyrus.kit.models.enums.Nationality;

public class Patient extends Person{


    private Long id;
    private Boolean suspicious;

    private Boolean confirmed;

    public Patient() {
    }

    public Patient(Boolean suspicious, Boolean confirmed, Long id) {
        this.suspicious = suspicious;
        this.confirmed = confirmed;
        this.id = id;
    }

    public Patient(Long id, String name, String phoneNumber, BloodType bloodType, Nationality nationality,
                   String doc, Integer age, Dna dna, Long id1, Boolean suspicious, Boolean confirmed) {
        super(id, name, phoneNumber, bloodType, nationality, doc, age, dna);
        this.id = id1;
        this.suspicious = suspicious;
        this.confirmed = confirmed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getSuspicious() {
        return suspicious;
    }

    public void setSuspicious(Boolean suspicious) {
        this.suspicious = suspicious;
    }

    public Boolean getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        this.confirmed = confirmed;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", suspicious=" + suspicious +
                ", confirmed=" + confirmed +
                super.toString() +
                '}';
    }
}
