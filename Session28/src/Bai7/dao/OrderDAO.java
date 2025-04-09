package Bai7.dao;

import Bai7.model.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {

    public void createOrdersTable(Connection connection) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS orders (" +
                "order_id INT PRIMARY KEY, " +
                "customer_name VARCHAR(100), " +
                "status VARCHAR(50))";

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            System.out.println("Table 'orders' created or already exists");
        }
    }

    public void dropOrdersTable(Connection connection) throws SQLException {
        String sql = "DROP TABLE IF EXISTS orders";

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            System.out.println("Table 'orders' dropped if it existed");
        }
    }

    public void clearOrdersTable(Connection connection) throws SQLException {
        String sql = "DELETE FROM orders";

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            System.out.println("Table 'orders' cleared");
        }
    }

    public void insertOrder(Connection connection, Order order) throws SQLException {
        String sql = "INSERT INTO orders (order_id, customer_name, status) VALUES (?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, order.getOrderId());
            pstmt.setString(2, order.getCustomerName());
            pstmt.setString(3, order.getStatus());

            pstmt.executeUpdate();
            System.out.println("Inserted order: " + order + " (not committed yet)");
        }
    }

    public void updateOrderStatus(Connection connection, int orderId, String newStatus) throws SQLException {
        String sql = "UPDATE orders SET status = ? WHERE order_id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, newStatus);
            pstmt.setInt(2, orderId);

            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Updated " + rowsAffected + " order(s) with ID " + orderId + " to status '" + newStatus + "' (not committed yet)");
        }
    }

    public List<Order> getAllOrders(Connection connection) throws SQLException {
        String sql = "SELECT * FROM orders";
        List<Order> orders = new ArrayList<>();

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                Order order = new Order();
                order.setOrderId(resultSet.getInt("order_id"));
                order.setCustomerName(resultSet.getString("customer_name"));
                order.setStatus(resultSet.getString("status"));

                orders.add(order);
            }
        }

        return orders;
    }
}

