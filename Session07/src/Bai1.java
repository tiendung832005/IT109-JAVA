import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập chuỗi 1:");
        String firstString = scanner.nextLine();

        System.out.println("Nhập chuỗi 2:");
        String secondString = scanner.nextLine();

        System.out.println("Nhập chuỗi 3:");
        String thirdString = scanner.nextLine();

        StringBuilder strBuilder = new StringBuilder();

        strBuilder.append(firstString);
        strBuilder.append(secondString);
        strBuilder.append(thirdString);


        String concatenatedString = strBuilder.toString();
        System.out.println("\nChuỗi sau khi nối: " + concatenatedString);


        String uppercaseString = concatenatedString.toUpperCase();
        System.out.println("\nChuỗi sau khi chuyển thành chữ hoa: " + uppercaseString);

        scanner.close();
    }
}
