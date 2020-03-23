package com.keyrus.kit.utils.impl;

import com.keyrus.kit.utils.MenuUtils;

public class DefaultMenuUtils implements MenuUtils {

    @Override
    public void showMenuPrincipal() {
        System.out.println("==========================================================================================================================");
        System.out.println("                                                     Search Patients                                                      ");
        System.out.println("==========================================================================================================================");
        System.out.println("Options: 1 - DOC | 2 - DNA | 3 - Infected | 4 - Suspicious | 5 - Not Infected | 6 - Blood | 7 - All Patients | 0 - Quit   ");
        System.out.println("==========================================================================================================================");
    }

    @Override
    public void showMenusSearchByDnaOpt() {
        System.out.println("==========================================================================================================================");
        System.out.println("                        Options: 1 - Search DNA ID | 2 - Search DNA code  | 0 - Quit                                      ");
        System.out.println("==========================================================================================================================");

    }

    @Override
    public void showMenusSearchByDna() {
        System.out.println("==========================================================================================================================");
        System.out.println("                                                Insert your DNA ID                                                        ");
        System.out.println("==========================================================================================================================");

    }

    @Override
    public void showMenusSearchByDnaCode() {
        System.out.println("==========================================================================================================================");
        System.out.println("                                                Insert your DNA CODE                                                      ");
        System.out.println("==========================================================================================================================");
    }

    @Override
    public void showMenusSearchByDoc() {
        System.out.println("==========================================================================================================================");
        System.out.println("                                                Insert your DOC code                                                      ");
        System.out.println("==========================================================================================================================");

    }

    @Override
    public void showMenusSearchInfected() {
        System.out.println("==========================================================================================================================");
        System.out.println("                   Options: 1 - Search all infected | 2 - Search infected by nationality  | 0 - Quit                      ");
        System.out.println("==========================================================================================================================");
    }

    @Override
    public void showMenusSearchByNationality() {
        System.out.println("==========================================================================================================================");
        System.out.println("                                                  Insert Nationality                                                      ");
        System.out.println("==========================================================================================================================");
    }

    @Override
    public void showMenusSearchSuspicious() {
        System.out.println("==========================================================================================================================");
        System.out.println("               Options: 1 - Search all suspicious | 2 - Search suspicious by nationality  | 0 - Quit                      ");
        System.out.println("==========================================================================================================================");
    }

    @Override
    public void showMenusSearchNotInfected() {
        System.out.println("==========================================================================================================================");
        System.out.println("               Options: 1 - Search all not infected | 2 - Search not infected by nationality | 0 - Quit                   ");
        System.out.println("==========================================================================================================================");
    }

    public void showMenuSearchByBloodTypeOpt() {
        System.out.println("==========================================================================================================================");
        System.out.println("               Options: 1 - Search by blood type | 2 - Search by blood type and nationality | 0 - Quit                    ");
        System.out.println("==========================================================================================================================");
    }

    public void showMenuSearchByBloodType() {
        System.out.println("==========================================================================================================================");
        System.out.println("                                                 Insert Blood Type                                                        ");
        System.out.println("==========================================================================================================================");
    }

    public void showEmptyResult() {
        System.out.println("==========================================================================================================================");
        System.out.println("                                                    Empty Result                                                          ");
        System.out.println("==========================================================================================================================");
    }

    @Override
    public void showError() {
        System.out.println("==========================================================================================================================");
        System.out.println("                                                        ERROR                                                             ");
        System.out.println("==========================================================================================================================");
    }

    @Override
    public void showErrorNumber() {
        System.out.println("==========================================================================================================================");
        System.out.println("                                           ERROR - Insert a DNA ID valid                                                  ");
        System.out.println("==========================================================================================================================");
    }

    @Override
    public void showInput() {
        System.out.println("==========================================================================================================================");
        System.out.println("                                                 Input a valid option                                                     ");
        System.out.println("==========================================================================================================================");
    }

    @Override
    public void showException(String msg) {
        System.out.println(msg);
    }

    @Override
    public void showErrorCountry() {
        System.out.println("==========================================================================================================================");
        System.out.println("                                                        ERROR                                                             ");
        System.out.println("                                               Insert a country code valid                                                ");
        System.out.println("" +
                "                                                     BRA for Brazil,\n" +
                "                                                     COM for Colombia,\n" +
                "                                                     CHN for China,\n" +
                "                                                     ITA for Italy,\n" +
                "                                                     TUN for Tunisia,\n" +
                "                                                     DEU for Germany,\n" +
                "                                                     FRA for France,\n" +
                "                                                     PRT for Portugal,\n" +
                "                                                     CA  for Canada,\n" +
                "                                                     AFG  for Afghanistan");
        System.out.println("==========================================================================================================================");
    }

    @Override
    public void showErrorBloodType() {
        System.out.println("==========================================================================================================================");
        System.out.println("                                                        ERROR                                                             ");
        System.out.println("                                               Insert a Blood code valid                                                  ");
        System.out.println("" +
                "                                                     A+ for Blood A+,\n" +
                "                                                     A- for Blood A-,\n" +
                "                                                     B+ for Blood B+,\n" +
                "                                                     B- for Blood B-,\n" +
                "                                                     AB+ for Blood AB+,\n" +
                "                                                     AB- for Blood AB-,\n" +
                "                                                     O+ for Blood O+,\n" +
                "                                                     O- for Blood O-");
        System.out.println("==========================================================================================================================");
    }

}
