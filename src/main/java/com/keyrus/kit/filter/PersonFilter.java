package com.keyrus.kit.filter;

import com.keyrus.kit.models.Dna;
import com.keyrus.kit.models.Patient;
import com.keyrus.kit.models.enums.BloodType;
import com.keyrus.kit.models.enums.Nationality;

import java.util.List;

public interface PersonFilter {

    /**
     * Get patient by doc number
     * @param doc
     * @return com.keyrus.kit.models.Patient
     */
    Patient getPersonByDoc(String doc);

    /**
     * Get DNA by ID
     * @param id
     * @return String
     */
    String getDnaById(Long id);

    /**
     * Get DNA by code
     * @param id
     * @return String
     */
    String getDnaByCode(String id);

    /**
     * Get patients infected
     * @return List of com.keyrus.kit.models.Patient
     */
    List<Patient> getInfected();

    /**
     * Get patients infected by nationality
     * @param nationality
     * @return List of com.keyrus.kit.models.Patient
     */
    List<Patient> getInfectedByNationality(Nationality nationality);

    /**
     * Get patients suspicious
     * @return List of com.keyrus.kit.models.Patient
     */
    List<Patient> getSuspicious();

    /**
     * Get patients suspicious
     * @param nationality
     * @return List of com.keyrus.kit.models.Patient
     */
    List<Patient> getSuspiciousByNationality(Nationality nationality);

    /**
     * Get patients not infected
     * @return List of com.keyrus.kit.models.Patient
     */
    List<Patient> getNotInfected();

    /**
     * Get patients not infected
     * @param nationality
     * @return List of com.keyrus.kit.models.Patient
     */
    List<Patient> getNotInfectedByNationality(Nationality nationality);

    /**
     * Get patients by blood type
     * @param bloodType
     * @return List of com.keyrus.kit.models.Patient
     */
    List<Patient> getPatientCombineByBlood(BloodType bloodType);

    /**
     * Get patients by blood type and nationality
     * @param bloodType
     * @param nationality
     * @return List of com.keyrus.kit.models.Patient
     */
    List<Patient> getPatientCombineByBloodAndNationality(BloodType bloodType, Nationality nationality);

    /**
     * Get all patients
     * @return List of com.keyrus.kit.models.Patient
     */
    List<Patient> getPatientAll();

    /**
     * Set patient list
     * @param patientList
     */
    void setPatientList(List<Patient> patientList);

    /**
     * Remove mask in doc
     * @param doc
     * @return String
     */
    String cleanString(String doc);

}
