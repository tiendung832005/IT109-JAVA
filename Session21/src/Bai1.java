import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập số bị chia: ");
            int soBiChia = scanner.nextInt();

            System.out.print("Nhập số chia: ");
            int soChia = scanner.nextInt();

            double ketQua = (double) soBiChia / soChia;


            System.out.printf("Kết quả phép chia:", ketQua);
        }
        catch (ArithmeticException e) {
            System.out.println("Lỗi: Không thể chia cho 0!");
        }
        catch (Exception e) {
            System.out.println("Lỗi: Vui lòng nhập số nguyên hợp lệ!");
        }
        finally {
            scanner.close();
        }
    }
}