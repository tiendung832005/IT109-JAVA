import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập một chuỗi bất kỳ:");
        String inputString = scanner.nextLine();

        System.out.println("Chuỗi ban đầu: " + inputString);

        StringBuilder strBuilder = new StringBuilder(inputString);

        strBuilder.reverse();
        String reverseString = strBuilder.toString();

        System.out.println("Chuỗi sau khi đảo ngược: " + reverseString);

        scanner.close();
    }
}
