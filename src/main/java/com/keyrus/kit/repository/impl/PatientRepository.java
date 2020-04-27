package com.keyrus.kit.repository.impl;

import com.keyrus.kit.exceptions.PersistenceException;
import com.keyrus.kit.models.Dna;
import com.keyrus.kit.models.Patient;
import com.keyrus.kit.models.PatientBuilder;
import com.keyrus.kit.models.enums.BloodType;
import com.keyrus.kit.models.enums.Nationality;
import com.keyrus.kit.models.enums.Risk;
import com.keyrus.kit.repository.KitRepository;
import com.keyrus.kit.utils.DatabaseConnect;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository(value = "patientRepository")
public class PatientRepository implements KitRepository<Patient> {

    @Resource(name = "DatabaseConnect")
    private DatabaseConnect databaseConnect;

    @Resource(name = "dnaRepository")
    private KitRepository dnaRepository;

    private static final String FIND_PATIENT =
            """
                    SELECT * FROM patient WHERE idPatient = ? 
                    """;

    private static final String FIND_ALL_PATIENT =
            """
                    SELECT * FROM patient 
                    """;

    private static final String INSERT_PATIENT =
            """
                    INSERT INTO patient (idPatient, name, phoneNumber, bloodType, nationality, doc, age, idDna, suspicious, confirmed, quarantine, risk)
                    VALUES (?,?,?,?,?,?,?,?,?,?,?,?)
                     """;

    private static final String UPDATE_PATIENT =
            """
                    UPDATE patient SET 
                    name = ?, 
                    phoneNumber = ?, 
                    bloodType = ?, 
                    nationality = ?, 
                    doc = ?, 
                    age = ?,
                    idDna = ?,  
                    suspicious = ?, 
                    confirmed = ?, 
                    quarantine = ?, 
                    risk = ?
                    WHERE idPatient = ?
                     """;

    private static final String DELETE_PATIENT =
            """
                    DELETE FROM patient WHERE idPatient = ?
                     """;

    @Override
    public boolean add(Patient object) {
        try {
            String query = INSERT_PATIENT;

            Connection conn = databaseConnect.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setLong(1, object.getId());
            preparedStatement.setString(2, object.getName());
            preparedStatement.setString(3, object.getPhoneNumber());
            preparedStatement.setString(4, object.getBloodType().toString());
            preparedStatement.setString(5, object.getNationality().toString());
            preparedStatement.setString(6, object.getDoc());
            preparedStatement.setInt(7, object.getAge());
            preparedStatement.setLong(8, object.getDna().getId());
            preparedStatement.setBoolean(9, object.getSuspicious());
            preparedStatement.setBoolean(10, object.getConfirmed());
            preparedStatement.setBoolean(11, object.getQuarantine());
            preparedStatement.setString(12, object.getRisk().toString());

            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            throw new PersistenceException("Error in add Patient: " + e.getMessage());
        }
    }

    @Override
    public boolean update(Patient object) {
        try {
            String query = UPDATE_PATIENT;

            Connection conn = databaseConnect.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, object.getName());
            preparedStatement.setString(2, object.getPhoneNumber());
            preparedStatement.setString(3, object.getBloodType().toString());
            preparedStatement.setString(4, object.getNationality().toString());
            preparedStatement.setString(5, object.getDoc());
            preparedStatement.setInt(6, object.getAge());
            preparedStatement.setLong(7, object.getDna().getId());
            preparedStatement.setBoolean(8, object.getSuspicious());
            preparedStatement.setBoolean(9, object.getConfirmed());
            preparedStatement.setBoolean(10, object.getQuarantine());
            preparedStatement.setString(11, object.getRisk().toString());
            preparedStatement.setLong(12, object.getId());

            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            throw new PersistenceException("Error in update Patient: " + e.getMessage());
        }
    }

    @Override
    public boolean remove(Long id) {
        try {
            String query = DELETE_PATIENT;

            Connection conn = databaseConnect.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setLong(1, id);
            return preparedStatement.execute();
        } catch (Exception e) {
            throw new PersistenceException("Error in remove Patient: " + id + "\n" + e.getMessage());
        }
    }

    @Override
    public Patient get(Long id) {
        try {
            String query = FIND_PATIENT;

            Connection conn = databaseConnect.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (!resultSet.next()) return null;

            return buildPatient(resultSet);
        } catch (Exception e) {
            throw new PersistenceException("Error in search Patient: " + id.toString() + "\n" + e.getMessage());
        }
    }

    @Override
    public List<Patient> getAll() {
        try {
            String query = FIND_ALL_PATIENT;

            Connection conn = databaseConnect.getConnection();

            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Patient> patientList = new ArrayList<>();

            while (resultSet.next()) {
                patientList.add(buildPatient(resultSet));
            }

            return patientList;
        } catch (Exception e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    private Patient buildPatient(ResultSet resultSet) throws SQLException {
        return new PatientBuilder()
                .setIdPatient(resultSet.getLong("idPatient"))
                .setName(resultSet.getString("name"))
                .setPhoneNumber(resultSet.getString("phoneNumber"))
                .setBloodType(BloodType.getBloodType(resultSet.getString("bloodType")))
                .setNationality(Nationality.getNationality(resultSet.getString("nationality")))
                .setDoc(resultSet.getString("doc"))
                .setAge(resultSet.getInt("age"))
                .setDna((Dna) dnaRepository.get(resultSet.getLong("idDna")))
                .setSuspicious(resultSet.getBoolean("suspicious"))
                .setConfirmed(resultSet.getBoolean("confirmed"))
                .setQuarantine(resultSet.getBoolean("quarantine"))
                .setRisk(Risk.valueOf(resultSet.getString("risk")))
                .build();
    }

}
