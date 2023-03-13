package com.company.repository;

import com.company.db.DataBase;
import com.company.dto.Profile;
import com.company.enums.Role;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Repository
public class ProfileRepository {

    public Profile getProfileByPhone(String phone) {
        Connection connection = null;
        try {
            connection = DataBase.getConnection();
            Statement statement = connection.createStatement();
            String sql = String.format("Select  * from profile where phone= '%s' ;", phone);
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Profile profile = new Profile();
                profile.setId(resultSet.getInt("id"));
                profile.setName(resultSet.getString("name"));
                profile.setSurname(resultSet.getString("surname"));
                profile.setPhone(resultSet.getString("phone"));
                profile.setCreatedDate(resultSet.getTimestamp("created_date").toLocalDateTime());
                profile.setRole(Role.valueOf(resultSet.getString("role")));
                profile.setVisible(Boolean.valueOf(resultSet.getString("visible")));
                return profile;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        } finally {

            try {
                if (connection != null) {
                    connection.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
        return null;
    }
}
