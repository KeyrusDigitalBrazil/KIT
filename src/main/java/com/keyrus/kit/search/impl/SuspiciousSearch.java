package com.keyrus.kit.search.impl;

import com.keyrus.kit.filter.PersonFilter;
import com.keyrus.kit.models.Patient;
import com.keyrus.kit.models.enums.Nationality;
import com.keyrus.kit.search.SearchStrategy;
import com.keyrus.kit.utils.MenuUtils;
import com.keyrus.kit.utils.SearchUtils;
import com.keyrus.kit.utils.SystemUtils;
import com.keyrus.kit.utils.impl.DefaultMenuUtils;
import com.keyrus.kit.utils.impl.DefaultSearchUtils;
import com.keyrus.kit.utils.impl.DefaultSystemUtils;

import java.util.Set;

public class SuspiciousSearch implements SearchStrategy {

    private PersonFilter personFilter;
    private MenuUtils menuUtils = new DefaultMenuUtils();
    private SearchUtils searchUtils = new DefaultSearchUtils();
    private SystemUtils systemUtils = new DefaultSystemUtils();

    public SuspiciousSearch(PersonFilter personFilter) {
        this.personFilter = personFilter;
    }

    @Override
    public void search() {
        menuUtils.showMenusSearchSuspicious();
        String opt = systemUtils.generateStringScanner();

        switch (opt) {
            case "1":
                Set<Patient> patients = personFilter.getSuspicious();
                searchUtils.validEmptyResultList(patients);
                break;
            case "2":
                menuUtils.showMenusSearchByNationality();
                Set<Patient> patientsNationality = personFilter.getSuspiciousByNationality((Nationality.getNationality(systemUtils.generateStringScanner())));
                searchUtils.validEmptyResultList(patientsNationality);
                break;
            case "0":
                break;
            default:
                menuUtils.showInput();
                menuUtils.showMenusSearchSuspicious();
                this.search();
        }
    }

}
