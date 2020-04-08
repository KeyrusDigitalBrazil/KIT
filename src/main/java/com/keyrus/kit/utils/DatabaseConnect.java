package com.keyrus.kit.utils;

import com.keyrus.kit.utils.impl.DefaultSystemUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnect {

    private static DatabaseConnect jdbc;
    private SystemUtils systemUtils = new DefaultSystemUtils();

    private DatabaseConnect() {
    }

    public static DatabaseConnect getInstance() {
        if (jdbc == null) {
            jdbc = new DatabaseConnect();
        }
        return jdbc;
    }

    private String getUrlConnection() {
        String url = systemUtils.getPropertiesValue("jdbc.url");
        String database = systemUtils.getPropertiesValue("jdbc.database");
        String user = systemUtils.getPropertiesValue("jdbc.user");
        String password = systemUtils.getPropertiesValue("jdbc.password");
        String port = systemUtils.getPropertiesValue("jdbc.port");

        return "jdbc:mysql://" + url + ":" + port + "/" + database + "?user=" + user + "&password=" + password;
    }

    private Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection con = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(this.getUrlConnection());
        return con;
    }

    public boolean checkConnection() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        conn = this.getConnection();
        return !conn.isClosed();
    }

    public void closeConnection() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        conn = this.getConnection();
        conn.close();
    }

//    public void select() throws SQLException, ClassNotFoundException {
//        Connection conn = null;
//        conn = this.getConnection();
//    }
//
//    public int insert() throws SQLException, ClassNotFoundException {
//
//    }
//
//    public int update() throws SQLException, ClassNotFoundException {
//
//    }
//
//    public int delete() throws SQLException, ClassNotFoundException {
//
//    }

}
