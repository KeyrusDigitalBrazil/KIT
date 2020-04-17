package com.keyrus.kit;

import com.keyrus.kit.services.SearchService;
import com.keyrus.kit.services.impl.DefaultSearchService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KITApplication {

    public static void main(String[] args) {
        SpringApplication.run(KITApplication.class, args);
        SearchService searchService = new DefaultSearchService();
        searchService.baseSearch();
    }

}
