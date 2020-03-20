package com.keyrus.kit.filter.impl;

import com.keyrus.kit.filter.PersonFilter;
import com.keyrus.kit.models.Dna;
import com.keyrus.kit.models.Patient;
import com.keyrus.kit.models.enums.BloodType;
import com.keyrus.kit.models.enums.Nationality;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DefaultPersonFilter implements PersonFilter {

    private Set<Patient> patientList;

    @Override
    public Patient getPersonByDoc(String doc) {
        String docReplace = cleanString(doc);
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
    public Set<Patient> getInfected() {
        return patientList.stream().filter(patient -> patient.getConfirmed().equals(Boolean.TRUE)).collect(Collectors.toSet());
    }

    @Override
    public Set<Patient> getInfectedByNationality(Nationality nationality) {
        return patientList.stream().filter(patient -> (patient.getConfirmed().equals(Boolean.TRUE) && patient.getNationality().equals(nationality))).collect(Collectors.toSet());
    }

    @Override
    public Set<Patient> getSuspicious() {
        return patientList.stream().filter(patient -> patient.getSuspicious().equals(Boolean.TRUE)).collect(Collectors.toSet());
    }

    @Override
    public Set<Patient> getSuspiciousByNationality(Nationality nationality) {
        return patientList.parallelStream().filter(patient -> patient.getNationality().equals(nationality) && patient.getSuspicious().equals(Boolean.TRUE)).collect(Collectors.toSet());
    }

    @Override
    public Set<Patient> getNotInfected() {
        return patientList.parallelStream().filter(patient -> patient.getSuspicious().equals(Boolean.FALSE)).collect(Collectors.toSet());
    }

    @Override
    public Set<Patient> getNotInfectedByNationality(Nationality nationality) {
        return patientList.parallelStream().filter(patient -> patient.getNationality().equals(nationality) && patient.getSuspicious().equals(Boolean.FALSE)).collect(Collectors.toSet());
    }

    @Override
    public Set<Patient> getPatientCombineByBlood(BloodType bloodType) {
        if (BloodType.O_NEGATIVE.equals(bloodType))
            return patientList;

        return patientList.parallelStream().filter(patient -> patient.getBloodType().equals(bloodType)).collect(Collectors.toSet());
    }

    @Override
    public Set<Patient> getPatientCombineByBloodAndNationality(BloodType bloodType, Nationality nationality) {
        return patientList.parallelStream().filter(patient -> patient.getNationality().equals(nationality) && patient.getBloodType().equals(bloodType)).collect(Collectors.toSet());
    }

    @Override
    public Set<Patient> getPatientAll() {
        return patientList;
    }

    @Override
    public void setPatientList(Set<Patient> patientList) {
        this.patientList = patientList;
    }

    @Override
    public String cleanString(String doc) {
        return doc.replace("[^a-zA-Z0-9]", "");
    }

}
