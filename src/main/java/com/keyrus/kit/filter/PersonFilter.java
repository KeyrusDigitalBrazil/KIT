package com.keyrus.kit.filter;

import com.keyrus.kit.models.Patient;
import com.keyrus.kit.models.enums.BloodType;
import com.keyrus.kit.models.enums.Nationality;

import java.util.Set;

public interface PersonFilter {

    /**
     * Get patient by doc number
     *
     * @param doc
     * @return com.keyrus.kit.models.Patient
     */
    Patient getPersonByDoc(String doc);

    /**
     * Get DNA by ID
     *
     * @param id
     * @return String
     */
    String getDnaById(Long id);

    /**
     * Get DNA by code
     *
     * @param id
     * @return String
     */
    String getDnaByCode(String id);

    /**
     * Get patients infected
     *
     * @return Set of com.keyrus.kit.models.Patient
     */
    Set<Patient> getInfected();

    /**
     * Get patients infected by nationality
     *
     * @param nationality
     * @return Set of com.keyrus.kit.models.Patient
     */
    Set<Patient> getInfectedByNationality(Nationality nationality);

    /**
     * Get patients suspicious
     *
     * @return Set of com.keyrus.kit.models.Patient
     */
    Set<Patient> getSuspicious();

    /**
     * Get patients suspicious
     *
     * @param nationality
     * @return Set of com.keyrus.kit.models.Patient
     */
    Set<Patient> getSuspiciousByNationality(Nationality nationality);

    /**
     * Get patients not infected
     *
     * @return Set of com.keyrus.kit.models.Patient
     */
    Set<Patient> getNotInfected();

    /**
     * Get patients not infected
     *
     * @param nationality
     * @return Set of com.keyrus.kit.models.Patient
     */
    Set<Patient> getNotInfectedByNationality(Nationality nationality);

    /**
     * Get patients by blood type
     *
     * @param bloodType
     * @return Set of com.keyrus.kit.models.Patient
     */
    Set<Patient> getPatientCombineByBlood(BloodType bloodType);

    /**
     * Get patients by blood type and nationality
     *
     * @param bloodType
     * @param nationality
     * @return Set of com.keyrus.kit.models.Patient
     */
    Set<Patient> getPatientCombineByBloodAndNationality(BloodType bloodType, Nationality nationality);

    /**
     * Get all patients
     *
     * @return Set of com.keyrus.kit.models.Patient
     */
    Set<Patient> getPatientAll();

    /**
     * Set patient Set
     *
     * @param patientList
     */
    void setPatientList(Set<Patient> patientList);

    /**
     * Remove mask in doc
     *
     * @param doc
     * @return String
     */
    String cleanString(String doc);

}
