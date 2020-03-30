package com.keyrus.kit.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnect {

    private static Connection con;

    public static Connection getInstance() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost/kit",
                    "root", "root");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }

}
