package com.keyrus.kit;

import com.keyrus.kit.models.Patient;
import com.keyrus.kit.services.DefaultJdbcService;
import com.keyrus.kit.services.JdbcService;
import com.keyrus.kit.services.SearchService;
import com.keyrus.kit.services.impl.DefaultSearchService;
import com.keyrus.kit.utils.DatabaseConnect;

public class Main {

    public static void main(String[] args) {
        SearchService searchService = new DefaultSearchService();
        searchService.baseSearch();

        try {
            DatabaseConnect jdbcConn = DatabaseConnect.getInstance();
            System.out.println("Mysql Connected? " + jdbcConn.checkConnection());
            jdbcConn.closeConnection();
            JdbcService jdbcService = new DefaultJdbcService();
            jdbcService.selectAll(new Patient()).forEach(System.out::println);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
