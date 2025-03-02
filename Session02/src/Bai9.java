import java.util.Scanner;
public class Bai9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Nhập cạnh a: ");
        double a = scanner.nextDouble();
        System.out.print("Nhập cạnh b: ");
        double b = scanner.nextDouble();
        System.out.print("Nhập cạnh c: ");
        double c = scanner.nextDouble();
        scanner.close();

        double perimeter = a + b + c;

        double area = Math.sqrt((perimeter * (perimeter - a) * (perimeter - b) * (perimeter - c))/2);


        System.out.println("\n------ Kết quả ------");
        System.out.printf("Chu vi tam giác: %.2f\n", perimeter);
        System.out.printf("Diện tích tam giác: %.2f\n", area);
    }
}
