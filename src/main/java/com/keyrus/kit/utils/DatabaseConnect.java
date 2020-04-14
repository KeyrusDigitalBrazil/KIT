package com.keyrus.kit.utils;

import com.keyrus.kit.utils.impl.DefaultSystemUtils;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnect {

    private static DatabaseConnect jdbc;
    private SystemUtils systemUtils = new DefaultSystemUtils();
    private static ComboPooledDataSource dataSource;

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

    public Connection getConnection() throws SQLException, PropertyVetoException {
        Connection con = null;

        dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl(this.getUrlConnection());
        dataSource.setMinPoolSize(3);
        dataSource.setMaxPoolSize(100);
        dataSource.setAcquireIncrement(5);

        con = dataSource.getConnection();

        return con;
    }

    public boolean checkConnection() throws SQLException, PropertyVetoException {
        Connection conn = null;
        conn = this.getConnection();
        return !conn.isClosed();
    }

    public void closeConnection() throws SQLException, PropertyVetoException {
        Connection conn = null;
        conn = this.getConnection();
        conn.close();
    }
}
