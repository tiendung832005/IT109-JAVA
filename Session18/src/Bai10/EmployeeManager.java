package Bai10;

import java.util.Scanner;

public class EmployeeManager {
    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    employeeService.addEmployee();
                    break;
                case 2:
                    employeeService.displayAllEmployees();
                    break;
                case 3:
                    employeeService.calculateTotalSalary();
                    break;
                case 4:
                    employeeService.calculateAverageSalary();
                    break;
                case 5:
                    employeeService.findHighestPaidEmployee();
                    break;
                case 6:
                    employeeService.findLowestPaidEmployee();
                    break;
                case 7:
                    System.out.println("Thoát chương trình.");
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n--- QUẢN LÝ NHÂN VIÊN ---");
        System.out.println("1. Thêm nhân viên mới");
        System.out.println("2. Hiển thị danh sách nhân viên");
        System.out.println("3. Tính tổng lương");
        System.out.println("4. Tính lương trung bình");
        System.out.println("5. Tìm nhân viên có lương cao nhất");
        System.out.println("6. Tìm nhân viên có lương thấp nhất");
        System.out.println("7. Thoát");
        System.out.print("Chọn chức năng: ");
    }
}
