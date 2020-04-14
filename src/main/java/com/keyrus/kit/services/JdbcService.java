package com.keyrus.kit.services;

import java.util.List;

public interface JdbcService {

    boolean save(Object object);

    boolean delete(String id);

    Object select(Object object, Long id);

    List<Object> selectAll(Object object);

    boolean update(Object object);
}
