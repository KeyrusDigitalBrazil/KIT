package com.keyrus.kit.services;

public interface SearchService {

    /**
     * Generate base of menu search
     */
    void baseSearch();

    /**
     * Generate base menu
     */
    void generateInitialMenu();

    /**
     * Generate initial data
     */
    void generateData();

    /**
     * Generate section for search suspicious
     *
     * @param id
     */
    void searchSuspicious(String id);

    /**
     * Generate section for search not infected
     *
     * @param id
     */
    void searchNotInfected(String id);

    /**
     * Generate section for search by blood type
     *
     * @param id
     */
    void searchByBlood(String id);

}
