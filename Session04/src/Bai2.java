import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        System.out.println("Nhap vao so n:");
        int n = scanner.nextInt();

        if (n < 2){
            System.out.println("Không phải số nguyên tố");
        }else{
            boolean isPrime = true;
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.println(n + " là số nguyên tố.");
            } else {
                System.out.println(n + " không phải số nguyên tố.");
            }
        }
    }
}
