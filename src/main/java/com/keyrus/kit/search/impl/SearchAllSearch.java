package com.keyrus.kit.search.impl;

import com.keyrus.kit.filter.PersonFilter;
import com.keyrus.kit.models.Patient;
import com.keyrus.kit.search.SearchStrategy;

import java.util.Set;

public class SearchAllSearch implements SearchStrategy {

    private PersonFilter personFilter;

    public SearchAllSearch(PersonFilter personFilter) {
        this.personFilter = personFilter;
    }

    @Override
    public void search() {
        Set<Patient> patients = personFilter.getPatientAll();
        patients.forEach(patient -> System.out.println(patient.toPrint()));
    }

}
