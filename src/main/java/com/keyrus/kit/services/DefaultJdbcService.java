package com.keyrus.kit.services;

import com.keyrus.kit.daos.PatientDao;
import com.keyrus.kit.models.Dna;
import com.keyrus.kit.models.Patient;

import java.util.ArrayList;
import java.util.List;

public class DefaultJdbcService implements JdbcService {

    private PatientDao patientDao = new PatientDao();

    @Override
    public boolean save(Object object) {

        if (object instanceof Patient patient) {

            String query =
                    """
                            INSERT INTO patient (name,phoneNumber, bloodType, nationality, doc, age, dna) 
                            VALUES(?,?,?,?,?,?,?)
                            """;

        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public Object select(Object object, Long id) {
        if (object instanceof Patient patient) {
            return patientDao.getPatient(id);
        }
        if (object instanceof Dna dna) {
            return new ArrayList<>();
        }
        return new ArrayList<>();
    }

    @Override
    public List<Object> selectAll(Object object) {
        if (object instanceof Patient patient) {
            return new ArrayList<>(patientDao.getAllPatients());
        }
        if (object instanceof Dna dna) {
            return new ArrayList<>();
        }
        return new ArrayList<>();
    }

    @Override
    public boolean update(Object object) {
        return false;
    }
}
