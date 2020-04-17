package com.keyrus.kit.services;

import com.keyrus.kit.daos.PatientDao;
import com.keyrus.kit.models.Dna;
import com.keyrus.kit.models.Patient;
import com.keyrus.kit.repository.impl.PrincipalRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DefaultJdbcService implements JdbcService {

    private PatientDao patientDao = new PatientDao();
    private PrincipalRepository principalRepository;
    @Override
    public boolean save(Object object) {

//        if (object instanceof Patient patient) {
//            String query =
//                    """
//                        INSERT INTO patient (name,phoneNumber, bloodType, nationality, doc, age, dna)
//                        VALUES(?,?,?,?,?,?,?)
//                    """;
//        }
        return false;
    }

    @Override
    public Object select(Object object, Long id) {
        return principalRepository.select(id);
    }

    @Override
    public List<Object> selectAll(Object object) {
        if (object instanceof Patient) {
            return new ArrayList<>(patientDao.getAllPatients());
        }
        if (object instanceof Dna) {
            return new ArrayList<>();
        }
        return new ArrayList<>();
    }

    @Override
    public boolean delete(Object object) {
        if (object instanceof Patient patient) {
            return patientDao.removePatient(patient.getId());
        }
        if (object instanceof Dna dna) {
            return false;
        }
        return false;
    }

    @Override
    public boolean update(Object object) {
        return false;
    }
}
