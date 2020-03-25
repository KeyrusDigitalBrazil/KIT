package com.keyrus.kit.utils.impl;

import com.keyrus.kit.filter.PersonFilter;
import com.keyrus.kit.models.Patient;
import com.keyrus.kit.utils.PersonUtils;
import com.keyrus.kit.utils.SearchUtils;

import java.util.Set;

public class DefaultPersonUtils implements PersonUtils {

    private PersonFilter personFilter;
    private SearchUtils searchUtils = new DefaultSearchUtils();

    @Override
    public void searchByDoc(String doc) {
        Patient patient = personFilter.getPersonByDoc(doc) == null ?  new Patient() : personFilter.getPersonByDoc(doc);
        searchUtils.validEmptyResult(patient);
    }

    @Override
    public void searchAllPatients() {
        Set<Patient> patients = personFilter.getPatientAll();
        patients.forEach(patient -> System.out.println(patient.toPrint()));
    }

    public void setPersonFilter(PersonFilter personFilter) {
        this.personFilter = personFilter;
    }
}
