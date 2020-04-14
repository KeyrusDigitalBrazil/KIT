package com.keyrus.kit.jdbc;

import java.beans.PropertyVetoException;
import java.sql.SQLException;

public interface JdbcStrategy {

    void search() throws SQLException, PropertyVetoException;
}
