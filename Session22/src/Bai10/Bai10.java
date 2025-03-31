package Bai10;

import java.util.List;
import java.util.Scanner;

public class Bai10 {
    private static StudentManager studentManager = new StudentManager();
    private static Scanner scanner = new Scanner(System.in);
    private static final String FILE_NAME = "students.dat";

    public static void main(String[] args) {
        int choice;

        do {
            displayMenu();
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    studentManager.saveToFile(FILE_NAME);
                    break;
                case 3:
                    studentManager.loadFromFile(FILE_NAME);
                    break;
                case 4:
                    findTopStudent();
                    break;
                case 5:
                    searchByMajor();
                    break;
                case 6:
                    calculateAverageGpa();
                    break;
                case 7:
                    studentManager.displayAllStudents();
                    break;
                case 0:
                    System.out.println("Thoát chuongw trình");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }

            System.out.println();
        } while (choice != 0);

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("===== QUẢN LÝ SINH VIÊN =====");
        System.out.println("1. Thêm sinh viên mới");
        System.out.println("2. Lưu danh sách vào file");
        System.out.println("3. Đọc danh sách từ file");
        System.out.println("4. Tìm sinh viên có GPA cao nhất");
        System.out.println("5. Tìm sinh viên theo chuyên ngành");
        System.out.println("6. Tính điểm trung bình GPA");
        System.out.println("7. Hiển thị tất cả sinh viên");
        System.out.println("0. Thoát");
    }

    private static void addStudent() {
        System.out.println("Nhập thông tin sinh viên mới:");

        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Tên: ");
        String name = scanner.nextLine();

        System.out.print("Chuyên ngành: ");
        String major = scanner.nextLine();

        System.out.print("GPA: ");
        double gpa = scanner.nextDouble();

        Student student = new Student(id, name, major, gpa);
        studentManager.addStudent(student);
    }

    private static void findTopStudent() {
        Student topStudent = studentManager.findTopStudent();

        if (topStudent != null) {
            System.out.println("Sinh viên có GPA cao nhất là:");
            System.out.println(topStudent);
        } else {
            System.out.println("Danh sách sinh viên trống!");
        }
    }

    private static void searchByMajor() {
        System.out.print("Nhập tên chuyên ngành cần tìm: ");
        String major = scanner.nextLine();

        studentManager.displayStudentsByMajor(major);
    }

    private static void calculateAverageGpa() {
        double averageGpa = studentManager.calculateAverageGpa();
        System.out.printf("Điểm trung bình GPA của toàn bộ sinh viên: %.2f\n", averageGpa);
    }
}
