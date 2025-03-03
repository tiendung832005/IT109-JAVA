import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số nguyên a: ");
        int a = scanner.nextInt();
        System.out.print("Nhập số nguyên b: ");
        int b = scanner.nextInt();
        System.out.print("Nhập số nguyên c: ");
        int c = scanner.nextInt();
        scanner.close();
        if (a == b && b == c) {
            System.out.println("Ba số nguyên bằng nhau");
        } else {
            if (a >= b && a >= c) {
                System.out.println(a + " là số lớn nhất");
            } else if (b >= a && b >= c) {
                System.out.println(b + " là số lớn nhất");
            } else {
                System.out.println(c + " là số lớn nhất");
            }
        }
    }

}
