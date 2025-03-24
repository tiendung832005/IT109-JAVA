import java.util.HashSet;
import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        HashSet<String> languages = new HashSet<>();

        languages.add("Java");
        languages.add("Python");
        languages.add("C++");
        languages.add("JavaScript");

        System.out.println("Các phần tử:");
        for (String language : languages) {
            System.out.println(language);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nNhập 1 phần tử: ");
        String input = scanner.nextLine();

        if (languages.contains(input)) {
            System.out.println("'" + input + "' tồn tại");
        } else {
            System.out.println("'" + input + "' không tồn tại ");
        }
        scanner.close();
    }
}