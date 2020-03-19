package com.keyrus.kit.filter.impl;

import com.keyrus.kit.filter.PersonFilter;
import com.keyrus.kit.models.Dna;
import com.keyrus.kit.models.Patient;
import com.keyrus.kit.models.enums.BloodType;
import com.keyrus.kit.models.enums.Nationality;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultPersonFilter implements PersonFilter {

    private List<Patient> patientList;

    @Override
    public Patient getPersonByDoc(String doc) {
        String docReplace = doc.replaceAll("[^a-zA-Z0-9 ]", "");
        return patientList.stream().filter(patient -> patient.getDoc().equals(docReplace)).findFirst().get();
    }

    @Override
    public String getDnaById(Long id) {
        String result = patientList.stream().filter(patient -> patient.getDna().getId().equals(id)).map(patient -> patient.getDna()).findFirst().get().toString();
        result += (patientList.stream().filter(patient -> patient.getDna().getId().equals(id)).findFirst().get().toString());
        return result;
    }

    @Override
    public String getDnaByCode(String id) {
        String result = patientList.stream().filter(patient -> patient.getDna().getDna().equals(id)).map(patient -> patient.getDna()).findFirst().get().toString();
        result += (patientList.stream().filter(patient -> patient.getDna().getDna().equals(id)).findFirst().get().toString());
        return result;
    }

    @Override
    public List<Patient> getInfected() {
        return patientList.stream().filter(patient -> patient.getConfirmed().equals(Boolean.TRUE)).collect(Collectors.toList());
    }

    @Override
    public List<Patient> getInfectedByNationality(Nationality nationality) {
        return patientList.stream().filter(patient -> (patient.getConfirmed().equals(Boolean.TRUE) && patient.getNationality().equals(nationality))).collect(Collectors.toList());
    }

    @Override
    public List<Patient> getSuspicious() {
        return patientList.stream().filter(patient -> patient.getSuspicious().equals(Boolean.TRUE)).collect(Collectors.toList());
    }

    @Override
    public List<Patient> getSuspiciousByNationality(Nationality nationality) {
        return patientList.parallelStream().filter(patient -> patient.getNationality().equals(nationality) && patient.getSuspicious().equals(Boolean.TRUE)).collect(Collectors.toList());
    }

    @Override
    public List<Patient> getNotInfected() {
        return patientList.parallelStream().filter(patient -> patient.getSuspicious().equals(Boolean.FALSE)).collect(Collectors.toList());
    }

    @Override
    public List<Patient> getNotInfectedByNationality(Nationality nationality) {
        return patientList.parallelStream().filter(patient -> patient.getNationality().equals(nationality) && patient.getSuspicious().equals(Boolean.FALSE)).collect(Collectors.toList());
    }

    @Override
    public List<Patient> getPatientCombineByBlood(BloodType bloodType) {
        if(BloodType.O_NEGATIVE.equals(bloodType))
            return patientList;

        return patientList.parallelStream().filter(patient -> patient.getBloodType().equals(bloodType)).collect(Collectors.toList());
    }

    @Override
    public List<Patient> getPatientCombineByBloodAndNationality(BloodType bloodType, Nationality nationality) {
        return patientList.parallelStream().filter(patient -> patient.getNationality().equals(nationality) && patient.getBloodType().equals(bloodType)).collect(Collectors.toList());
    }

    @Override
    public List<Patient> getPatientAll() {
        return patientList;
    }
    @Override
    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }

}
