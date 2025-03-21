import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private String id;
    private String name;
    private double gpa;

    public Student(String id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getClassification() {
        if (gpa >= 8.5) {
            return "Xuất sắc";
        } else if (gpa >= 7.0) {
            return "Giỏi";
        } else if (gpa >= 5.5) {
            return "Khá";
        } else {
            return "Trung bình/Yếu";
        }
    }

    @Override
    public String toString() {
        return String.format("%-10s | %-25s | %-5.2f | %-15s",
                id, name, gpa, getClassification());
    }
}

class QuanLySinhVien {
    private static List<Student> danhSachSinhVien = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        inputStudent();

        do {
            displayMenu();
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    displayStudent();
                    break;
                case 2:
                    searchStudent();
                    break;
                case 3:
                    phanLoaiSinhVien();
                    break;
                case 0:
                    System.out.println("Thoát chương trình");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n===== QUẢN LÝ SINH VIÊN =====");
        System.out.println("1. In danh sách sinh viên");
        System.out.println("2. Tìm kiếm sinh viên theo tên");
        System.out.println("3. Phân loại sinh viên theo GPA");
        System.out.println("0. Thoát");
    }

    private static void inputStudent() {
        System.out.println("Nhập thông tin sinh viên (ít nhất 5 sinh viên):");

        for (int i = 1; i <= 5; i++) {
            System.out.println("\nNhập thông tin sinh viên thứ " + i + ":");

            System.out.print("Mã sinh viên: ");
            String id = scanner.nextLine();

            System.out.print("Họ và tên: ");
            String name = scanner.nextLine();

            System.out.print("Điểm trung bình (GPA): ");
            double gpa = scanner.nextDouble();
            scanner.nextLine();

            Student sinhVien = new Student(id, name, gpa);
            danhSachSinhVien.add(sinhVien);
        }

        System.out.println("\nĐã nhập thành công thông tin của 5 sinh viên");
    }

    private static void displayStudent() {
        if (danhSachSinhVien.isEmpty()) {
            System.out.println("Danh sách sinh viên trống");
            return;
        }

        System.out.println("\n=== DANH SÁCH SINH VIÊN ===");
        System.out.println(String.format("%-10s | %-25s | %-5s | %-15s",
                "Mã SV", "Họ và tên", "GPA", "Xếp loại"));
        System.out.println("--------------------------------------------------------");

        for (Student sv : danhSachSinhVien) {
            System.out.println(sv);
        }
    }

    private static void searchStudent() {
        System.out.print("Nhập tên sinh viên cần tìm: ");
        String tenCanTim = scanner.nextLine().toLowerCase();

        List<Student> ketQuaTimKiem = new ArrayList<>();

        for (Student sv : danhSachSinhVien) {
            if (sv.getName().toLowerCase().contains(tenCanTim)) {
                ketQuaTimKiem.add(sv);
            }
        }

        if (ketQuaTimKiem.isEmpty()) {
            System.out.println("Không tìm thấy sinh viên nào có tên chứa '" + tenCanTim + "'");
        } else {
            System.out.println("\n=== KẾT QUẢ TÌM KIẾM ===");
            System.out.println(String.format("%-10s | %-25s | %-5s | %-15s",
                    "Mã SV", "Họ và tên", "GPA", "Xếp loại"));
            System.out.println("--------------------------------------------------------");

            for (Student sv : ketQuaTimKiem) {
                System.out.println(sv);
            }
        }
    }

    private static void phanLoaiSinhVien() {
        List<Student> xuatSac = new ArrayList<>();
        List<Student> gioi = new ArrayList<>();
        List<Student> kha = new ArrayList<>();
        List<Student> trungBinh = new ArrayList<>();

        for (Student sv : danhSachSinhVien) {
            double gpa = sv.getGpa();

            if (gpa >= 8.5) {
                xuatSac.add(sv);
            } else if (gpa >= 7.0) {
                gioi.add(sv);
            } else if (gpa >= 5.5) {
                kha.add(sv);
            } else {
                trungBinh.add(sv);
            }
        }

        System.out.println("\n=== PHÂN LOẠI SINH VIÊN THEO GPA ===");

        System.out.println("\n1. Sinh viên xuất sắc (GPA >= 8.5):");
        inDanhSachTheoNhom(xuatSac);

        System.out.println("\n2. Sinh viên giỏi (7.0 <= GPA < 8.5):");
        inDanhSachTheoNhom(gioi);

        System.out.println("\n3. Sinh viên khá (5.5 <= GPA < 7.0):");
        inDanhSachTheoNhom(kha);

        System.out.println("\n4. Sinh viên trung bình/yếu (GPA < 5.5):");
        inDanhSachTheoNhom(trungBinh);
    }

    private static void inDanhSachTheoNhom(List<Student> nhom) {
        if (nhom.isEmpty()) {
            System.out.println("Không có sinh viên nào trong nhóm này!");
            return;
        }

        System.out.println(String.format("%-10s | %-25s | %-5s | %-15s",
                "Mã SV", "Họ và tên", "GPA", "Xếp loại"));
        System.out.println("--------------------------------------------------------");

        for (Student sv : nhom) {
            System.out.println(sv);
        }
    }
}