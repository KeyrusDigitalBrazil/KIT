package com.keyrus.kit.models;

import com.keyrus.kit.models.enums.BloodType;
import com.keyrus.kit.models.enums.Nationality;

public class PatientBuilder {

    protected Long id;
    protected String name;
    protected String phoneNumber;
    protected BloodType bloodType;
    protected Nationality nationality;
    protected String doc;
    protected Integer age;
    protected Dna dna;

    protected Long idPatient;
    protected Boolean suspicious;
    protected Boolean confirmed;

    public PatientBuilder() {
    }

    public PatientBuilder(Long id, String name, String phoneNumber, BloodType bloodType, Nationality nationality, String doc, Integer age, Dna dna, Long idPatient, Boolean suspicious, Boolean confirmed) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.bloodType = bloodType;
        this.nationality = nationality;
        this.doc = doc;
        this.age = age;
        this.dna = dna;
        this.idPatient = idPatient;
        this.suspicious = suspicious;
        this.confirmed = confirmed;
    }

    public PatientBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public PatientBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PatientBuilder setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public PatientBuilder setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
        return this;
    }

    public PatientBuilder setNationality(Nationality nationality) {
        this.nationality = nationality;
        return this;
    }

    public PatientBuilder setDoc(String doc) {
        this.doc = doc;
        return this;
    }

    public PatientBuilder setAge(Integer age) {
        this.age = age;
        return this;
    }

    public PatientBuilder setDna(Dna dna) {
        this.dna = dna;
        return this;
    }

    public PatientBuilder setIdPatient(Long idPatient) {
        this.idPatient = idPatient;
        return this;
    }

    public PatientBuilder setSuspicious(Boolean suspicious) {
        this.suspicious = suspicious;
        return this;
    }

    public PatientBuilder setConfirmed(Boolean confirmed) {
        this.confirmed = confirmed;
        return this;
    }

    public Patient build() {
        return new Patient(id, name, phoneNumber, bloodType, nationality, doc,
                age, dna, idPatient, suspicious, confirmed);
    }
}
