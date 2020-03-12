package com.keyrus.kit;

import com.keyrus.kit.models.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String option = "1";

        showMenu();

        while (!option.equals("0")) {
            Scanner opt = new Scanner(System.in);
            option = opt.nextLine();

            switch (option) {
                case "1":
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

    public List<Person> generateData() {
        List<Person> pessoas = new ArrayList<>();
        return pessoas;
    }

}
