import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bai10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập: ");
        String str = scanner.nextLine();
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(str);
        System.out.print("Các số trong chuỗi: ");
        boolean found = false;

        while (matcher.find()) {
            System.out.print(matcher.group() + " ");
            found = true;
        }
        if (!found) {
            System.out.print("[]");
        }

        str = str.replaceAll("\\s+", " ").replaceAll("[^a-zA-Z0-9\\s]", "").trim().toLowerCase();
        if (str.isEmpty()) {
            System.out.println("Không có văn bản để xử lý");
            return;
        }
        System.out.println("\nChuỗi sau khi chuẩn hóa: "+str);

        scanner.close();
    }
}
