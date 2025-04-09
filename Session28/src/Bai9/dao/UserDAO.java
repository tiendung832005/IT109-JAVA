package Bai9.dao;


import Bai9.model.User;

import java.sql.*;

public class UserDAO {

    public User getUserById(Connection connection, int userId) throws SQLException {
        String sql = "SELECT * FROM users WHERE user_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new User(
                        resultSet.getInt("user_id"),
                        resultSet.getString("username"),
                        resultSet.getDouble("balance")
                );
            }
            return null;
        }
    }

    public boolean checkUserBalance(Connection connection, int userId, double requiredAmount) throws SQLException {
        String sql = "SELECT balance FROM users WHERE user_id = ? FOR UPDATE";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                double balance = resultSet.getDouble("balance");
                return balance >= requiredAmount;
            }
            return false;
        }
    }
}

