package com.keyrus.kit.models;

import com.keyrus.kit.models.enums.BloodType;
import com.keyrus.kit.models.enums.Nationality;
import com.keyrus.kit.models.enums.Risk;

import java.util.Objects;

public class Patient extends Person {

    protected Long id;
    protected Boolean suspicious;
    protected Boolean confirmed;
    protected Boolean quarantine;
    protected Risk risk;

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

    public Boolean getQuarantine() {
        return quarantine;
    }

    public void setQuarantine(Boolean quarantine) {
        this.quarantine = quarantine;
    }

    public Risk getRisk() {
        return risk;
    }

    public void setRisk(Risk risk) {
        this.risk = risk;
    }

    @Override
    public String toString() {
        return "====================================================================================================" +
                "\n Name: " + super.getName() +
                "\n DNA: " + getDna().getDna() +
                "\n Blood Type: " + super.getBloodType() +
                "\n Nationality: " + super.getNationality() +
                "\n Age: " + super.getAge() +
                "\n Particle 781N0: " + suspicious +
                "\n Particle 781NC: " + confirmed +
                "\n Risk: " + risk +
                "\n Quarantine: " + quarantine +
                "\n====================================================================================================\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;
        Patient patient = (Patient) o;
        return  patient.getId().equals(super.id) &&
                getId().equals(patient.getId()) &&
                getDoc().equals(patient.getDoc());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.getId(), getId(), super.getDoc(), getDoc());
    }
}
