import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập một số nguyên dương: ");
        int n = scanner.nextInt();
        int numbertotal = 0;
        scanner.close();
        if (n <= 0) {
            System.out.println("Số nhập vào không hợp lệ");
        } else {
            System.out.print("Các số  từ 1 đến " + n + " là: ");
            for (int i = 0; i <= n; i++) {
                    System.out.printf("%d\t", i);
                    numbertotal += i;
            }
            System.out.println("\nTổng các số chẵn từ 1 đến " + n + " là: " + numbertotal);
        }

    }
}
