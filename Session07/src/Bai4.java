import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập chuỗi cần kiểm tra: ");
        String firstString = scanner.nextLine();

        firstString = firstString.toLowerCase();

        StringBuilder strBuilder = new StringBuilder(firstString);
        String afterString = strBuilder.reverse().toString();


        if (firstString.equals(afterString)) {
            System.out.println("Chuỗi đối xứng.");
        } else {
            System.out.println("Chuỗi không đối xứng");
        }
        scanner.close();
    }
}
