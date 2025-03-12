import java.util.ArrayList;
import java.util.Scanner;

// Bài 10
public class Student {
    private int id;
    private String name;
    private int age;
    private Gender gender;
    private String address;
    private String phoneNumber;

    public Student() {}

    public Student(int id, String name, int age, Gender gender, String address, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public void inputData(Scanner scanner) {
        System.out.print("Nhập mã học sinh: ");
        id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập tên học sinh: ");
        name = scanner.nextLine();
        System.out.print("Nhập tuổi: ");
        age = Integer.parseInt(scanner.nextLine());
        System.out.println("Chọn giới tính: 1. Nam  2. Nữ  3. Khác");
        int choice = Integer.parseInt(scanner.nextLine());
        gender = Gender.fromInt(choice);
        System.out.print("Nhập địa chỉ: ");
        address = scanner.nextLine();
        System.out.print("Nhập số điện thoại: ");
        phoneNumber = scanner.nextLine();
    }

    public void displayData() {
        System.out.println("Mã HS: " + id);
        System.out.println("Tên HS: " + name);
        System.out.println("Tuổi: " + age);
        System.out.println("Giới tính: " + gender);
        System.out.println("Địa chỉ: " + address);
        System.out.println("SĐT: " + phoneNumber);
        System.out.println("------------------------------");
    }

    public int getId() {
        return id;
    }
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setGender(Gender gender) { this.gender = gender; }
    public void setAddress(String address) { this.address = address; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    static ArrayList<Student> studentList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public enum Gender {
        MALE("Nam"),
        FEMALE("Nữ"),
        OTHER("Khác");

        private String value;

        Gender(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }

        public static Gender fromInt(int choice) {
            switch (choice) {
                case 1: return MALE;
                case 2: return FEMALE;
                case 3: return OTHER;
                default: return OTHER;
            }
        }
    }

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("=========== MENU ===========");
            System.out.println("1. Hiển thị danh sách tất cả sinh viên");
            System.out.println("2. Thêm mới sinh viên");
            System.out.println("3. Sửa thông tin sinh viên theo mã");
            System.out.println("4. Xóa sinh viên");
            System.out.println("5. Thoát");
            System.out.print("Chọn: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    displayStudents();
                    break;
                case 2:
                    addStudent();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.out.println("Thoát chương trình");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        } while (true);
    }

    public static void displayStudents() {
        if (studentList.isEmpty()) {
            System.out.println("Danh sách sinh viên rỗng");
        } else {
            System.out.println("Danh sách sinh viên:");
            for (Student s : studentList) {
                s.displayData();
            }
        }
    }

    public static void addStudent() {
        Student s = new Student();
        s.inputData(scanner);
        studentList.add(s);
        System.out.println("Thêm sinh viên thành công");
    }

    public static void updateStudent() {
        System.out.print("Nhập mã học sinh cần sửa: ");
        int id = Integer.parseInt(scanner.nextLine());
        Student s = findStudentById(id);
        if (s != null) {
            System.out.println("Nhập thông tin mới:");
            System.out.print("Nhập tên mới: ");
            s.setName(scanner.nextLine());
            System.out.print("Nhập tuổi mới: ");
            s.setAge(Integer.parseInt(scanner.nextLine()));
            System.out.println("Chọn giới tính mới: 1. Nam  2. Nữ  3. Khác");
            int genderChoice = Integer.parseInt(scanner.nextLine());
            s.setGender(Gender.fromInt(genderChoice));
            System.out.print("Nhập địa chỉ mới: ");
            s.setAddress(scanner.nextLine());
            System.out.print("Nhập SĐT mới: ");
            s.setPhoneNumber(scanner.nextLine());
            System.out.println("Cập nhật thông tin thành công");
        } else {
            System.out.println("Không tìm thấy học sinh với mã: " + id);
        }
    }

    public static void deleteStudent() {
        System.out.print("Nhập mã học sinh cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        Student s = findStudentById(id);
        if (s != null) {
            studentList.remove(s);
            System.out.println("Xóa học sinh thành công");
        } else {
            System.out.println("Không tìm thấy học sinh với mã: " + id);
        }
    }
    public static Student findStudentById(int id) {
        for (Student s : studentList) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }
}
