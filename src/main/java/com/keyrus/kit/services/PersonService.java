package com.keyrus.kit.services;

import com.keyrus.kit.models.Patient;

import java.util.List;
import java.util.Set;

public interface PersonService {

    /**
     * Generate initial patient data
     * @return List of com.keyrus.kit.models.Patient
     */
    Set<Patient> generatorPatient();

    /**
     * Calc of risk by agr for patient
     * @param patient
     */
    void calculateRiskAge(Patient patient);

    /**
     * Define by random quarantine
     * @param patient
     */
    void validQuarantine(Patient patient);
}
