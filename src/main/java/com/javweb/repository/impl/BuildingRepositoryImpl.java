package com.javweb.repository.impl;


import com.javweb.repository.BuildingRepository;
import com.javweb.repository.entity.BuildingEntity;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository {
    static final String DB_URL = "jdbc:mysql://localhost:3306/estatebasic";
    static final String USER = "root";
    static final String PASS = "root";

    @Override
    public List<BuildingEntity> findAll() {
        List<BuildingEntity> buildings = new ArrayList<>();
        String sql = "select * from building";
        try(Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                BuildingEntity buildingDTO = new BuildingEntity();
                buildingDTO.setName(resultSet.getString("name"));
                buildingDTO.setStreet(resultSet.getString("street"));
                buildingDTO.setWard(resultSet.getString("ward"));
                buildingDTO.setNumberOfBasement(resultSet.getInt("numberofbasement"));
                buildings.add(buildingDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection database failed!");
        }
        return buildings;
    }
}
