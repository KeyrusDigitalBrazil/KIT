package com.keyrus.kit.services;

import com.keyrus.kit.models.Patient;

import java.util.Set;

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
     * Generate section for search DNA
     */
    void searchDna(String doc);

    /**
     * Generate scanner for console
     *
     * @return String
     */
    String generateStringScanner();

    /**
     * Search patient by DOC
     *
     * @param doc
     */
    void searchByDoc(String doc);

    /**
     * Generate section for search infected
     *
     * @param id
     */
    void searchInfected(String id);

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

    /**
     * Generate section for search all patients
     */
    void searchAllPatients();

    /**
     * Validate to return result or empty
     *
     * @param object
     */
    void validEmptyResult(Object object);

    /**
     * Validate to return result list or empty
     *
     * @param patients
     */
    void validEmptyResultList(Set<Patient> patients);
}
