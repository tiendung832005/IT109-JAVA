import java.util.Scanner;
import java.util.regex.Pattern;

public class Bai6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mật khẩu: ");
        String password = scanner.nextLine();
        if(Pattern.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$!%]).{8,}$",password)){
            System.out.println("Mật khẩu hợp lệ");
        }else{
            System.out.println("Mật khẩu không hợp lệ");
        }
        scanner.close();
    }
}
