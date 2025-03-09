import java.util.Scanner;

public class Bai8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số phần tử của mảng: ");
        int n = scanner.nextInt();

        if (n == 0) {
            System.out.println("Mảng không hợp lệ.");
            return;
        }

        int[] arr = new int[n];
        int[] countArr = new int[1001];

        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            countArr[arr[i]]++;
        }

        boolean hasUnique = false;
        System.out.println("Mảng sau khi loại bỏ phần tử trùng lặp:");
        for (int i = 0; i < n; i++) {
            if (countArr[arr[i]] == 1) {
                System.out.print(arr[i] + " ");
                hasUnique = true;
            }
        }

        if (!hasUnique) {
            System.out.println("Không có phần tử nào duy nhất trong mảng.");
        }
    }
}
