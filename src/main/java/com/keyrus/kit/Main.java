package com.keyrus.kit;

import com.keyrus.kit.services.SearchService;
import com.keyrus.kit.services.impl.DefaultSearchService;

public class Main {

    public static void main(String[] args) {
        SearchService searchService = new DefaultSearchService();
        searchService.baseSearch();
    }
}
