import java.util.Scanner;

public class Bai7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        System.out.print("Nhập cạnh thứ nhất: ");
        int a = scanner.nextInt();
        System.out.print("Nhập cạnh thứ hai: ");
        int b = scanner.nextInt();
        System.out.print("Nhập cạnh thứ ba: ");
        int c = scanner.nextInt();
        scanner.close();

        if (a + b > c && a + c > b && b + c > a) {

            if (a == b && b == c) {
                System.out.println("Tam giác đều.");
            } else if (a == b || a == c || b == c) {
                System.out.println("Tam giác cân.");
            } else if (a * a + b * b == c * c || a * a + c * c == b * b || b * b + c * c == a * a) {
                System.out.println("Tam giác vuông.");
            } else {
                System.out.println("Tam giác thường.");
            }
        } else {
            System.out.println("Ba cạnh không tạo thành tam giác.");
        }

    }
}
