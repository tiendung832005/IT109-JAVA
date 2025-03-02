import java.util.Scanner;
import java.math.BigInteger;
public class Bai10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập a: ");
        BigInteger a = new BigInteger(scanner.nextLine());

        System.out.print("Nhập b: ");
        BigInteger b = new BigInteger(scanner.nextLine());
        scanner.close();

        System.out.println("a + b =: " + a.add(b));
        System.out.println("a - b =: " + a.subtract(b));
        System.out.println("a x b =: " + a.multiply(b));


        System.out.println(b.equals(BigInteger.ZERO) ? "Không thể chia cho 0" : "a / b = " + a.divide(b));
        System.out.println(b.equals(BigInteger.ZERO) ? "Không thể chia lấy dư1" : "a % b = " + a.mod(b));

        System.out.println("a ^ 10 = " + a.pow(10));


    }
}
