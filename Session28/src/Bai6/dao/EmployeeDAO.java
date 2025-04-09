package Bai6.dao;


import Bai6.model.Employee;
import java.sql.*;

public class EmployeeDAO {

    public static void addEmployee(Connection conn, Employee employee) throws SQLException {
        String sql = "INSERT INTO employees (id, name, department_id) VALUES (?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, employee.getId());
            pstmt.setString(2, employee.getName());
            pstmt.setInt(3, employee.getDepartmentId());
            pstmt.executeUpdate();
            System.out.println("Đã thêm nhân viên: " + employee.getName());
        }
    }
}