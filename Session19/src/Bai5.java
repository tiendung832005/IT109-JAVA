
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> stringList = new ArrayList<>();

        System.out.println("Nhập số lượng chuỗi: ");
        int n = Integer.parseInt(scanner.nextLine());

        System.out.println("Nhập danh sách chuỗi: ");
        for (int i = 0; i < n; i++) {
            stringList.add(scanner.nextLine());
        }


        int count = 0;
        for (String s : stringList) {
            if (s.startsWith("A") && s.length() >= 5) {
                count++;
            }
        }

        System.out.println("Số lượng chuỗi thỏa mãn điều kiện: " + count);
        scanner.close();
    }
}