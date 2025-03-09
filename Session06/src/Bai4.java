import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời bạn nhập: ");
        String a = scanner.nextLine();
        System.out.println(a.replaceAll("[0-9]", "*"));
        scanner.close();
    }
}
