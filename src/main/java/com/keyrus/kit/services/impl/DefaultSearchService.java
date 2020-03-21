package com.keyrus.kit.services.impl;

import com.keyrus.kit.exceptions.BloodTypeException;
import com.keyrus.kit.exceptions.NationalityException;
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

import java.util.Scanner;
import java.util.Set;

import static com.keyrus.kit.models.enums.BloodType.getBloodType;

public class DefaultSearchService implements SearchService {

    private PersonService personService = new DefaultPersonService();
    private PersonFilter personFilter = new DefaultPersonFilter();
    private MenuUtils menuUtils = new DefaultMenuUtils();

    @Override
    public void baseSearch() {
        generateData();

        String option = "";

        while (!option.equals("0")) {
            generateInitialMenu();
            Scanner opt = new Scanner(System.in);
            option = opt.nextLine();

            try {
                switch (option) {
                    case "1":
                        menuUtils.showMenusSearchByDoc();
                        searchByDoc(generateStringScanner());
                        break;
                    case "2":
                        menuUtils.showMenusSearchByDnaOpt();
                        searchDna(generateStringScanner());
                        break;
                    case "3":
                        menuUtils.showMenusSearchInfected();
                        searchInfected(generateStringScanner());
                        break;
                    case "4":
                        menuUtils.showMenusSearchSuspicious();
                        searchSuspicious(generateStringScanner());
                        break;
                    case "5":
                        menuUtils.showMenusSearchNotInfected();
                        searchNotInfected(generateStringScanner());
                        break;
                    case "6":
                        menuUtils.showMenuSearchByBloodTypeOpt();
                        searchByBlood(generateStringScanner());
                        break;
                    case "7":
                        searchAllPatients();
                        break;
                    case "0":
                        System.out.println("Thanks for your time");
                        break;
                    default:
                        menuUtils.showInput();
                }

            }catch (NumberFormatException  e) {
                menuUtils.showErrorNumber();
                menuUtils.showException(e.toString());
            }catch (BloodTypeException e){
                menuUtils.showErrorBloodType();
                menuUtils.showException(e.toString());
            }catch (NationalityException e){
                menuUtils.showErrorCountry();
                menuUtils.showException(e.toString());
            }catch (IllegalArgumentException e) {
                menuUtils.showError();
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
        personFilter.setPatientList(personService.generatorPatient());
    }

    @Override
    public String generateStringScanner() {
        Scanner doc = new Scanner(System.in);
        String docScanner = doc.nextLine();
        return docScanner;
    }

    @Override
    public void searchByDoc(String doc) {
        Patient patient = personFilter.getPersonByDoc(doc);
        validEmptyResult(patient);
    }

    @Override
    public void searchDna(String doc) {
        switch (doc) {
            case "1":
                menuUtils.showMenusSearchByDna();
                String str = generateStringScanner();
                String dnaById = personFilter.getDnaById(Long.parseLong(str));
                System.out.println(dnaById);
                break;
            case "2":
                menuUtils.showMenusSearchByDnaCode();
                String dnaByCode = personFilter.getDnaByCode(generateStringScanner());
                System.out.println(dnaByCode);
                break;
            case "0":
                break;
            default:
                menuUtils.showInput();
                menuUtils.showMenusSearchByDnaOpt();
                searchDna(generateStringScanner());
        }
    }

    @Override
    public void searchInfected(String id) {
        switch (id) {
            case "1":
                Set<Patient> patients = personFilter.getInfected();
                validEmptyResultList(patients);
                break;
            case "2":
                menuUtils.showMenusSearchByNationality();
                Set<Patient> patientsNationality = personFilter.getInfectedByNationality(Nationality.getNationality(generateStringScanner()));
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
                Set<Patient> patients = personFilter.getSuspicious();
                validEmptyResultList(patients);
                break;
            case "2":
                menuUtils.showMenusSearchByNationality();
                Set<Patient> patientsNationality = personFilter.getSuspiciousByNationality((Nationality.getNationality(generateStringScanner())));
                validEmptyResultList(patientsNationality);
                break;
            case "0":
                break;
            default:
                menuUtils.showInput();
                menuUtils.showMenusSearchSuspicious();
                searchSuspicious(generateStringScanner());
        }
    }

    @Override
    public void searchNotInfected(String id) {
        switch (id) {
            case "1":
                Set<Patient> patients = personFilter.getNotInfected();
                validEmptyResultList(patients);
                break;
            case "2":
                menuUtils.showMenusSearchByNationality();
                Set<Patient> patientsNationality = personFilter.getNotInfectedByNationality((Nationality.getNationality(generateStringScanner())));
                validEmptyResultList(patientsNationality);
                break;
            case "0":
                break;
            default:
                menuUtils.showInput();
                menuUtils.showMenusSearchNotInfected();
                searchNotInfected(generateStringScanner());
        }
    }

    @Override
    public void searchByBlood(String opt) {
        switch (opt) {
            case "1":
                menuUtils.showMenuSearchByBloodType();
                Set<Patient> patients = personFilter.getPatientCombineByBlood(getBloodType(generateStringScanner()));
                validEmptyResultList(patients);
                break;
            case "2":
                menuUtils.showMenusSearchByNationality();
                String nationalityOpt = generateStringScanner();
                menuUtils.showMenuSearchByBloodType();
                String bloodOpt = generateStringScanner();
                Set<Patient> patientsNationality = personFilter.getPatientCombineByBloodAndNationality(getBloodType(bloodOpt), Nationality.getNationality(nationalityOpt));
                validEmptyResultList(patientsNationality);
                break;
            case "0":
                break;
            default:
                menuUtils.showInput();
                menuUtils.showMenuSearchByBloodTypeOpt();
                searchNotInfected(generateStringScanner());
        }
    }

    @Override
    public void searchAllPatients() {
        Set<Patient> patients = personFilter.getPatientAll();
        patients.forEach(System.out::println);
    }

    @Override
    public void validEmptyResult(Object object) {
        if (object instanceof Patient) {
            personService.validQuarantine((Patient) object);
        }

        if (object instanceof Patient || object instanceof Dna) {
            if (object == null) {
                menuUtils.showEmptyResult();
            } else {
                System.out.println(object);
            }
        } else {
            menuUtils.showError();
        }
    }

    @Override
    public void validEmptyResultList(Set<Patient> patients) {
        if (patients.isEmpty()) {
            menuUtils.showEmptyResult();
        } else {
            patients.forEach(this::accept);
            patients.forEach(System.out::println);
        }
    }

    private void accept(Patient patient) {
        personService.validQuarantine(patient);
    }
}
