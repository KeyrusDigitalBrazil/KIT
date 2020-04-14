package com.keyrus.kit.context;

import com.keyrus.kit.jdbc.JdbcStrategy;
import com.keyrus.kit.search.SearchStrategy;

import java.beans.PropertyVetoException;
import java.sql.SQLException;

public class Context {

    public Context(SearchStrategy searchStrategy) {
        searchStrategy.search();
    }

    public Context(JdbcStrategy jdbcStrategy) throws SQLException, PropertyVetoException {
        jdbcStrategy.search();
    }

}
