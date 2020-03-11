package com.keyrus.kit.models;

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
}
