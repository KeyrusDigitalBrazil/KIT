package com.keyrus.kit.services.impl;

import com.keyrus.kit.filter.PersonFilter;
import com.keyrus.kit.filter.impl.DefaultPersonFilter;
import com.keyrus.kit.models.enums.Nationality;
import com.keyrus.kit.services.PersonService;
import com.keyrus.kit.services.SearchService;
import com.keyrus.kit.utils.MenuUtils;
import com.keyrus.kit.utils.impl.DefaultMenuUtils;

import java.util.Scanner;

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
                        System.out.println(personFilter.getPersonByDoc(docScanner));
                        generateInitialMenu();
                        break;
                    case "2":
                        menuUtils.showMenusSearchByDna();
                        Scanner dna = new Scanner(System.in);
                        String dnaScanner = dna.nextLine();
                        System.out.println(personFilter.getDnaById(Long.parseLong(dnaScanner)));
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
                System.out.println(personFilter.getInfected());
                break;
            case "2":
                menuUtils.showMenusSearchByNationality();
                Scanner infected = new Scanner(System.in);
                String infectedScanner = infected.nextLine();
                System.out.println(personFilter.getInfectedByNationality(Nationality.valueOf(infectedScanner)));
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
                System.out.println(personFilter.getSuspicious());
                break;
            case "2":
                menuUtils.showMenusSearchByNationality();
                Scanner infected = new Scanner(System.in);
                String infectedScanner = infected.nextLine();
                System.out.println(personFilter.getSuspiciousByNationality((Nationality.valueOf(infectedScanner))));
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
                System.out.println(personFilter.getNotInfected());
                break;
            case "2":
                menuUtils.showMenusSearchByNationality();
                Scanner notInfected = new Scanner(System.in);
                String notInfectedScanner = notInfected.nextLine();
                System.out.println(personFilter.getNotInfectedByNationality((Nationality.valueOf(notInfectedScanner))));
                break;
            case "0":
                break;
            default:
                menuUtils.showInput();
                menuUtils.showMenusSearchInfected();
                Scanner notInfectedError = new Scanner(System.in);
                String notInfectedErrorScanner = notInfectedError.nextLine();
                searchSuspicious(notInfectedErrorScanner);
        }
    }
}
