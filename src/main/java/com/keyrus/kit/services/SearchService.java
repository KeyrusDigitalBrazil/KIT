package com.keyrus.kit.services;

import com.keyrus.kit.models.Patient;

import java.util.List;

public interface SearchService {

    void baseSearch();

    void generateInitialMenu();

    void generateData();

    void searchInfected(String id);

    void searchSuspicious(String id);

    void searchNotInfected(String id);

    void searchByBlood(String id);

    void validEmptyResult(Object object);

    void validEmptyResultList(List<Patient> patients);
}
