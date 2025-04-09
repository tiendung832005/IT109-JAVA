package Bai6.service;

import Bai6.dao.DepartmentDAO;
import Bai6.dao.EmployeeDAO;
import Bai6.model.Department;
import Bai6.model.Employee;


import java.sql.*;
import java.util.List;

public class TransactionService {
    public static boolean addDepartmentAndEmployees(Connection conn, Department department, List<Employee> employees) {
        boolean autoCommit = false;

        try {

            autoCommit = conn.getAutoCommit();

            conn.setAutoCommit(false);

            DepartmentDAO.addDepartment(conn, department);

            for (Employee employee : employees) {
                EmployeeDAO.addEmployee(conn, employee);
            }

            conn.commit();
            return true;

        } catch (SQLException e) {
            try {
                System.err.println("Đã xảy ra lỗi trong giao dịch. Rollback: " + e.getMessage());
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return false;

        } finally {
            try {
                conn.setAutoCommit(autoCommit);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
