package com.keyrus.kit.filter.impl;

import com.keyrus.kit.filter.PersonFilter;
import com.keyrus.kit.models.Dna;
import com.keyrus.kit.models.Patient;
import com.keyrus.kit.models.enums.BloodType;
import com.keyrus.kit.models.enums.Nationality;

import java.util.List;
import java.util.stream.Collectors;

public class DefaultPersonFilter implements PersonFilter {

    private List<Patient> patientList;

    @Override
    public Patient getPersonByDoc(String doc) {
        return patientList.stream().filter(patient -> patient.getDoc().equals(doc)).findFirst().get();
    }

    @Override
    public Dna getDnaById(Long id) {
        return patientList.stream().filter(patient -> patient.getDna().getId() == id).map(patient -> patient.getDna()).findFirst().get();
    }

    @Override
    public List<Patient> getInfected() {
        return patientList.stream().filter(patient -> patient.getConfirmed() == Boolean.TRUE).collect(Collectors.toList());
    }

    @Override
    public List<Patient> getInfectedByNationality(Nationality nationality) {
        return patientList.stream().filter(patient -> (patient.getConfirmed() == Boolean.TRUE && patient.getNationality().equals(nationality))).collect(Collectors.toList());
    }

    @Override
    public List<Patient> getSuspicious() {
        return patientList.stream().filter(patient -> patient.getSuspicious() == Boolean.TRUE).collect(Collectors.toList());
    }

    @Override
    public List<Patient> getSuspiciousByNationality(Nationality nationality) {
        return null;
    }

    @Override
    public List<Patient> getNotInfected() {
        return null;
    }

    @Override
    public List<Patient> getNotInfectedByNationality(Nationality nationality) {
        return null;
    }

    @Override
    public List<Patient> getPatientCombineByBlood(BloodType bloodType) {
        return null;
    }

    @Override
    public List<Patient> getPatientCombineByBloodAndNationality(BloodType bloodType, Nationality nationality) {
        return null;
    }

    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }

}
