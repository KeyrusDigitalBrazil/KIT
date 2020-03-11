package com.keyrus.kit.models;

import com.keyrus.kit.models.enums.BloodType;
import com.keyrus.kit.models.enums.Nationality;

public class Person {

    private Long id;
    private String name;
    private String phoneNumber;
    private BloodType bloodType;
    private Nationality nationality;
    private String doc;
    private Integer age;
    private Dna dna;

    public Person() {
    }

    public Person(Long id, String name, String phoneNumber, BloodType bloodType, Nationality nationality, String doc, Integer age, Dna dna) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.bloodType = bloodType;
        this.nationality = nationality;
        this.doc = doc;
        this.age = age;
        this.dna = dna;
    }

    public Dna getDna() {
        return dna;
    }

    public void setDna(Dna dna) {
        this.dna = dna;
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

    public BloodType getBloodType() {
        return bloodType;
    }

    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
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
