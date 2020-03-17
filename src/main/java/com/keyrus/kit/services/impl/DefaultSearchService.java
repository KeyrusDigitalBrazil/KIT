package com.keyrus.kit.services.impl;

import com.keyrus.kit.filter.PersonFilter;
import com.keyrus.kit.filter.impl.DefaultPersonFilter;
import com.keyrus.kit.models.Dna;
import com.keyrus.kit.models.Patient;
import com.keyrus.kit.models.enums.BloodType;
import com.keyrus.kit.models.enums.Nationality;
import com.keyrus.kit.services.PersonService;
import com.keyrus.kit.services.SearchService;
import com.keyrus.kit.utils.MenuUtils;
import com.keyrus.kit.utils.impl.DefaultMenuUtils;

import java.util.List;
import java.util.Scanner;

import static com.keyrus.kit.models.enums.BloodType.getBloodType;

public class DefaultSearchService implements SearchService {

    private PersonService personService = new DefaultPersonService();
    private PersonFilter personFilter = new DefaultPersonFilter();
    private MenuUtils menuUtils = new DefaultMenuUtils();

    @Override
    public void baseSearch() {
        generateData();

        String option = "";
        generateInitialMenu();

        while (!option.equals("0")) {
            Scanner opt = new Scanner(System.in);
            option = opt.nextLine();

            try {
                switch (option) {
                    case "1":
                        menuUtils.showMenusSearchByDoc();
                        searchByDoc(generateStringScanner());
                        generateInitialMenu();
                        break;
                    case "2":
                        menuUtils.showMenusSearchByDna();
                        searchDna(generateStringScanner());
                        generateInitialMenu();
                        break;
                    case "3":
                        menuUtils.showMenusSearchInfected();
                        searchInfected(generateStringScanner());
                        generateInitialMenu();
                        break;
                    case "4":
                        menuUtils.showMenusSearchSuspicious();
                        searchSuspicious(generateStringScanner());
                        generateInitialMenu();
                        break;
                    case "5":
                        menuUtils.showMenusSearchNotInfected();
                        searchNotInfected(generateStringScanner());
                        generateInitialMenu();
                        break;
                    case "6":
                        menuUtils.showMenuSearchByBloodTypeOpt();
                        searchByBlood(generateStringScanner());
                        generateInitialMenu();
                        break;
                    case "7":
                        searchAllPatients();
                        generateInitialMenu();
                        break;
                    case "0":
                        System.out.println("Thanks for your time");
                        break;
                    default:
                        menuUtils.showInput();
                        generateInitialMenu();
                }

            } catch (Exception e) {
                menuUtils.showError();
                generateInitialMenu();
            }

        }
    }

    @Override
    public void generateInitialMenu() {
        menuUtils.showMenuPrincipal();
    }

    @Override
    public void generateData() {
        personFilter.setPatientList(personService.generatorPatient());
    }

    @Override
    public String generateStringScanner(){
        Scanner doc = new Scanner(System.in);
        String docScanner = doc.nextLine();
        return docScanner;
    }

    @Override
    public void searchByDoc(String doc){
        Patient patient = personFilter.getPersonByDoc(doc);
        validEmptyResult(patient);
    }

    public void searchDna(String doc){
        Long dna = Long.parseLong(doc);
        validEmptyResult(personFilter.getDnaById(dna));
    }
    @Override
    public void searchInfected(String id) {
        switch (id) {
            case "1":
                List<Patient> patients = personFilter.getInfected();
                validEmptyResultList(patients);
                break;
            case "2":
                menuUtils.showMenusSearchByNationality();
                List<Patient> patientsNationality = personFilter.getInfectedByNationality(Nationality.valueOf(generateStringScanner()));
                validEmptyResultList(patientsNationality);
                break;
            case "0":
                break;
            default:
                menuUtils.showInput();
                menuUtils.showMenusSearchInfected();
                searchInfected(generateStringScanner());
        }
    }

    @Override
    public void searchSuspicious(String id) {
        switch (id) {
            case "1":
                List<Patient> patients = personFilter.getSuspicious();
                validEmptyResultList(patients);
                break;
            case "2":
                menuUtils.showMenusSearchByNationality();
                List<Patient> patientsNationality = personFilter.getSuspiciousByNationality((Nationality.valueOf(generateStringScanner())));
                validEmptyResultList(patientsNationality);
                break;
            case "0":
                break;
            default:
                menuUtils.showInput();
                menuUtils.showMenusSearchInfected();
                searchSuspicious(generateStringScanner());
        }
    }

    @Override
    public void searchNotInfected(String id) {
        switch (id) {
            case "1":
                List<Patient> patients = personFilter.getNotInfected();
                validEmptyResultList(patients);
                break;
            case "2":
                menuUtils.showMenusSearchByNationality();
                List<Patient> patientsNationality = personFilter.getNotInfectedByNationality((Nationality.valueOf(generateStringScanner())));
                validEmptyResultList(patientsNationality);
                break;
            case "0":
                break;
            default:
                menuUtils.showInput();
                menuUtils.showMenusSearchInfected();
                searchNotInfected(generateStringScanner());
        }
    }

    @Override
    public void searchByBlood(String opt) {
        switch (opt) {
            case "1":
                menuUtils.showMenuSearchByBloodType();
                List<Patient> patients = personFilter.getPatientCombineByBlood(getBloodType(generateStringScanner()));
                validEmptyResultList(patients);
                break;
            case "2":
                menuUtils.showMenusSearchByNationality();
                String nationalityOpt = generateStringScanner();
                menuUtils.showMenuSearchByBloodType();
                String bloodOpt = generateStringScanner();
                List<Patient> patientsNationality = personFilter.getPatientCombineByBloodAndNationality(getBloodType(bloodOpt), Nationality.valueOf(nationalityOpt));
                validEmptyResultList(patientsNationality);
                break;
            case "0":
                break;
            default:
                menuUtils.showInput();
                menuUtils.showMenusSearchInfected();
                searchNotInfected(generateStringScanner());
        }
    }

    @Override
    public void searchAllPatients(){
        List<Patient> patients = personFilter.getPatientAll();
        patients.forEach(System.out::println);
    }

    @Override
    public void validEmptyResult(Object object) {
        if(object instanceof Patient || object instanceof Dna) {
            if(object == null) {
                menuUtils.showEmptyResult();
            } else {
                System.out.println(object);
            }
        } else {
            menuUtils.showError();
        }

    }

    @Override
    public void validEmptyResultList(List<Patient> patients) {
        if(patients.isEmpty()) {
            menuUtils.showEmptyResult();
        } else {
            patients.forEach(System.out::println);
        }
    }
}
