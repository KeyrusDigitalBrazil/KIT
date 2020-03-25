package com.keyrus.kit.utils;

public interface MenuUtils {

    /**
     * Show menu principal
     */
    void showMenuPrincipal();

    /**
     * Show menu search by DOC
     */
    void showMenusSearchByDoc();

    /**
     * Show menu search DNA
     */
    void showMenusSearchByDnaOpt();

    /**
     * Show menu search by DNA
     */
    void showMenusSearchByDna();

    /**
     * Show menu search DNA by code
     */
    void showMenusSearchByDnaCode();

    /**
     * Show menu search infected
     */
    void showMenusSearchInfected();

    /**
     * Show menu search by nationality
     */
    void showMenusSearchByNationality();

    /**
     * Show menu search suspicious
     */
    void showMenusSearchSuspicious();

    /**
     * Show menu search not infected
     */
    void showMenusSearchNotInfected();

    /**
     * Show menu search by blood type
     */
    void showMenuSearchByBloodTypeOpt();

    /**
     * Show menu search blood type
     */
    void showMenuSearchByBloodType();

    /**
     * Show empty
     */
    void showEmptyResult();

    /**
     * Show error
     */
    void showError();

    /**
     * Show error for NumberFormatException
     */
    void showErrorNumber();

    /**
     * Show invalid option
     */
    void showInput();

    /**
     * Show Exception message
     */
    void showException(String msg);

    /**
     * Show Nationality Exception  message
     */
    void showErrorCountry();

    /**
     * Show BloodType Exception message
     */
    void showErrorBloodType();
}
