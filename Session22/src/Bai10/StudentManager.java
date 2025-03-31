package Bai10;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentManager {
    private List<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Đã thêm sinh viên: " + student.getName());
    }

    public void saveToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(students);
            System.out.println("Đã lưu danh sách sinh viên vào file: " + filename);
        } catch (IOException e) {
            System.out.println("Lỗi khi lưu file: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void loadFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            students = (List<Student>) ois.readObject();
            System.out.println("Đã đọc danh sách sinh viên từ file: " + filename);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }

    public Student findTopStudent() {
        if (students.isEmpty()) {
            return null;
        }

        Student topStudent = students.get(0);
        for (Student student : students) {
            if (student.getGpa() > topStudent.getGpa()) {
                topStudent = student;
            }
        }
        return topStudent;
    }

    public List<Student> searchByMajor(String major) {
        return students.stream()
                .filter(student -> student.getMajor().equalsIgnoreCase(major))
                .collect(Collectors.toList());
    }

    public double calculateAverageGpa() {
        if (students.isEmpty()) {
            return 0.0;
        }

        double totalGpa = 0.0;
        for (Student student : students) {
            totalGpa += student.getGpa();
        }
        return totalGpa / students.size();
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("Danh sách sinh viên trống");
            return;
        }

        System.out.println("Danh sách tất cả sinh viên:");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void displayStudentsByMajor(String major) {
        List<Student> result = searchByMajor(major);

        if (result.isEmpty()) {
            System.out.println("Không có sinh viên nào thuộc chuyên ngành: " + major);
            return;
        }

        System.out.println("Danh sách sinh viên chuyên ngành " + major + ":");
        for (Student student : result) {
            System.out.println(student);
        }
    }
}