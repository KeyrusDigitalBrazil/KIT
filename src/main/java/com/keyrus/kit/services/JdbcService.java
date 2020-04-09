package com.keyrus.kit.services;

public interface JdbcService {

    boolean save(Object object);

    boolean delete(String id);

    Object select(Object object);

    boolean update(Object object);
}
