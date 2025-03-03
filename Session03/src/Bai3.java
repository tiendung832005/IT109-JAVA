import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập điểm toán: ");
        double mathScore = scanner.nextDouble();
        System.out.print("Nhập điểm lý: ");
        double physicsScore = scanner.nextDouble();
        System.out.print("Nhập điểm hóa: ");
        double chemistryScore = scanner.nextDouble();
        scanner.close();
        double score = (mathScore + physicsScore + chemistryScore) / 3;

        if(score > 8.0) {
            System.out.printf("Xếp loại: Giỏi");
        } else if (6.5 < score  && score < 8.0) {
            System.out.printf("Xếp loại: Khá");
        }else if (5.0 < score && score < 6.5){
            System.out.printf("Xếp loại: Trung bình");
        }else if (5.0 > score ){
            System.out.printf("Xếp loại: Yếu");
        }else if (score > 10.0 && score < 0.0){
            System.out.println("Điểm không hợp lệ");
        }
    }
}
