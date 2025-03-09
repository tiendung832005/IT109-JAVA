import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bai9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập URL: ");
        String url = scanner.nextLine();
        String regex = "^(https?)://([\\w.-]+)(/.*)?$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(url);
        if (matcher.matches()) {
            String protocol = matcher.group(1);
            String domain = matcher.group(2);
            String path = matcher.group(3) != null ? matcher.group(3) : "Không có đường dẫn.";
            System.out.println("Giao thức: " + protocol);
            System.out.println("Tên miền: " + domain);
            System.out.println("Đường dẫn: " + path);
        } else {
            System.out.println("URL không hợp lệ.");
        }
        scanner.close();
    }
}
