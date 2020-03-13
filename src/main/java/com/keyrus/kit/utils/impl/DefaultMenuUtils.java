package com.keyrus.kit.utils.impl;

import com.keyrus.kit.utils.MenuUtils;

public class DefaultMenuUtils implements MenuUtils {

    @Override
    public String cleanString(String doc) {
        return doc.replace("[^a-zA-Z0-9]", "");
    }

    @Override
    public void showMenuPrincipal() {
        System.out.println("====================================================================================================");
        System.out.println("                                     Search Patients");
        System.out.println("====================================================================================================");
        System.out.println("Options: 1 - Doc | 2 - DNA | 3 - Infected | 4 - Suspicious | 5 - Not Infected | 6 - Blood | 0 - Quit");
        System.out.println("====================================================================================================");
    }

    @Override
    public void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    @Override
    public void showMenusSearchByDoc() {
        System.out.println("====================================================================================================");
        System.out.println("Insert your doc number");
    }

    @Override
    public void showMenusSearchByDna() {
        System.out.println("====================================================================================================");
        System.out.println("Insert your dna");
    }
}
