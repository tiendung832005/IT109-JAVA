import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập câu cần xử lý: ");
        String firstString = scanner.nextLine();

        firstString = firstString.trim().replaceAll("\\s+", " ");

        String[] cacTu = firstString.split(" ");

        StringBuilder strBuilder = new StringBuilder();

        for (int i = 0; i < cacTu.length; i++) {
            StringBuilder afterString = new StringBuilder(cacTu[i]);
            afterString.reverse();

            strBuilder.append(afterString);

            if (i < cacTu.length - 1) {
                strBuilder.append(" ");
            }
        }

        System.out.println("Câu sau khi đảo: " + strBuilder.toString());

        scanner.close();
    }
}
