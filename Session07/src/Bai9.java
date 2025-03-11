import java.util.Scanner;

public class Bai9 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập chuỗi: ");
        String originString = scanner.nextLine();

        if (originString.isEmpty()) {
            System.out.println("Chuô vừa nhập: ");
            scanner.close();
            return;
        }

        StringBuilder compressedString = new StringBuilder();

        char currentChar = originString.charAt(0);
        int count = 1;

        for (int i = 1; i < originString.length(); i++) {
            char character = originString.charAt(i);

            if (character == currentChar) {
                count++;
            } else {
                compressedString.append(currentChar).append(count);

                currentChar = character;
                count = 1;
            }
        }


        compressedString.append(currentChar).append(count);

        System.out.println("Chuỗi đã đổi: " + compressedString.toString());

        scanner.close();
    }
}
