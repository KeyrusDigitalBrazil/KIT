package com.keyrus.kit.filter;

import com.keyrus.kit.models.Dna;
import com.keyrus.kit.models.Patient;
import com.keyrus.kit.models.enums.BloodType;
import com.keyrus.kit.models.enums.Nationality;

import java.util.List;

public interface PersonFilter {

    Patient getPersonByDoc(String doc);

    Dna getDnaById(Long id);

    List<Patient> getInfected();

    List<Patient> getInfectedByNationality(Nationality nationality);

    List<Patient> getSuspicious();

    List<Patient> getSuspiciousByNationality(Nationality nationality);

    List<Patient> getNotInfected();

    List<Patient> getNotInfectedByNationality(Nationality nationality);

    List<Patient> getPatientCombineByBlood(BloodType bloodType);

    List<Patient> getPatientCombineByBloodAndNationality(BloodType bloodType, Nationality nationality);

    void setPatientList(List<Patient> patientList);

}
