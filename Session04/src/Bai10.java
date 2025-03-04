import java.util.Scanner;
public class Bai10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {

            System.out.println("\n-------------------- MENU -----------------------");
            System.out.println("1. Kiểm tra số nguyên tố");
            System.out.println("2. Kiểm tra số hoàn hảo");
            System.out.println("3. Tìm và tính tổng tất cả các ước của một số");
            System.out.println("4. Thoát chương trình");
            System.out.print("Chọn chức năng: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:

                    System.out.print("Nhập số nguyên dương: ");
                    int n = scanner.nextInt();
                    if (n <= 0) {
                        System.out.println("Số nhập vào không hợp lệ");
                        break;
                    }

                    boolean isPrime = true;
                    if (n < 2) {
                        isPrime = false;
                    } else {
                        for (int i = 2; i * i <= n; i++) {
                            if (n % i == 0) {
                                isPrime = false;
                                break;
                            }
                        }
                    }

                    if (isPrime) {
                        System.out.println(n + " là số nguyên tố.");
                    } else {
                        System.out.println(n + " không phải là số nguyên tố.");
                    }
                    break;

                case 2:

                    System.out.print("Nhập số nguyên dương: ");
                    int m = scanner.nextInt();
                    if (m <= 0) {
                        System.out.println("Số nhập vào không hợp lệ!");
                        break;
                    }

                    int sum = 0;
                    for (int i = 1; i < m; i++) {
                        if (m % i == 0) {
                            sum += i;
                        }
                    }
                    if (sum == m) {
                        System.out.println(m + " là số hoàn hảo.");
                    } else {
                        System.out.println(m + " không phải là số hoàn hảo.");
                    }
                    break;

                case 3:

                    System.out.print("Nhập số nguyên dương: ");
                    int k = scanner.nextInt();
                    if (k <= 0) {
                        System.out.println("Số nhập vào không hợp lệ!");
                        break;
                    }

                    int total = 0;
                    System.out.print("Các ước của " + k + " là: ");
                    for (int i = 1; i <= k; i++) {
                        if (k % i == 0) {
                            System.out.print(i + " ");
                            total += i;
                        }
                    }
                    System.out.println("\nTổng các ước của " + k + " là: " + total);
                    break;

                case 4:
                    System.out.println("Chương trình kết thúc.");
                    scanner.close();
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        } while (true);


    }
}
