import java.util.Random;
import java.util.Scanner;

public class Bai8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập độ dài chuỗi ngẫu nhiên (1 ≤ n ≤ 1000): ");
        int n = scanner.nextInt();

        if (n < 1 || n > 1000) {
            System.out.println("Độ dài không hợp lệ");
            scanner.close();
            return;
        }


        Random random = new Random();

        StringBuilder strBuilder = new StringBuilder(n);
        String character = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        int characterSum = character.length();


        for (int i = 0; i < n; i++) {
            int locationRandom = random.nextInt(characterSum);
            char characterRandom = character.charAt(locationRandom);

            strBuilder.append(characterRandom);
        }


        String strRandom = strBuilder.toString();
        System.out.println("Chuỗi ngẫu nhiên có độ dài " + n + ": " + strRandom);

        scanner.close();
    }
}
