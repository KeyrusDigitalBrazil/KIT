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
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component(value = "appKitRepository")
public class AppKitRepository {

    @Resource(name = "DatabaseConnect")
    private DatabaseConnect databaseConnect;

    @Resource(name = "dnaRepository")
    private KitRepository dnaRepository;

    private static final String FIND_PATIENT_BY_DOC =
            """
                    SELECT * FROM patient WHERE doc = ? 
                    """;

    private static final String FIND_PATIENT_BY_DNA =
            """
                    SELECT p.* FROM patient as p JOIN dna as d ON p.idDna = d.idDna WHERE d.dna = ? 
                    """;

    private static final String FIND_PATIENT_INFECTED =
            """
                    SELECT * FROM patient WHERE confirmed = 1 
                    """;

    private static final String FIND_PATIENT_SUSPICIOUS =
            """
                    SELECT * FROM patient WHERE suspicious = 1 
                    """;

    private static final String FIND_PATIENT_BLOOD =
            """
                    SELECT * FROM patient WHERE bloodType = ? 
                    """;

    private static final String FIND_PATIENT_NOT_INFECTED =
            """
                    SELECT * FROM patient WHERE confirmed = 0 
                    """;
    private static final String FIND_PATIENT_BY_NATIONALITY =
                    """
                    SELECT * FROM patient WHERE nationality = ?
                    """;

    public List<Patient> getByNationality(String nationality) {
        try {
            String query = FIND_PATIENT_BY_NATIONALITY;

            Connection conn = databaseConnect.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, nationality);

            ResultSet resultSet = preparedStatement.executeQuery();
            List<Patient> patientList = new ArrayList<>();

            while (resultSet.next()) {
                patientList.add(buildPatient(resultSet));
            }

            return patientList;
        } catch (Exception e) {
            throw new PersistenceException("Error in search Patient: " + e.getMessage());
        }
    }


    public Patient getByDoc(String doc) {
        try {
            String query = FIND_PATIENT_BY_DOC;

            Connection conn = databaseConnect.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, doc);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(!resultSet.next()) return null;

            return buildPatient(resultSet);
        } catch (Exception e) {
            throw new PersistenceException("Error in search Patient: " + e.getMessage());
        }
    }

    public Patient getByDna(String dna) {
        try {
            String query = FIND_PATIENT_BY_DNA;

            Connection conn = databaseConnect.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, dna);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(!resultSet.next()) return null;

            return buildPatient(resultSet);
        } catch (Exception e) {
            throw new PersistenceException("Error in search Patient: " + e.getMessage());
        }
    }

    public List<Patient> getInfected(String nationality) {
        try {
            StringBuilder query = new StringBuilder(FIND_PATIENT_INFECTED);
            Connection conn = databaseConnect.getConnection();

            if(StringUtils.isNotEmpty(nationality)) query.append(" AND nationality = ?");
            PreparedStatement preparedStatement = conn.prepareStatement(query.toString());
            if(StringUtils.isNotEmpty(nationality)) preparedStatement.setString(1, nationality);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Patient> patientList = new ArrayList<>();

            while (resultSet.next()) {
                patientList.add(buildPatient(resultSet));
            }

            return patientList;
        } catch (Exception e) {
            throw new PersistenceException("Error in search Patient: " + e.getMessage());
        }
    }

    public List<Patient> getSuspicious(String nationality) {
        try {
            StringBuilder query = new StringBuilder(FIND_PATIENT_SUSPICIOUS);
            Connection conn = databaseConnect.getConnection();

            if(StringUtils.isNotEmpty(nationality)) query.append(" AND nationality = ?");
            PreparedStatement preparedStatement = conn.prepareStatement(query.toString());
            if(StringUtils.isNotEmpty(nationality)) preparedStatement.setString(1, nationality);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Patient> patientList = new ArrayList<>();

            while (resultSet.next()) {
                patientList.add(buildPatient(resultSet));
            }

            return patientList;
        } catch (Exception e) {
            throw new PersistenceException("Error in search Patient: " + e.getMessage());
        }
    }

    public List<Patient> getBloodType(String bloodType, String nationality) {
        try {
            StringBuilder query = new StringBuilder(FIND_PATIENT_BLOOD);
            Connection conn = databaseConnect.getConnection();

            if(StringUtils.isNotEmpty(nationality)) query.append(" AND nationality = ?");
            PreparedStatement preparedStatement = conn.prepareStatement(query.toString());
            preparedStatement.setString(1, bloodType);
            if(StringUtils.isNotEmpty(nationality)) preparedStatement.setString(2, nationality);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Patient> patientList = new ArrayList<>();

            while (resultSet.next()) {
                patientList.add(buildPatient(resultSet));
            }

            return patientList;
        } catch (Exception e) {
            throw new PersistenceException("Error in search Patient: " + e.getMessage());
        }
    }

    public List<Patient> getNotInfected(String nationality) {
        try {
            StringBuilder query = new StringBuilder(FIND_PATIENT_NOT_INFECTED);
            Connection conn = databaseConnect.getConnection();

            if(StringUtils.isNotEmpty(nationality)) query.append(" AND nationality = ?");
            PreparedStatement preparedStatement = conn.prepareStatement(query.toString());
            if(StringUtils.isNotEmpty(nationality)) preparedStatement.setString(1, nationality);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Patient> patientList = new ArrayList<>();

            while (resultSet.next()) {
                patientList.add(buildPatient(resultSet));
            }

            return patientList;
        } catch (Exception e) {
            throw new PersistenceException("Error in search Patient: " + e.getMessage());
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
