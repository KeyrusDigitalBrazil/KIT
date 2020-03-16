package com.keyrus.kit.services;

public interface SearchService {

    void baseSearch();

    void generateInitialMenu();

    void generateData();

    void searchInfected(String id);

    void searchSuspicious(String id);

    void searchNotInfected(String id);
}
