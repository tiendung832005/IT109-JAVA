import java.util.Scanner;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên học sinh: ");
        String name = scanner.next();
        System.out.print("Nhập điểm toán: ");
        double mathScore = scanner.nextDouble();
        System.out.print("Nhập điểm lý: ");
        double physicsScore = scanner.nextDouble();
        System.out.print("Nhập điểm hóa: ");
        double chemistryScore = scanner.nextDouble();
        scanner.close();
    }
}