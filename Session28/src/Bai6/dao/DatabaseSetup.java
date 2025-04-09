package Bai6.dao;

import java.sql.*;

public class DatabaseSetup {
    public static void createTables(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();

        stmt.executeUpdate("DROP TABLE IF EXISTS employees");
        stmt.executeUpdate("DROP TABLE IF EXISTS departments");

        String createDepartmentTable = "CREATE TABLE departments (" +
                "id INT PRIMARY KEY," +
                "name VARCHAR(255) NOT NULL)";
        stmt.executeUpdate(createDepartmentTable);

        String createEmployeeTable = "CREATE TABLE employees (" +
                "id INT PRIMARY KEY," +
                "name VARCHAR(255) NOT NULL," +
                "department_id INT," +
                "FOREIGN KEY (department_id) REFERENCES departments(id))";
        stmt.executeUpdate(createEmployeeTable);

        System.out.println("Đã tạo bảng departments và employees thành công.");
    }
}
