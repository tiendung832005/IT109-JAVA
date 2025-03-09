import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        System.out.print("Nhâp số lượng trong mảng: ");
        int n = scanner.nextInt();

        if(n <= 0 ) {
            System.out.println("Kích thước rỗng");
            return;
        }

        int[] arr = new int[n];
        System.out.println("Nhập các giá trị cho mảng: ");
        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println("Mảng ban đầu: " );
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " \n");
        }

        for(int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }

        System.out.print("Mảng sau khai đảo\n");
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " \n");
        }
        scanner.close();

    }
}
