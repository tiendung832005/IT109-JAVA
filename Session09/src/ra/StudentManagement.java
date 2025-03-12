package ra;

import java.util.Scanner;

public class StudentManagement {
    public static void main(String[] args) {
        // Khoởi tạo đối tượng: ClassName objName = new Constructor(Arguments)
        //1. Khởi tạo đối tượng sinh viên 1 với các thông tin mặc định
        Student student1 = new Student();
        //2. Khởi tạo đối tượng sinh viên 2 với các thông tin Mã sinh viên là SV002, tên SV: Nguyêễn Văn B
        Student student2 = new Student("SV002", "Nguyễn Văn B");
        //3. Khởi tạo đối tượng sinh viên 3 với các thông tin tu��i là 18, Mã sinh viên là SV003, tên SV: Nguyễn Văn C, giới tính là nữ, đ��a chỉ là 123 Phan Châu Trinh
        Student student3 = new Student(18, "SV003", "Nguyễn Văn C", true, "123 Phan Châu Trinh");
        //4. Nhâp thông tin sinh viên
        System.out.println("******************NHẬP THÔNG TIN SINH VIÊN********************");
        Scanner scanner = new Scanner(System.in);
        student1.inputData(scanner);
        //5. Sử dụng các phương thức setter để nhập các thông tin còn lại của sinh viên 2
        System.out.println("******************NHẬP THÔNG TIN SINH VIÊN********************");
        System.out.println("Nhap vào tuổi sinh viên");
        student2.setAge(Integer.parseInt(scanner.nextLine()));
        System.out.println("Nhập vào tên sinh viên:");
        

    }
}
