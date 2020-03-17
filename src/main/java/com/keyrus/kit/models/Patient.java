package com.keyrus.kit.models;

import com.keyrus.kit.models.enums.BloodType;
import com.keyrus.kit.models.enums.Nationality;
import com.keyrus.kit.models.enums.Risk;

public class Patient extends Person {


    private Long id;
    private Boolean suspicious;
    private Boolean confirmed;
    private Boolean quarantine;
    private Risk risk;

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

    public Risk getRisk() {
        return risk;
    }

    public void setRisk(Risk risk) {
        this.risk = risk;
    }

    public Boolean getQuarantine() {
        return quarantine;
    }

    public void setQuarantine(Boolean quarantine) {
        this.quarantine = quarantine;
    }

    @Override
    public String toString() {
        return "====================================================================================================" +
                "\n Name: " + super.getName() +
                "\n DNA : " + getDna().getDna() +
                "\n Blood Type: " + super.getBloodType() +
                "\n Nationality: " + super.getNationality() +
                "\n Age: " + super.getAge() +
                "\n Particle 781N0: " + suspicious +
                "\n Particle 781NC: " + confirmed +
                "\n Risk: " + risk +
                "\n Quarantine: " + quarantine +
                "\n====================================================================================================\n";
    }
}
