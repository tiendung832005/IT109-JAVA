package Bai3;

import java.util.Scanner;
import java.util.function.BinaryOperator;

public class Bai3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số thứ nhất a: ");
        int a = scanner.nextInt();

        System.out.print("Nhập số thứ hai b: ");
        int b = scanner.nextInt();

        System.out.println("Phép cộng: " + MathOperations.add(a, b));

        System.out.println("Phép trừ: " + MathOperations.subtract(a, b));

        System.out.println("Phép nhân: " + MathOperations.multiply(a, b));

        try {
            System.out.println("Phép chia: " + MathOperations.divide(a, b));
        } catch (ArithmeticException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }

        scanner.close();
    }
}
