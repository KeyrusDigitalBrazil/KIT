package com.keyrus.kit.daos;

import com.keyrus.kit.exceptions.JDBCDnaException;
import com.keyrus.kit.models.Dna;
import com.keyrus.kit.models.DnaBuilder;
import com.keyrus.kit.utils.DatabaseConnect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DnaDao {

    @Autowired
    private DatabaseConnect databaseConnect;

    public List<Dna> getAllDna() {
        try {
            String query = "SELECT * FROM dna";

            Connection conn = databaseConnect.getConnection();

            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Dna> dnaList = new ArrayList<>();

            while (resultSet.next()) {
                dnaList.add(buildDna(resultSet));
            }

            return dnaList;
        } catch (Exception e) {
            throw new JDBCDnaException(e.getMessage());
        }
    }

    public Dna getDna(Long id) {
        try {
            String query = "SELECT * FROM dna WHERE idDna = " + id;

            Connection conn = databaseConnect.getConnection();

            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();

            return buildDna(resultSet);
        } catch (Exception e) {
            throw new JDBCDnaException(e.getMessage());
        }
    }

    private Dna buildDna(ResultSet resultSet) throws SQLException {
        return new DnaBuilder()
                .setId(resultSet.getLong("idDna"))
                .setDna(resultSet.getString("dna"))
                .build();
    }

}
