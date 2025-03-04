import java.util.Scanner;

public class Bai7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số nguyên dương n: ");
        int n = scanner.nextInt();
        scanner.close();

        System.out.println("Các số happy nhỏ hơn hoặc bằng " + n + " là:");

        for (int i = 1; i <= n; i++) {
            int num = i;
            int count = 0;

            while (num != 1 && count < 100) {
                int sum = 0;
                int temp = num;


                while (temp > 0) {
                    int digit = temp % 10;
                    sum += digit * digit;
                    temp /= 10;
                }

                num = sum;
                count++;
            }
            if (num == 1) {
                System.out.print(i + " ");
            }
        }
    }
}
