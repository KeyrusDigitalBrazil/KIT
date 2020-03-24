package com.keyrus.kit.services.impl;

import com.keyrus.kit.context.Context;
import com.keyrus.kit.exceptions.BloodTypeException;
import com.keyrus.kit.exceptions.NationalityException;
import com.keyrus.kit.filter.PersonFilter;
import com.keyrus.kit.filter.impl.DefaultPersonFilter;
import com.keyrus.kit.models.Patient;
import com.keyrus.kit.models.enums.Nationality;
import com.keyrus.kit.search.impl.DnaSearch;
import com.keyrus.kit.search.impl.InfectedSearch;
import com.keyrus.kit.services.PersonService;
import com.keyrus.kit.services.SearchService;
import com.keyrus.kit.utils.MenuUtils;
import com.keyrus.kit.utils.PersonUtils;
import com.keyrus.kit.utils.SearchUtils;
import com.keyrus.kit.utils.SystemUtils;
import com.keyrus.kit.utils.impl.DefaultMenuUtils;
import com.keyrus.kit.utils.impl.DefaultPersonUtils;
import com.keyrus.kit.utils.impl.DefaultSearchUtils;
import com.keyrus.kit.utils.impl.DefaultSystemUtils;

import java.util.Set;

import static com.keyrus.kit.models.enums.BloodType.getBloodType;

public class DefaultSearchService implements SearchService {

    private PersonService personService = new DefaultPersonService();
    private PersonFilter personFilter = new DefaultPersonFilter();
    private MenuUtils menuUtils = new DefaultMenuUtils();
    private SearchUtils searchUtils = new DefaultSearchUtils();
    private PersonUtils personUtils = new DefaultPersonUtils();
    private SystemUtils systemUtils = new DefaultSystemUtils();
    private Context context;

    @Override
    public void baseSearch() {
        generateData();

        String option = "";

        while (!option.equals("0")) {
            generateInitialMenu();

            option = systemUtils.generateStringScanner();

            try {
                switch (option) {
                    case "1":
                        menuUtils.showMenusSearchByDoc();
                        personUtils.searchByDoc(systemUtils.generateStringScanner());
                        break;
                    case "2":
                        DnaSearch dnaSearch = new DnaSearch();
                        dnaSearch.setPersonFilter(personFilter);
                        context = new Context(dnaSearch);
                        context.executeStrategy();
                        break;
                    case "3":
                        InfectedSearch infectedSearch = new InfectedSearch();
                        infectedSearch.setPersonFilter(personFilter);
                        context = new Context(infectedSearch);
                        context.executeStrategy();
                        break;
                    case "4":
                        menuUtils.showMenusSearchSuspicious();
                        searchSuspicious(systemUtils.generateStringScanner());
                        break;
                    case "5":
                        menuUtils.showMenusSearchNotInfected();
                        searchNotInfected(systemUtils.generateStringScanner());
                        break;
                    case "6":
                        menuUtils.showMenuSearchByBloodTypeOpt();
                        searchByBlood(systemUtils.generateStringScanner());
                        break;
                    case "7":
                        personUtils.searchAllPatients();
                        break;
                    case "0":
                        System.out.println("Thanks for your time");
                        break;
                    default:
                        menuUtils.showInput();
                }

            } catch (NumberFormatException e) {
                menuUtils.showErrorNumber();
                menuUtils.showException(e.toString());
            } catch (BloodTypeException e) {
                menuUtils.showErrorBloodType();
                menuUtils.showException(e.toString());
            } catch (NationalityException e) {
                menuUtils.showErrorCountry();
                menuUtils.showException(e.toString());
            } catch (Exception e) {
                menuUtils.showError();
                menuUtils.showException(e.toString());
            }

        }
    }

    @Override
    public void generateInitialMenu() {
        menuUtils.showMenuPrincipal();
    }

    @Override
    public void generateData() {
        Set<Patient> patients = personService.generatorPatient();

        personFilter.setPatientList(patients);
        personUtils.setPersonFilter(personFilter);
    }

    @Override
    public void searchSuspicious(String id) {
        switch (id) {
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
                searchSuspicious(systemUtils.generateStringScanner());
        }
    }

    @Override
    public void searchNotInfected(String id) {
        switch (id) {
            case "1":
                Set<Patient> patients = personFilter.getNotInfected();
                searchUtils.validEmptyResultList(patients);
                break;
            case "2":
                menuUtils.showMenusSearchByNationality();
                Set<Patient> patientsNationality = personFilter.getNotInfectedByNationality((Nationality.getNationality(systemUtils.generateStringScanner())));
                searchUtils.validEmptyResultList(patientsNationality);
                break;
            case "0":
                break;
            default:
                menuUtils.showInput();
                menuUtils.showMenusSearchNotInfected();
                searchNotInfected(systemUtils.generateStringScanner());
        }
    }

    @Override
    public void searchByBlood(String opt) {
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
                searchNotInfected(systemUtils.generateStringScanner());
        }
    }

}
