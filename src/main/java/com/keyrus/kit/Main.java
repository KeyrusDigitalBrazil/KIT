package com.keyrus.kit;

import com.keyrus.kit.services.SearchService;
import com.keyrus.kit.services.impl.DefaultSearchService;
import com.keyrus.kit.utils.DatabaseConnect;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        SearchService searchService = new DefaultSearchService();
        searchService.baseSearch();

        Connection connect = DatabaseConnect.getInstance();
        System.out.println("Connection is closed: " + connect.isClosed());
        connect.close();
    }

}
