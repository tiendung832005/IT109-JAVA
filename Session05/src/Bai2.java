import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        System.out.print("Nhâp số lượng trong mảng: ");
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        System.out.println("Nhập các giá trị cho mảng: ");
        int sum = 0;
        for(int i = 0; i < n; i++){
            numbers[i] =  scanner.nextInt();
        }

        for (int num : numbers) {
            sum += num;
        }
        System.out.println("Tổng các giá trị trong mảng: " + sum);
        scanner.close();

    }
}
