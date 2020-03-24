package com.keyrus.kit.search.impl;

import com.keyrus.kit.models.Patient;
import com.keyrus.kit.models.enums.Nationality;
import com.keyrus.kit.search.SearchStrategy;

import java.util.Set;

public class InfectedSearch implements SearchStrategy {

    @Override
    public void search() {
        menuUtils.showMenusSearchInfected();
        switch (systemUtils.generateStringScanner()) {
            case "1":
                Set<Patient> patients = personFilter.getInfected();
                searchUtils.validEmptyResultList(patients);
                break;
            case "2":
                menuUtils.showMenusSearchByNationality();
                Set<Patient> patientsNationality = personFilter.getInfectedByNationality(Nationality.getNationality(systemUtils.generateStringScanner()));
                searchUtils.validEmptyResultList(patientsNationality);
                break;
            case "0":
                break;
            default:
                menuUtils.showInput();
                search();
        }
    }
}
