package com.keyrus.kit.services;

import com.keyrus.kit.models.Patient;

import java.util.List;

public interface PersonService {

    List<Patient> generatorPatient();

    void calculateRiskAge(Patient patient);

    void validQuarantine(Patient patient);
}
