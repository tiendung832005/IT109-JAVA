import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập một chuỗi bất kỳ: ");
        String input = scanner.nextLine();

        input = input.trim();

        if (input.isEmpty()) {
            System.out.println("Số từ trong chuỗi: 0");
        } else {

            String[] words = input.split("\\s+");

            System.out.println("Số từ trong chuỗi: " + words.length);
        }

        scanner.close();
    }
}
