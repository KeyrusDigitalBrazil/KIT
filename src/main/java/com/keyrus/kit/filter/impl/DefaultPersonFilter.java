package com.keyrus.kit.filter.impl;

import com.keyrus.kit.data.PatientDnaData;
import com.keyrus.kit.filter.PersonFilter;
import com.keyrus.kit.models.Dna;
import com.keyrus.kit.models.Patient;
import com.keyrus.kit.models.Person;
import com.keyrus.kit.models.enums.BloodType;
import com.keyrus.kit.models.enums.Nationality;
import com.keyrus.kit.repository.KitRepository;
import com.keyrus.kit.repository.impl.AppKitRepository;
import com.keyrus.kit.repository.impl.PatientRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Component
public class DefaultPersonFilter implements PersonFilter {

    private Set<Patient> patientList;

    @Resource(name = "patientRepository")
    private PatientRepository patientRepository;

    @Resource(name = "dnaRepository")
    private KitRepository dnaRepository;

    @Resource(name = "appKitRepository")
    private AppKitRepository appKitRepository;

    @Override
    public Patient getPersonByDoc(String doc) {
        String docReplace = cleanString(doc);
        return appKitRepository.getByDna(docReplace);
    }

    @Override
    public Patient getDnaById(Long id) {
        return patientRepository.get(id);
    }

    @Override
    public Patient getDnaByCode(String code) {
        return appKitRepository.getByDna(code);

    }

    @Override
    public Set<Patient> getInfected() {
        return new HashSet<>(appKitRepository.getInfected(""));
    }

    @Override
    public Set<Patient> getInfectedByNationality(Nationality nationality) {
        return new HashSet<>(appKitRepository.getInfected(nationality.name()));
    }

    @Override
    public Set<Patient> getSuspicious() {
        return new HashSet<>(appKitRepository.getSuspicious(""));
    }

    @Override
    public Set<Patient> getSuspiciousByNationality(Nationality nationality) {
        return new HashSet<>(appKitRepository.getSuspicious(nationality.name()));
    }

    @Override
    public Set<Patient> getNotInfected() {
        return new HashSet<>(appKitRepository.getNotInfected(""));
    }

    @Override
    public Set<Patient> getNotInfectedByNationality(Nationality nationality) {
        return new HashSet<>(appKitRepository.getNotInfected(nationality.name()));
    }

    @Override
    public Set<Patient> getPatientCombineByBlood(BloodType bloodType) {
        if (BloodType.O_NEGATIVE.equals(bloodType))
            return new TreeSet<>(patientRepository.getAll());

        return new HashSet<>(appKitRepository.getBloodType(bloodType.name(),""));
    }

    @Override
    public Set<Patient> getPatientCombineByBloodAndNationality(Nationality nationality, BloodType bloodType) {
        if (BloodType.O_NEGATIVE.equals(bloodType))
            return new TreeSet<>(appKitRepository.getByNationality(nationality.name()));

        return new HashSet<>(appKitRepository.getBloodType(bloodType.name(),nationality.name()));
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
