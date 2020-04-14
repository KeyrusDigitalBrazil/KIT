package com.keyrus.kit.context;

import com.keyrus.kit.jdbc.JdbcStrategy;
import com.keyrus.kit.search.SearchStrategy;
import com.keyrus.kit.services.JdbcService;

import java.sql.SQLException;

public class Context {

    public Context(SearchStrategy searchStrategy) {
        searchStrategy.search();
    }

    public Context(JdbcStrategy jdbcStrategy) throws SQLException, ClassNotFoundException {jdbcStrategy.search();}

}
