package com.keyrus.kit;

import com.keyrus.kit.filter.PersonFilter;
import com.keyrus.kit.filter.impl.DefaultPersonFilter;
import com.keyrus.kit.models.Person;
import com.keyrus.kit.services.PersonService;
import com.keyrus.kit.services.impl.DefaultPersonService;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static PersonService personService = new DefaultPersonService();
    private static PersonFilter personFilter = new DefaultPersonFilter();

    public static void main(String[] args) {
        generateData();

        String option = "1";

        showMenu();

        while (!option.equals("0")) {
            Scanner opt = new Scanner(System.in);
            option = opt.nextLine();

            switch (option) {
                case "1":
                    System.out.println("====================================================================================================");
                    System.out.println("Digite o documento");
                    Scanner doc = new Scanner(System.in);
                    String docScanner = doc.nextLine();
                    System.out.println(personFilter.getPersonByDoc(docScanner));
                    break;
                case "2":
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
                    System.out.println("Digite uma opção válida");
                    showMenu();
            }

        }

    }

    private static void showMenu() {
        System.out.println("====================================================================================================");
        System.out.println("                                     Search Patients");
        System.out.println("====================================================================================================");
        System.out.println("Options: 1 - Doc | 2 - DNA | 3 - Infected | 4 - Suspicious | 5 - Not Infected | 6 - Blood | 0 - Quit");
        System.out.println("====================================================================================================");
    }

    private static void clearMenu() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void generateData() {
        personFilter.setPatientList(personService.generatorPatient());
    }

}
