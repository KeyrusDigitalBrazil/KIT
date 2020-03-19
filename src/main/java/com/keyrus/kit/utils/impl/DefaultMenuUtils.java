package com.keyrus.kit.utils.impl;

import com.keyrus.kit.utils.MenuUtils;

public class DefaultMenuUtils implements MenuUtils {

    @Override
    public void showMenuPrincipal() {
        System.out.println("==========================================================================================================================");
        System.out.println("                                                     Search Patients                                                ");
        System.out.println("==========================================================================================================================");
        System.out.println("Options: 1 - Doc | 2 - DNA | 3 - Infected | 4 - Suspicious | 5 - Not Infected | 6 - Blood | 7 - All Patients | 0 - Quit");
        System.out.println("==========================================================================================================================");
    }

    @Override
    public void showMenusSearchByDoc() {
        System.out.println("====================================================================================================");
        System.out.println("                                     Insert your DOC number                                         ");
        System.out.println("====================================================================================================");

    }

    @Override
    public void showMenusSearchByDna() {
        System.out.println("====================================================================================================");
        System.out.println("                                     Insert your DNA ID                                             ");
        System.out.println("====================================================================================================");

    }

    @Override
    public void showMenusSearchInfected() {
        System.out.println("====================================================================================================");
        System.out.println("    Options: 1 - Search all infected | 2 - Search infected by nationality  | 0 - Quit               ");
        System.out.println("====================================================================================================");
    }

    @Override
    public void showMenusSearchByNationality() {
        System.out.println("====================================================================================================");
        System.out.println("                                     Insert Nationality                                             ");
        System.out.println("====================================================================================================");
    }

    @Override
    public void showMenusSearchSuspicious() {
        System.out.println("====================================================================================================");
        System.out.println("    Options: 1 - Search all suspicious | 2 - Search suspicious by nationality  | 0 - Quit           ");
        System.out.println("====================================================================================================");
    }

    @Override
    public void showMenusSearchNotInfected() {
        System.out.println("====================================================================================================");
        System.out.println("    Options: 1 - Search all not infected | 2 - Search not infected by nationality | 0 - Quit        ");
        System.out.println("====================================================================================================");
    }

    public void showMenuSearchByBloodTypeOpt() {
        System.out.println("====================================================================================================");
        System.out.println("    Options: 1 - Search by blood type | 2 - Search by blood type and nationality | 0 - Quit         ");
        System.out.println("====================================================================================================");
    }

    public void showMenuSearchByBloodType() {
        System.out.println("====================================================================================================");
        System.out.println("                                   Insert Blood Type                                                ");
        System.out.println("====================================================================================================");
    }

    public void showEmptyResult() {
        System.out.println("====================================================================================================");
        System.out.println("                                      Empty Result                                                  ");
        System.out.println("====================================================================================================");
    }

    @Override
    public void showError() {
        System.out.println("====================================================================================================");
        System.out.println("                                         ERROR                                                      ");
        System.out.println("====================================================================================================");
    }

    @Override
    public void showInput() {
        System.out.println("====================================================================================================");
        System.out.println("                                   Input a valid option                                             ");
        System.out.println("====================================================================================================");
    }

}
