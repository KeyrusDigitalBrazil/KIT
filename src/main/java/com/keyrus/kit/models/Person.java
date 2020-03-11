package com.keyrus.kit.models;

import com.keyrus.kit.models.enums.Nationality;

public class Person {

    private Long id;
    private String name;
    private String phoneNumber;
    private String bloodType;
    private Boolean suspicious;
    private Boolean confirmed;
    private Nationality nationality;
    private String doc;
    private Integer age;

    public Person() {
    }

    public Person(Long id, String name, String phoneNumber, String bloodType, Boolean suspicious, Boolean confirmed, Nationality nationality, String doc, Integer age) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.bloodType = bloodType;
        this.suspicious = suspicious;
        this.confirmed = confirmed;
        this.nationality = nationality;
        this.doc = doc;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
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

    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
