import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập n: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        do {
            System.out.print("\n******************** MENU ********************\n" +
                    "1. Nhập giá trị `n` phần tử của mảng (`n` nhập từ bàn phím)\n" +
                    "2. In giá trị các phần tử trong mảng\n" +
                    "3. Tính trung bình các phần tử dương (`>0`) trong mảng\n" +
                    "4. In ra vị trí (chỉ số) các phần tử có giá trị bằng `k` trong mảng (`k` nhập từ bàn phím)\n" +
                    "5. Tính số lượng các phần tử là **số nguyên tố** trong mảng\n" +
                    "6. Thoát chương trình\n" +
                    "Lựa chọn của bạn: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    for (int i = 0; i < n; i++) {
                        System.out.printf("Nhập arr[%d]: ", i);
                        arr[i] = sc.nextInt();
                    }
                    break;
                case 2:
                    System.out.print("Giá trị của mảng: ");
                    for (int i = 0; i < arr.length; i++) {
                        System.out.print(arr[i] + " ");
                    }
                    System.out.println();
                    break;
                case 3:
                    float sum = 0, count = 0;
                    for (int i = 0; i < arr.length; i++) {
                        if (arr[i] > 0) {
                            sum += arr[i];
                            count++;
                        }
                    }
                    if (count > 0) {
                        float avg = sum / count;
                        System.out.println("Giá trị trung bình dương: " + avg);
                    } else {
                        System.out.println("Không có số dương trong mảng");
                    }
                    break;
                case 4:
                    System.out.println("Nhập k: ");
                    int k = sc.nextInt();
                    boolean found = false;
                    for (int i = 0; i < arr.length; i++) {
                        if (arr[i] == k) {
                            System.out.printf("Vị trí %d có giá trị %d\n", i, arr[i]);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Không tìm thấy phần tử nào bằng k");
                    }
                    break;
                case 5:
                    int countPrime = 0;
                    for (int i = 0; i < arr.length; i++) {
                        if (arr[i] >= 2) {
                            boolean isPrime = true;
                            for (int j = 2; j * j <= arr[i]; j++) {
                                if (arr[i] % j == 0) {
                                    isPrime = false;
                                    break;
                                }
                            }
                            if (isPrime) {
                                countPrime++;
                            }
                        }
                    }
                    System.out.println("Số lượng các số nguyên tố trong mảng: " + countPrime);
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Vui lòng nhập đúng");
            }
        } while (true);
    }
}
