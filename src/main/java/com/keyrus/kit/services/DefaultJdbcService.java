package com.keyrus.kit.services;

import com.keyrus.kit.models.Patient;

public class DefaultJdbcService implements JdbcService{

    @Override
    public boolean save(Object object) {
        if(object instanceof Patient patient){

        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public Object select(Object object) {
        return null;
    }

    @Override
    public boolean update(Object object) {
        return false;
    }
}
