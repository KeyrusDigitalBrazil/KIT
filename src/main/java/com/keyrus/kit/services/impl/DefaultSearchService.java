package com.keyrus.kit.services.impl;

import com.keyrus.kit.filter.PersonFilter;
import com.keyrus.kit.filter.impl.DefaultPersonFilter;
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
                        break;
                    case "4":
                        break;
                    case "5":
                        break;
                    case "6":
                        break;
                    case "0":
                        System.out.println("Thanks for your time");
                        break;
                    default:
                        System.out.println("Input a valid option");
                        generateInitialMenu();
                }

            }catch (Exception e){
                System.out.println("====================================================================================================");
                System.out.println("                                         ERROR");
                System.out.println("====================================================================================================");

            }

        }

        generateInitialMenu();
    }

    @Override
    public void generateInitialMenu() {
        menuUtils.showMenuPrincipal();
    }

    @Override
    public void generateData() {
        personFilter.setPatientList(personService.generatorPatient());
    }

}
