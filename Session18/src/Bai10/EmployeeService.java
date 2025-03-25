package Bai10;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EmployeeService {
    private Map<Integer, Employee> employeeMap;
    private Scanner scanner;

    public EmployeeService() {
        this.employeeMap = new HashMap<>();
        this.scanner = new Scanner(System.in);
    }

    public void addEmployee() {
        while (true) {
            try {
                System.out.print("Nhập tên nhân viên: ");
                String name = scanner.nextLine();

                System.out.print("Nhập lương nhân viên: ");
                double salary = scanner.nextDouble();
                scanner.nextLine(); // Consume newline

                if (salary < 0) {
                    System.out.println("Lương không được âm");
                    continue;
                }

                Employee employee = new Employee(name, salary);
                employeeMap.put(employee.getId(), employee);
                System.out.println("Thêm nhân viên thành công!");
                break;
            } catch (Exception e) {
                System.out.println("Dữ liệu không hợp lệ");
                scanner.nextLine();
            }
        }
    }

    public void displayAllEmployees() {
        if (employeeMap.isEmpty()) {
            System.out.println("Không có nhân viên nào trong danh sách.");
            return;
        }

        System.out.println("DANH SÁCH NHÂN VIÊN:");
        for (Employee employee : employeeMap.values()) {
            System.out.println(employee);
        }
    }

    public void calculateTotalSalary() {
        if (employeeMap.isEmpty()) {
            System.out.println("Không có nhân viên để tính lương.");
            return;
        }

        double totalSalary = 0;
        for (Employee employee : employeeMap.values()) {
            totalSalary += employee.getSalary();
        }

        System.out.printf("Tổng lương của tất cả nhân viên: %.2f VND%n", totalSalary);
    }

    public void calculateAverageSalary() {
        if (employeeMap.isEmpty()) {
            System.out.println("Không có nhân viên để tính lương trung bình.");
            return;
        }

        double totalSalary = 0;
        for (Employee employee : employeeMap.values()) {
            totalSalary += employee.getSalary();
        }

        double averageSalary = totalSalary / employeeMap.size();

        System.out.printf("Lương trung bình của nhân viên: %.2f VND%n", averageSalary);
    }

    public void findHighestPaidEmployee() {
        if (employeeMap.isEmpty()) {
            System.out.println("Không có nhân viên để tìm.");
            return;
        }

        double maxSalary = Double.MIN_VALUE;
        Employee highestPaidEmployee = null;

        for (Employee employee : employeeMap.values()) {
            if (employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
                highestPaidEmployee = employee;
            }
        }

        if (highestPaidEmployee != null) {
            System.out.println("Nhân viên có lương cao nhất:");
            System.out.println(highestPaidEmployee);
        }
    }

    public void findLowestPaidEmployee() {
        if (employeeMap.isEmpty()) {
            System.out.println("Không có nhân viên để tìm.");
            return;
        }

        double minSalary = Double.MAX_VALUE;
        Employee lowestPaidEmployee = null;

        for (Employee employee : employeeMap.values()) {
            if (employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
                lowestPaidEmployee = employee;
            }
        }

        if (lowestPaidEmployee != null) {
            System.out.println("Nhân viên có lương thấp nhất:");
            System.out.println(lowestPaidEmployee);
        }
    }
}
