import java.util.Scanner;

public class Bai8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("----------------- Nhập thông tin sinh viên ------------------ \n");
        System.out.print("Nhập mã sinh viên: ");
        String studentId = scanner.next();
        System.out.print("Nhập tên học sinh: ");
        String name = scanner.next();
        System.out.print("Nhập số điện thoại sinh viên: ");
        String phoneNumber = scanner.next();
        System.out.print("Nhập ngày sinh: ");
        String birthDate = scanner.next();
        System.out.print("Nhập giới tính sinh viên (1: Nam, 0: Nữ): ");
        int gender = scanner.nextInt();
        System.out.print("----------------- Nhập điểm sinh viên ------------------ \n");
        System.out.print("Nhập điểm toán: ");
        double mathScore = scanner.nextDouble();
        System.out.print("Nhập điểm lý: ");
        double physicsScore = scanner.nextDouble();
        System.out.print("Nhập điểm hóa: ");
        double chemistryScore = scanner.nextDouble();
        System.out.print("Nhập điểm sinh: ");
        double biologyScore = scanner.nextDouble();
        System.out.print("Nhập điểm ngoại ngữ: ");
        double languageScore = scanner.nextDouble();
        scanner.close();
        double score = (mathScore + physicsScore + chemistryScore + biologyScore + languageScore) / 5;

        String result = (score >= 8.0) ? "Giỏi" :
                (score >= 6.5) ? "Khá" :
                        (score >= 5.0) ? "Trung bình" : "Yếu";

        System.out.println("\n----------------- Thông tin sinh viên ------------------ ");
        System.out.printf("\nMã sinh viên: %s | Tên sinh viên:  %s | Giới tính:  %s", studentId, name, gender);
        System.out.printf("\nNgày sinh: %s | Số điện thoại:  %s ", birthDate, phoneNumber);
        System.out.printf("Điểm toán : %.2f | Điểm Vật lý = %.2f | Điểm Hóa học : %.2f | Điểm Sinh học : %.2f | Điểm Ngoại ngữ : %.2f\n",
                mathScore, physicsScore, chemistryScore, biologyScore, languageScore);
        System.out.printf("Điểm trung bình: %.2f", score);

    }
}
