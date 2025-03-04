import java.util.Scanner;

public class Bai8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;


        do {
            System.out.print("Nhập số nguyên dương: ");
            n = scanner.nextInt();
            if (n <= 0) {
                System.out.println("Số nhập vào không hợp lệ");
            }
        } while (n <= 0);

        scanner.close();
        System.out.print("Các số Armstrong nhỏ hơn hoặc bằng " + n + " là:");

        boolean found = false;
        for (int i = 1; i <= n; i++) {
            int num = i, sum = 0, temp = i;
            int count = 0;


            while (temp > 0) {
                count++;
                temp /= 10;
            }

            temp = i;

            while (temp > 0) {
                int digit = temp % 10;
                int power = 1;


                for (int j = 0; j < count; j++) {
                    power *= digit;
                }

                sum += power;
                temp /= 10;
            }


            if (sum == i && (i == 1 || i >= 10)) {
                if (found) {
                    System.out.print(", " + i);
                } else {
                    System.out.print(" " + i);
                    found = true;
                }
            }
        }


    }
}
