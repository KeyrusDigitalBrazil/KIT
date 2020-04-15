package com.keyrus.kit.daos;

import com.keyrus.kit.exceptions.PersistenceException;
import com.keyrus.kit.exceptions.SelectPatientException;
import com.keyrus.kit.models.Dna;
import com.keyrus.kit.models.Patient;
import com.keyrus.kit.models.PatientBuilder;
import com.keyrus.kit.models.enums.BloodType;
import com.keyrus.kit.models.enums.Nationality;
import com.keyrus.kit.models.enums.Risk;
import com.keyrus.kit.utils.DatabaseConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PatientDao {

    private DatabaseConnect databaseConnect;

    public List<Patient> getAllPatients() {
        try {
            String query = "SELECT * FROM patient";

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

    public Patient getPatient(Long id) {
        try {
            String query = "SELECT * FROM patient WHERE id = " + id;

            Connection conn = databaseConnect.getConnection();

            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();
            return buildPatient(resultSet);
        } catch (Exception e) {
            throw new PersistenceException("Error in search Patitent: " + id.toString() + "\n" + e.getMessage());
        }
    }

    public Boolean removePatient(Long id){
        try{
            String query =
                    """
                    DELETE FROM patient WHERE idPatient =?
                    """;
            Connection conn = databaseConnect.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setLong(1,id);
            return preparedStatement.execute();
        }catch (Exception e){
            throw new PersistenceException("Error in remove Patient: " + id.toString() + "\n" + e.getMessage());
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
                .setDna(new Dna())
                .setSuspicious(resultSet.getBoolean("suspicious"))
                .setConfirmed(resultSet.getBoolean("confirmed"))
                .setQuarantine(resultSet.getBoolean("quarantine"))
                .setRisk(Risk.valueOf(resultSet.getString("risk")))
                .build();
    }

}
