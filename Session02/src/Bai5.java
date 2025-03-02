import java.util.Scanner;
public class Bai5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập chiều dài: ");
        double length = scanner.nextDouble();
        System.out.print("Nhập chiều rộng: ");
        double width = scanner.nextDouble();
        scanner.close();

        double area = length * width;
        double perimeter = 2 * (length + width);

        System.out.printf("Diện tích hình chữ nhật: %.2f", + area);
        System.out.printf("\nChu vi hình chữ nhật: %.2f", + perimeter);
    }
}
