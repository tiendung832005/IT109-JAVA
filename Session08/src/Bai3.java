import java.util.Scanner;
import java.util.regex.Pattern;

public class Bai3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String email, password;
        while (true) {
            System.out.println("Nhập email: ");
            email = scanner.nextLine();
            if (Pattern.matches("^[a-zA-Z0-9._-]+@[a-zA-Z0-9]+(\\.[a-zA-Z]{2,6})+$", email)) {
                break;
            }
            System.out.println("Email không hợp lệ");
        }
        while (true) {
            System.out.println("Nhập mật khẩu: ");
            password = scanner.nextLine();
            if (Pattern.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%!&*]).{8,}$", password)) {
                break;
            }
            System.out.println("Mật khẩu không hợp lệ");
        }
        System.out.println("Email và mật khẩu hợp lệ");
    }
}
