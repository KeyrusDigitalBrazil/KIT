package com.keyrus.kit.models;

import com.keyrus.kit.models.enums.BloodType;
import com.keyrus.kit.models.enums.Nationality;

import java.util.Objects;

public class Person  extends PrincipalType {

    protected String name;
    protected String phoneNumber;
    protected BloodType bloodType;
    protected Nationality nationality;
    protected String doc;
    protected Integer age;
    protected Dna dna;

    public Person () {}

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

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public BloodType getBloodType() {
        return bloodType;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public String getDoc() {
        return doc;
    }

    public Integer getAge() {
        return age;
    }

    public Dna getDna() {
        return dna;
    }

    public String toPrint() {
        return "Person { " +
                " ID = " + id +
                ", Name = '" + name + '\'' +
                ", Phone Number = '" + phoneNumber + '\'' +
                ", Blood Type = " + bloodType +
                ", Nationality = " + nationality +
                ", DOC = '" + doc + '\'' +
                ", Age = " + age +
                ", DNA = " + dna +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return getId().equals(person.getId()) &&
                getName().equals(person.getName()) &&
                getPhoneNumber().equals(person.getPhoneNumber()) &&
                getBloodType() == person.getBloodType() &&
                getNationality() == person.getNationality() &&
                getDoc().equals(person.getDoc()) &&
                getAge().equals(person.getAge()) &&
                getDna().equals(person.getDna());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getPhoneNumber(), getBloodType(), getNationality(), getDoc(), getAge(), getDna());
    }
}
