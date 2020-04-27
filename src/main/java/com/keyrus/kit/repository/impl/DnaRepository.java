package com.keyrus.kit.repository.impl;

import com.keyrus.kit.exceptions.PersistenceException;
import com.keyrus.kit.models.Dna;
import com.keyrus.kit.models.DnaBuilder;
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

@Repository(value = "dnaRepository")
public class DnaRepository implements KitRepository<Dna> {

    @Resource
    private DatabaseConnect databaseConnect;

    private static final String FIND_DNA =
            """
                    SELECT * FROM dna WHERE idDna = ? 
                    """;

    private static final String FIND_ALL_DNA =
            """
                    SELECT * FROM dna 
                    """;

    private static final String INSERT_DNA =
            """
                    INSERT INTO dna (idDna, dna)
                    VALUES (?,?)
                     """;

    private static final String UPDATE_DNA =
            """
                    UPDATE dna SET 
                    dna = ?              
                    WHERE idDna = ?
                     """;


    private static final String DELETE_DNA =
            """
                    DELETE FROM dna WHERE idDna = ?
                     """;

    @Override
    public boolean add(Dna object) {
        try {
            String query = INSERT_DNA;

            Connection conn = databaseConnect.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setLong(1, object.getId());
            preparedStatement.setString(2, object.getDna());

            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            throw new PersistenceException("Error in add Dna: " + e.getMessage());
        }
    }

    @Override
    public boolean update(Dna object) {
        try {
            String query = UPDATE_DNA;

            Connection conn = databaseConnect.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, object.getDna());
            preparedStatement.setLong(2, object.getId());

            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            throw new PersistenceException("Error in update Dna: " + e.getMessage());
        }
    }

    @Override
    public boolean remove(Long id) {
        try {
            String query = DELETE_DNA;

            Connection conn = databaseConnect.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setLong(1, id);
            return preparedStatement.execute();
        } catch (Exception e) {
            throw new PersistenceException("Error in remove Dna: " + id + "\n" + e.getMessage());
        }
    }

    @Override
    public Dna get(Long id) {
        try {
            String query = FIND_DNA;

            Connection conn = databaseConnect.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (!resultSet.next()) return null;

            return buildDna(resultSet);
        } catch (Exception e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public List<Dna> getAll() {
        try {
            String query = FIND_ALL_DNA;

            Connection conn = databaseConnect.getConnection();

            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();


            List<Dna> dnaList = new ArrayList<>();

            while (resultSet.next()) {
                dnaList.add(buildDna(resultSet));
            }

            return dnaList;
        } catch (Exception e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    private Dna buildDna(ResultSet resultSet) throws SQLException {
        return new DnaBuilder()
                .setId(resultSet.getLong("idDna"))
                .setDna(resultSet.getString("dna"))
                .build();
    }

}
