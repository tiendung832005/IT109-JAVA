package Bai8.dao;

import Bai7.util.DatabaseUtil;
import Bai8.model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

    public void createCustomersTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS customers (" +
                "customer_id INT PRIMARY KEY, " +
                "name VARCHAR(100) NOT NULL, " +
                "phone VARCHAR(15) NOT NULL)";

        try (Connection connection = DatabaseUtil.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            System.out.println("Bảng 'customers' đã được tạo hoặc đã tồn tại.");
        }
    }

    public void addCustomer(Customer customer) throws SQLException {
        String sql = "INSERT INTO customers (customer_id, name, phone) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, customer.getCustomerId());
            pstmt.setString(2, customer.getName());
            pstmt.setString(3, customer.getPhone());

            pstmt.executeUpdate();
        }
    }

    public Customer getCustomerById(Connection connection, int customerId) throws SQLException {
        String sql = "SELECT * FROM customers WHERE customer_id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, customerId);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Customer customer = new Customer();
                    customer.setCustomerId(rs.getInt("customer_id"));
                    customer.setName(rs.getString("name"));
                    customer.setPhone(rs.getString("phone"));
                    return customer;
                }
            }
        }

        return null;
    }

    public List<Customer> getAllCustomers() throws SQLException {
        String sql = "SELECT * FROM customers";
        List<Customer> customers = new ArrayList<>();

        try (Connection connection = DatabaseUtil.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {

            while (rs.next()) {
                Customer customer = new Customer();
                customer.setCustomerId(rs.getInt("customer_id"));
                customer.setName(rs.getString("name"));
                customer.setPhone(rs.getString("phone"));

                customers.add(customer);
            }
        }

        return customers;
    }
}
