import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        System.out.print("Nhập vào số thứ nhất: ");
        double num1 = scanner.nextDouble();

        System.out.print("Nhập phép toán (+, -, *, /): ");
        char operator = scanner.next().charAt(0);

        System.out.print("Nhập số thứ hai");
        double num2 = scanner.nextDouble();
        scanner.close();

        double result;
        boolean isValid = false;


        switch (operator) {
            case '+':
                result = num1 + num2;
                System.out.println("Kết quả: " + result);
                break;
            case '-':
                result = num1 - num2;
                System.out.println("Kết quả: " + result);
                break;
            case '*':
                result = num1 * num2;
                System.out.println("Kết quả: " + result);
                break;
            case '/':
                if (num2 == 0) {
                    System.out.println("Không thể chia cho 0.");
                } else {
                    result = num1 / num2;
                    System.out.println("Kết quả: " + result);
                }
                break;
            default:
                System.out.println("Phép toán không hợp lệ.");
        }
    }
}
