package com.keyrus.kit.utils.impl;

import com.keyrus.kit.utils.MenuUtils;

public class DefaultMenuUtils implements MenuUtils {

    @Override
    public void showMenuPrincipal() {
        String showMenuPrincipalString =
                """
                ==========================================================================================================================
                                                                     Search Patients
                ==========================================================================================================================
                Options: 1 - DOC | 2 - DNA | 3 - Infected | 4 - Suspicious | 5 - Not Infected | 6 - Blood | 7 - All Patients | 0 - Quit
                ==========================================================================================================================""";
        System.out.println(showMenuPrincipalString);
    }

    @Override
    public void showMenusSearchByDnaOpt() {
        String showMenusSearchByDnaOptString =
                """
                ==========================================================================================================================
                                        Options: 1 - Search DNA ID | 2 - Search DNA code  | 0 - Quit
                ==========================================================================================================================""";
        System.out.println(showMenusSearchByDnaOptString);
    }

    @Override
    public void showMenusSearchByDna() {
        String showMenusSearchByDnaString =
                """
                ==========================================================================================================================
                                                                Insert your DNA ID
                ==========================================================================================================================""";
        System.out.println(showMenusSearchByDnaString);
    }

    @Override
    public void showMenusSearchByDnaCode() {
        String showMenusSearchByDnaCodeString =
                """
                ==========================================================================================================================
                                                                Insert your DNA CODE
                ==========================================================================================================================""";
        System.out.println(showMenusSearchByDnaCodeString);
    }

    @Override
    public void showMenusSearchByDoc() {
        String showMenusSearchByDocString =
                """
                ==========================================================================================================================
                                                                Insert your DOC code                                                      
                ==========================================================================================================================""";
        System.out.println(showMenusSearchByDocString);
    }

    @Override
    public void showMenusSearchInfected() {
        String showMenusSearchInfectedString =
                """
                ==========================================================================================================================
                                   Options: 1 - Search all infected | 2 - Search infected by nationality  | 0 - Quit                      
                ==========================================================================================================================""";
        System.out.println(showMenusSearchInfectedString);
    }

    @Override
    public void showMenusSearchByNationality() {
        String showMenusSearchByNationalityString =
                """
                ==========================================================================================================================
                                                                  Insert Nationality                                                      
                ==========================================================================================================================""";
        System.out.println(showMenusSearchByNationalityString);
    }

    @Override
    public void showMenusSearchSuspicious() {
        String showMenusSearchSuspiciousString =
                """
                ==========================================================================================================================
                               Options: 1 - Search all suspicious | 2 - Search suspicious by nationality  | 0 - Quit                      
                ==========================================================================================================================""";
        System.out.println(showMenusSearchSuspiciousString);
    }

    @Override
    public void showMenusSearchNotInfected() {
        String showMenusSearchNotInfectedString =
            """
            ==========================================================================================================================
                           Options: 1 - Search all not infected | 2 - Search not infected by nationality | 0 - Quit                   
            ==========================================================================================================================""";
        System.out.println(showMenusSearchNotInfectedString);
    }

    public void showMenuSearchByBloodTypeOpt() {
        String showMenuSearchByBloodTypeOptString =
            """
            ==========================================================================================================================
                           Options: 1 - Search by blood type | 2 - Search by blood type and nationality | 0 - Quit                    
            ==========================================================================================================================""";
        System.out.println(showMenuSearchByBloodTypeOptString);
    }

    public void showMenuSearchByBloodType() {
        String showMenuSearchByBloodTypeString =
            """
            ==========================================================================================================================
                                                             Insert Blood Type                                                        
            ==========================================================================================================================""";
        System.out.println(showMenuSearchByBloodTypeString);
    }

    public void showEmptyResult() {
        String showEmptyResultString =
            """
            ==========================================================================================================================
                                                                Empty Result                                                          
            ==========================================================================================================================""";
        System.out.println(showEmptyResultString);
    }

    @Override
    public void showError() {
        String showErrorString =
            """
            ==========================================================================================================================
                                                                    ERROR                                                             
            ==========================================================================================================================""";
        System.out.println(showErrorString);
    }

    @Override
    public void showErrorNumber() {
        String showErrorNumberString =
            """
            ==========================================================================================================================
                                                       ERROR - Insert a DNA ID valid                                                  
            ==========================================================================================================================""";
        System.out.println(showErrorNumberString);
    }

    @Override
    public void showInput() {
        String showInputString =
            """
            ==========================================================================================================================
                                                             Input a valid option                                                     
            ==========================================================================================================================""";
        System.out.println(showInputString);
    }

    @Override
    public void showException(String msg) {
        System.out.println(msg);
    }

    @Override
    public void showErrorCountry() {
        String showErrorCountryString =
                """
                ==========================================================================================================================
                                                                        ERROR                                                             
                                                               Insert a country code valid
                                                                    BRA for Brazil
                                                                    COM for Colombia
                                                                    CHN for China
                                                                    ITA for Italy
                                                                    TUN for Tunisia
                                                                    DEU for Germany
                                                                    FRA for France
                                                                    PRT for Portugal
                                                                    CA  for Canada
                                                                    AFG  for Afghanistan
                ==========================================================================================================================""";
        System.out.println(showErrorCountryString);
    }

    @Override
    public void showErrorBloodType() {
        String showErrorBloodTypeString =
                """
                ==========================================================================================================================
                                                                        ERROR                                                             
                                                               Insert a Blood code valid                                                  
                
                                                                     A+  for Blood   A+
                                                                     A-  for Blood   A-
                                                                     B+  for Blood   B+
                                                                     B-  for Blood   B-
                                                                     AB+ for Blood  AB+
                                                                     AB- for Blood  AB-
                                                                     O+  for Blood   O+
                                                                     O-  for Blood   O-
                ==========================================================================================================================""";
        System.out.println(showErrorBloodTypeString);
    }

}
