import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        System.out.println("Nhập vào 1 số nguyên dương:");
        int n = scanner.nextInt();
        System.out.printf("Số nhập vào: %d\n", n);
        switch (n) {
            case 1:
                System.out.println("chủ nhật");
                break;
                case 2:
                    System.out.println("thứ hai");
                    break;
                case 3:
                    System.out.println("thứ ba");
                    break;
                case 4:
                    System.out.println("thứ tư");
                    break;
                case 5:
                    System.out.println("thứ năm");
                    break;
                case 6:
                    System.out.println("thứ sáu");
                    break;
                case 7:
                    System.out.println("thứ bảy");
                    break;
                case 8:
                    System.out.println("Soos nhập vào k hợp lệ");
                    break;
                case 9:
                    System.out.println("Soos nhập vào k hợp lệ");
                    break;
                case 10:
                    System.out.println("Soos nhập vào k hợp lệ");
                    break;
                default:
                    System.out.println("Soos nhập vào k hợp lệ");
        }
    }
}
