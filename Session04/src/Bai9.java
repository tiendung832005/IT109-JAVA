import java.util.Scanner;

public class Bai9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        int n;

        do {
            System.out.print("Nhập số nguyên dương: ");
            n = scanner.nextInt();
            if (n <= 0) {
                System.out.println("Số nhập vào không hợp lệ");
            }
        } while (n <= 0);
        scanner.close();

        System.out.print("Các số Palindrome nhỏ hơn hoặc bằng " + n + " là: ");

        boolean found = false;
        for (int i = 1; i <= n; i++) {
            int original = i;
            int reversed = 0;
            int temp = i;


            while (temp > 0) {
                int digit = temp % 10;
                reversed = reversed * 10 + digit;
                temp /= 10;
            }


            if (original == reversed) {
                if (found) {
                    System.out.print(", " + i);
                } else {
                    System.out.print(i);
                    found = true;
                }
            }
        }

    }
}
