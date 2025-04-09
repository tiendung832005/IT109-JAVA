package Bai6;

import Bai6.dao.DatabaseSetup;
import Bai6.model.Department;
import Bai6.model.Employee;
import Bai6.service.TransactionService;
import Bai6.util.DatabaseConfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Bai6 {
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(
                DatabaseConfig.DB_URL,
                DatabaseConfig.USER,
                DatabaseConfig.PASS)) {

            DatabaseSetup.createTables(conn);

            Department newDepartment = new Department(1, "Engineering");

            List<Employee> employees = new ArrayList<>();
            employees.add(new Employee(1, "John Doe", newDepartment.getId()));
            employees.add(new Employee(2, "Jane Smith", newDepartment.getId()));
            employees.add(new Employee(3, "Alex Johnson", newDepartment.getId()));

            boolean success = TransactionService.addDepartmentAndEmployees(conn, newDepartment, employees);

            if (success) {
                System.out.println("Giao dịch thành công: Đã thêm phòng ban và nhân viên.");
            } else {
                System.out.println("Giao dịch thất bại.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
