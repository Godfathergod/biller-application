package com.example.biller_application.dao;

import com.example.biller_application.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.mysql.cj.jdbc.Driver;

public class UserDao {

    private final String tableName = "users";

    public boolean registerUser(User user) throws SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        DriverManager.registerDriver(new Driver());
        try(Connection connection = DriverManager.getConnection(Database.INSTANCE.getURL(),
                Database.INSTANCE.getUSER(), Database.INSTANCE.getPASSWORD())) {
            String INSERT_INTO_TABLE = "INSERT INTO " + tableName +
                    " (username, password, email) VALUES " +
                    " (?, ?, ?);";
            PreparedStatement statement = connection.prepareStatement(INSERT_INTO_TABLE);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            System.out.println(statement);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
