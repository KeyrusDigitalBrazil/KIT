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

import static com.keyrus.kit.models.enums.BloodType.getBloodType;

public class BloodyTypeSearch implements SearchStrategy {

    private PersonFilter personFilter;
    private MenuUtils menuUtils = new DefaultMenuUtils();
    private SearchUtils searchUtils = new DefaultSearchUtils();
    private SystemUtils systemUtils = new DefaultSystemUtils();

    public BloodyTypeSearch(PersonFilter personFilter) {
        this.personFilter = personFilter;
    }

    @Override
    public void search() {
        menuUtils.showMenuSearchByBloodTypeOpt();
        String opt = systemUtils.generateStringScanner();

        switch (opt) {
            case "1":
                menuUtils.showMenuSearchByBloodType();
                Set<Patient> patients = personFilter.getPatientCombineByBlood(getBloodType(systemUtils.generateStringScanner()));
                searchUtils.validEmptyResultList(patients);
                break;
            case "2":
                menuUtils.showMenusSearchByNationality();
                String nationalityOpt = systemUtils.generateStringScanner();
                menuUtils.showMenuSearchByBloodType();
                String bloodOpt = systemUtils.generateStringScanner();
                Set<Patient> patientsNationality = personFilter.getPatientCombineByBloodAndNationality(Nationality.getNationality(nationalityOpt), getBloodType(bloodOpt));
                searchUtils.validEmptyResultList(patientsNationality);
                break;
            case "0":
                break;
            default:
                menuUtils.showInput();
                menuUtils.showMenuSearchByBloodTypeOpt();
                this.search();
        }
    }

}
