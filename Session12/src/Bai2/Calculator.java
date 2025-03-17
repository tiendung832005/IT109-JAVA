package Bai2;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }
}
class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        int sumTwoNumbers = calculator.add(1, 2);
        System.out.println("Tổng 2 số: " + sumTwoNumbers);

        int sumThreeNumbers = calculator.add(3, 5, 7);
        System.out.println("Tổng 3 số: " + sumThreeNumbers);
    }
}

