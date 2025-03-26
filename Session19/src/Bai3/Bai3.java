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

        BinaryOperator<Integer> addOperation = MathOperations::add;
        System.out.println("Phép cộng: " + addOperation.apply(a, b));

        BinaryOperator<Integer> subtractOperation = MathOperations::subtract;
        System.out.println("Phép trừ: " + subtractOperation.apply(a, b));

        BinaryOperator<Integer> multiplyOperation = MathOperations::multiply;
        System.out.println("Phép nhân: " + multiplyOperation.apply(a, b));

        try {
            BinaryOperator<Integer> divideOperation = MathOperations::divide;
            System.out.println("Phép chia: " + divideOperation.apply(a, b));
        } catch (ArithmeticException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }

        scanner.close();
    }
}
