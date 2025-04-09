package Bai6.dao;

import Bai6.model.Department;
import java.sql.*;

public class DepartmentDAO {

    public static void addDepartment(Connection conn, Department department) throws SQLException {
        String sql = "INSERT INTO departments (id, name) VALUES (?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, department.getId());
            pstmt.setString(2, department.getName());
            pstmt.executeUpdate();
            System.out.println("Đã thêm phòng ban: " + department.getName());
        }
    }
}
