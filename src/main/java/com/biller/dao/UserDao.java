package com.biller.dao;

import com.biller.model.User;

import java.sql.*;
import java.util.Collection;

import com.mysql.cj.jdbc.Driver;

public class UserDao {

    private final String tableName = "users";

    public boolean registerUser(User user) throws SQLException {
        String INSERT_INTO_TABLE = "INSERT INTO " + tableName +
                " (username, password, email) VALUES " +
                " (?, ?, ?);";
        Connection connection = getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT_INTO_TABLE);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            System.out.println(statement);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public int getUserID(String username) throws SQLException {
        String SELECT_FROM_TABLE = "SELECT user_id FROM " + tableName +
                " WHERE username = ?";
        Connection connection = getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_FROM_TABLE);
            statement.setString(1,username);
            ResultSet result = statement.executeQuery();
            int userID = -1;
            if (result.next()){
                 userID = result.getInt("user_id");
            }
            result.close();
            statement.close();
            connection.close();

            System.out.println(statement + username);
            return userID;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    private Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        DriverManager.registerDriver(new Driver());
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(Database.INSTANCE.getURL(),
                    Database.INSTANCE.getUSER(), Database.INSTANCE.getPASSWORD());
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection Error");
        }
        return connection;
    }
}
