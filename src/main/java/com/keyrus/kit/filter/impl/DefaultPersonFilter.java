package com.keyrus.kit.filter.impl;

import com.keyrus.kit.data.PatientDnaData;
import com.keyrus.kit.filter.PersonFilter;
import com.keyrus.kit.models.Dna;
import com.keyrus.kit.models.Patient;
import com.keyrus.kit.models.Person;
import com.keyrus.kit.models.enums.BloodType;
import com.keyrus.kit.models.enums.Nationality;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Component
public class DefaultPersonFilter implements PersonFilter {

    private Set<Patient> patientList;

    @Override
    public Patient getPersonByDoc(String doc) {
        String docReplace = cleanString(doc);
        return patientList.stream().filter(patient -> patient.getDoc().equals(docReplace)).findFirst().orElse(null);
    }

    @Override
    public PatientDnaData getDnaById(Long id) {
        Optional<Dna> dna = patientList.stream().filter(p -> p.getDna().getId().equals(id)).map(Person::getDna).findFirst();
        Optional<Patient> patient = patientList.stream().filter(p -> p.getDna().getId().equals(id)).findFirst();

        if (patient.isPresent() && dna.isPresent()) {
            return new PatientDnaData(patient.get(), dna.get());
        }

        return new PatientDnaData();
    }

    @Override
    public PatientDnaData getDnaByCode(String code) {
        Optional<Dna> dna = patientList.stream().filter(p -> p.getDna().getDna().equals(code)).map(Person::getDna).findFirst();
        Optional<Patient> patient = patientList.stream().filter(p -> p.getDna().getDna().equals(code)).findFirst();

        if (patient.isPresent() && dna.isPresent()) {
            return new PatientDnaData(patient.get(), dna.get());
        }

        return new PatientDnaData();
    }

    @Override
    public Set<Patient> getInfected() {
        return patientList.stream().filter(patient -> patient.getConfirmed().equals(Boolean.TRUE)).collect(Collectors.toCollection(TreeSet::new));
    }

    @Override
    public Set<Patient> getInfectedByNationality(Nationality nationality) {
        return patientList.stream().filter(patient -> (patient.getConfirmed().equals(Boolean.TRUE) && patient.getNationality().equals(nationality))).collect(Collectors.toCollection(TreeSet::new));
    }

    @Override
    public Set<Patient> getSuspicious() {
        return patientList.stream().filter(patient -> patient.getSuspicious().equals(Boolean.TRUE)).collect(Collectors.toCollection(TreeSet::new));
    }

    @Override
    public Set<Patient> getSuspiciousByNationality(Nationality nationality) {
        return patientList.parallelStream().filter(patient -> patient.getNationality().equals(nationality) && patient.getSuspicious().equals(Boolean.TRUE)).collect(Collectors.toCollection(TreeSet::new));
    }

    @Override
    public Set<Patient> getNotInfected() {
        return patientList.parallelStream().filter(patient -> patient.getSuspicious().equals(Boolean.FALSE)).collect(Collectors.toCollection(TreeSet::new));
    }

    @Override
    public Set<Patient> getNotInfectedByNationality(Nationality nationality) {
        return patientList.parallelStream().filter(patient -> patient.getNationality().equals(nationality) && patient.getSuspicious().equals(Boolean.FALSE)).collect(Collectors.toCollection(TreeSet::new));
    }

    @Override
    public Set<Patient> getPatientCombineByBlood(BloodType bloodType) {
        if (BloodType.O_NEGATIVE.equals(bloodType))
            return new TreeSet<>(patientList);

        return patientList.parallelStream().filter(patient -> patient.getBloodType().equals(bloodType)).collect(Collectors.toCollection(TreeSet::new));
    }

    @Override
    public Set<Patient> getPatientCombineByBloodAndNationality(Nationality nationality, BloodType bloodType) {
        if (BloodType.O_NEGATIVE.equals(bloodType))
            return patientList.parallelStream().filter(patient -> patient.getNationality().equals(nationality)).collect(Collectors.toCollection(TreeSet::new));

        return patientList.parallelStream().filter(patient -> patient.getNationality().equals(nationality) && patient.getBloodType().equals(bloodType)).collect(Collectors.toCollection(TreeSet::new));
    }

    @Override
    public Set<Patient> getPatientAll() {
        return new TreeSet<>(patientList);
    }

    @Override
    public void setPatientList(Set<Patient> patientList) {
        this.patientList = patientList;
    }

    @Override
    public String cleanString(String doc) {
        return doc.replaceAll("[^a-zA-Z0-9]", "");
    }

}
