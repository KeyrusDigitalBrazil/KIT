package com.keyrus.kit.jdbc;

import java.sql.SQLException;

public interface JdbcStrategy {

    void search() throws SQLException, ClassNotFoundException;
}
