package com.keyrus.kit.utils;

import com.keyrus.kit.utils.impl.DefaultSystemUtils;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.stereotype.Service;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

@Service("DatabaseConnect")
public class DatabaseConnect {

    private static DatabaseConnect jdbc;
    private SystemUtils systemUtils = new DefaultSystemUtils();
    private static ComboPooledDataSource dataSource;

    private static Connection con;

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
         if(con == null) {
             dataSource = new ComboPooledDataSource();
             dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
             dataSource.setJdbcUrl(this.getUrlConnection());
             dataSource.setMinPoolSize(Integer.parseInt(systemUtils.getPropertiesValue("c3p0.min.pool.size")));
             dataSource.setMaxPoolSize(Integer.parseInt(systemUtils.getPropertiesValue("c3p0.max.pool.size")));
             dataSource.setAcquireIncrement(Integer.parseInt(systemUtils.getPropertiesValue("c3p0.acquire.increment")));

             con = dataSource.getConnection();
         }
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
