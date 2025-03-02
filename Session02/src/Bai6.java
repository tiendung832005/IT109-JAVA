import java.util.Scanner;

public class Bai6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên học sinh: ");
        String name = scanner.next();
        System.out.print("Nhập điểm toán: ");
        double mathScore = scanner.nextDouble();
        System.out.print("Nhập điểm lý: ");
        double physicsScore = scanner.nextDouble();
        System.out.print("Nhập điểm hóa: ");
        double chemistryScore = scanner.nextDouble();
        scanner.close();
        double score = (mathScore + physicsScore + chemistryScore) / 3;

        String result = (score >= 8.0) ? "Giỏi" :
                (score >= 6.5) ? "Khá" :
                        (score >= 5.0) ? "Trung bình" : "Yếu";

        System.out.printf("\nHọc sinh: %s\n", name);
        System.out.printf("Điểm trung bình: %.2f\n", score);
        System.out.printf("Xếp loại: %s\n", result);
    }
}
