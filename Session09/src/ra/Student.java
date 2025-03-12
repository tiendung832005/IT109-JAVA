package ra;

import java.util.Scanner;

public class Student {
    /*
    *  Xây dụựng lớp sinh viên quản lý thông tin:
    *   1. Các thuộc tính
    *       - Mã sinh viên
    * - M   - Tên sinh viên
    *       - Tuổi sinh viên
    *       - Giới tính sinh viên
    *       - Địa chỉ sinh viên
    *   2. Có 3 constructor: không tham số, có 2 tham số mã sinh viên - tên sinh viên, có đầy đủ tham số
    *   3. Có các hành vi:
    *       - Tính tổng 2 số nguyên
    *       - Chào giảng viên
    *       - Nhập thông tin sinh viên
    *       - Hiển th thông tin sinh viên
    * */
    //1. Fields | Properties  | Attributes: Thộc tính mô tả các đặc điêm của đối tượng trong thế giới thực
    //Syntax: private + datatype + attributeName
    private String studentId;
    private String studentName;
    private int age;
    private boolean sex;
    private String address;
    //2. Constructors: các hàm tạo giúp khởi tạo đối tượng từ lớp
    //Syntax: public + className (paramters)
    // - Constructor default: 0 tham số khởi tạo đối tượng với các thuộc tính với các giá trị mặc định
    public Student() {

    }
    // - Contructor 2 tham số khởi tạo đối tượng với mã sinh viên và tên sinh viên
    public Student(String studentId, String studentName){
        this.studentId = studentId;
        this.studentName = studentName;

    }
    // - Contructor đầy đủ tham số khởi tạo đối tượng
    public Student(int age, String studentId, String studentName, boolean sex, String address) {
        this.age = age;
        this.studentId = studentId;
        this.studentName = studentName;
        this.sex = sex;
        this.address = address;
    }

    // 3. Methods mô tả các hành vi của đối tượng
    //Syntax: Access Modifer + ReturnData + MethodName (parameters){Block Statements}
    // 3.1 Getter/Setter
    // Getter:


    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // 3.2 Method Behavior: Phương thức hành vi
    public int addTwoNumbers (int firstNumber, int secondNumber) {
        int sum = firstNumber + secondNumber;
        return sum;
    }

    public void helloTeacher(){
        System.out.println("Xin chào giảng viên");
    }

    public void inputData(Scanner scanner) {
        System.out.println("Nhập mã sinh viên");
        this.studentId = scanner.nextLine();
        System.out.println("Nhập tên sinh viên");
        this.studentName = scanner.nextLine();
        System.out.println("Nhập tuổi sinh viên");
        this.age = scanner.nextInt();

    }
}
