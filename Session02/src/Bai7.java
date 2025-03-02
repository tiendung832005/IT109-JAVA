import java.util.Scanner;
public class Bai7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập giờ ban đầu: ");
        int hour = scanner.nextInt();
        System.out.print("Nhập phút ban đầu: ");
        int minute = scanner.nextInt();
        System.out.print("Nhập giây ban đầu: ");
        int second = scanner.nextInt();

        System.out.print("Nhập số giờ cần cộng: ");
        int addHour = scanner.nextInt();
        System.out.print("Nhập số phút cần cộng: ");
        int addMinute = scanner.nextInt();
        System.out.print("Nhập số giây cần cộng: ");
        int addSecond = scanner.nextInt();

        scanner.close();

        int totalSecond = (hour * 3600 + minute * 60 + second) + (addHour * 3600 + addMinute * 60 + addSecond);

        int newHour = totalSecond / 3600;
        int newMinute = (totalSecond % 3600) / 60;
        int newSecond = totalSecond % 60;

        System.out.printf("Thời gian mới là: %02d:%02d:%02d\n", newHour, newMinute, newSecond);
    }
}
