package Bai4;

import java.io.*;

public class Bai4 {
    public static void main(String[] args) {
        Student student = new Student("Nguyễn Văn A", 20, 8.5);

        try {
            writeToFile(student, "student.dat");

            Student readStudent = readFromFile("student.dat");

            System.out.println("Thông tin của đối tượng đã đọc:");
            System.out.println(readStudent);

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Lỗi: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void writeToFile(Student student, String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(student);
            System.out.println("Đã ghi đối tượng vào file " + fileName);
        }
    }

    private static Student readFromFile(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            Student student = (Student) ois.readObject();
            System.out.println("Đã đọc đối tượng từ file " + fileName);
            return student;
        }
    }
}
