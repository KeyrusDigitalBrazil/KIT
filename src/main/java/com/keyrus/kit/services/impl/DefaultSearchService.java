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
                        Scanner doc = new Scanner(System.in);
                        String docScanner = doc.nextLine();
                        Patient patient = personFilter.getPersonByDoc(docScanner);
                        validEmptyResult(patient);
                        generateInitialMenu();
                        break;
                    case "2":
                        menuUtils.showMenusSearchByDna();
                        Scanner dna = new Scanner(System.in);
                        String dnaScanner = dna.nextLine();
                        Dna dnaFilter = personFilter.getDnaById(Long.parseLong(dnaScanner));
                        validEmptyResult(dnaFilter);
                        generateInitialMenu();
                        break;
                    case "3":
                        menuUtils.showMenusSearchInfected();
                        Scanner infected = new Scanner(System.in);
                        String infectedScanner = infected.nextLine();
                        searchInfected(infectedScanner);
                        generateInitialMenu();
                        break;
                    case "4":
                        menuUtils.showMenusSearchSuspicious();
                        Scanner suspicious = new Scanner(System.in);
                        String suspiciousScanner = suspicious.nextLine();
                        searchSuspicious(suspiciousScanner);
                        generateInitialMenu();
                        break;
                    case "5":
                        menuUtils.showMenusSearchNotInfected();
                        Scanner notInfected = new Scanner(System.in);
                        String notInfectedScanner = notInfected.nextLine();
                        searchNotInfected(notInfectedScanner);
                        generateInitialMenu();
                        break;
                    case "6":
                        menuUtils.showMenuSearchByBloodTypeOpt();
                        Scanner scnSix = new Scanner(System.in);
                        String optSix = scnSix.nextLine();
                        searchByBlood(optSix);
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
    public void searchInfected(String id) {
        switch (id) {
            case "1":
                List<Patient> patients = personFilter.getInfected();
                validEmptyResultList(patients);
                break;
            case "2":
                menuUtils.showMenusSearchByNationality();
                Scanner infected = new Scanner(System.in);
                String infectedScanner = infected.nextLine();
                List<Patient> patientsNationality = personFilter.getInfectedByNationality(Nationality.valueOf(infectedScanner));
                validEmptyResultList(patientsNationality);
                break;
            case "0":
                break;
            default:
                menuUtils.showInput();
                menuUtils.showMenusSearchInfected();
                Scanner infectedError = new Scanner(System.in);
                String infectedErrorScanner = infectedError.nextLine();
                searchInfected(infectedErrorScanner);
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
                Scanner infected = new Scanner(System.in);
                String infectedScanner = infected.nextLine();
                List<Patient> patientsNationality = personFilter.getSuspiciousByNationality((Nationality.valueOf(infectedScanner)));
                validEmptyResultList(patientsNationality);
                break;
            case "0":
                break;
            default:
                menuUtils.showInput();
                menuUtils.showMenusSearchInfected();
                Scanner infectedError = new Scanner(System.in);
                String infectedErrorScanner = infectedError.nextLine();
                searchSuspicious(infectedErrorScanner);
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
                Scanner notInfected = new Scanner(System.in);
                String notInfectedScanner = notInfected.nextLine();
                List<Patient> patientsNationality = personFilter.getNotInfectedByNationality((Nationality.valueOf(notInfectedScanner)));
                validEmptyResultList(patientsNationality);
                break;
            case "0":
                break;
            default:
                menuUtils.showInput();
                menuUtils.showMenusSearchInfected();
                Scanner notInfectedError = new Scanner(System.in);
                String notInfectedErrorScanner = notInfectedError.nextLine();
                searchNotInfected(notInfectedErrorScanner);
        }
    }

    @Override
    public void searchByBlood(String opt) {
        switch (opt) {
            case "1":
                menuUtils.showMenuSearchByBloodType();
                Scanner scnSix = new Scanner(System.in);
                String optSix = scnSix.nextLine();
                List<Patient> patients = personFilter.getPatientCombineByBlood(getBloodType(optSix));
                validEmptyResultList(patients);
                break;
            case "2":
                menuUtils.showMenusSearchByNationality();
                Scanner nationality = new Scanner(System.in);
                String nationalityOpt = nationality.nextLine();
                menuUtils.showMenuSearchByBloodType();
                Scanner blood = new Scanner(System.in);
                String bloodOpt = blood.nextLine();
                List<Patient> patientsNationality = personFilter.getPatientCombineByBloodAndNationality(getBloodType(bloodOpt), Nationality.valueOf(nationalityOpt));
                validEmptyResultList(patientsNationality);
                break;
            case "0":
                break;
            default:
                menuUtils.showInput();
                menuUtils.showMenusSearchInfected();
                Scanner notInfectedError = new Scanner(System.in);
                String notInfectedErrorScanner = notInfectedError.nextLine();
                searchNotInfected(notInfectedErrorScanner);
        }
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
