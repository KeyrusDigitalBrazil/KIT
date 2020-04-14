package com.keyrus.kit.jdbc.impl;

import com.keyrus.kit.jdbc.JdbcStrategy;
import com.keyrus.kit.utils.DatabaseConnect;

import java.beans.PropertyVetoException;
import java.sql.SQLException;

public class PatientJdbc implements JdbcStrategy {

    @Override
    public void search() throws SQLException, PropertyVetoException {
        DatabaseConnect jdbcConn = DatabaseConnect.getInstance();
        System.out.println("Mysql Connected? " + jdbcConn.checkConnection());
        jdbcConn.closeConnection();
    }
}
