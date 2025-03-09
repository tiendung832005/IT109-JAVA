import java.util.Scanner;
import java.util.regex.Pattern;

public class Bai5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập một chuỗi bất kỳ: ");
        String str = scanner.nextLine().trim();
        String[] words = str.split("\\s+");

        int count = 0;

        String check = ".*[^a-zA-Z0-9].*";
        System.out.println("Các từ chứa ký tự đặc biệt:");
        for (String word : words) {
            if (word.matches(check)) {
                count++;
            }
        }
        System.out.print("Số lượng từ chứa ký tự đặc biệt: " + count+ " ");
        for (String word : words) {
            if (word.matches(check)) {
                System.out.print(word+" ");
            }
        }
        scanner.close();
    }
}
