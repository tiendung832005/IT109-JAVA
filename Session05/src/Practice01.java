import java.util.Scanner;

public class Practice01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[100];
        int n = -1;

        int choice;
        do {
            System.out.println("\n===== Menu =====");
            System.out.println("1. Nhập n phần tử cho mảng");
            System.out.println("2. In mảng");
            System.out.println("3. Tính trung bình các phần tử dương");
            System.out.println("4. Tìm vị trí phần tử bằng k");
            System.out.println("5. Sắp xếp mảng giảm dần (bubble sort)");
            System.out.println("6. Đếm số lượng số nguyên tố");
            System.out.println("7. Sắp xếp theo yêu cầu (chia 3 và chẵn/lẻ)");
            System.out.println("8. Chèn m vào mảng (giảm dần)");
            System.out.println("9. Thoát");
            System.out.print("Nhập lựa chọn: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Nhập số lượng phần tử n: ");
                    n = scanner.nextInt();
                    if (n <= 0 || n > 100) {
                        System.out.println("Số lượng phần tử không hợp lệ");
                        n = -1;
                        break;
                    }
                    for (int i = 0; i < n; i++) {
                        System.out.print("arr[" + i + "] = ");
                        arr[i] = scanner.nextInt();
                    }
                    break;

                case 2:
                    if (n == -1) {
                        System.out.println("Vui lòng nhập mảng trước");
                        break;
                    }
                    System.out.print("Mảng: ");
                    for (int i = 0; i < n; i++) {
                        System.out.print(arr[i] + " ");
                    }
                    System.out.println();
                    break;

                case 3:
                    if (n == -1) {
                        System.out.println("Vui lòng nhập mảng trước");
                        break;
                    }
                    int sum = 0, count = 0;
                    for (int i = 0; i < n; i++) {
                        if (arr[i] > 0) {
                            sum += arr[i];
                            count++;
                        }
                    }
                    if (count > 0) {
                        System.out.println("Trung bình các số dương: " + (sum * 1.0 / count));
                    } else {
                        System.out.println("Không có số dương trong mảng");
                    }
                    break;

                case 4:
                    if (n == -1) {
                        System.out.println("Vui lòng nhập mảng trước");
                        break;
                    }
                    System.out.print("Nhập k: ");
                    int k = scanner.nextInt();
                    boolean found = false;
                    System.out.print("Vị trí các phần tử bằng k: ");
                    for (int i = 0; i < n; i++) {
                        if (arr[i] == k) {
                            System.out.print(i + " ");
                            found = true;
                        }
                    }
                    if (!found) System.out.println("Không tìm thấy phần tử nào bằng k.");
                    System.out.println();
                    break;

                case 5:
                    if (n == -1) {
                        System.out.println("Vui lòng nhập mảng trước");
                        break;
                    }
                    for (int i = 0; i < n - 1; i++) {
                        for (int j = 0; j < n - i - 1; j++) {
                            if (arr[j] < arr[j + 1]) {
                                int temp = arr[j];
                                arr[j] = arr[j + 1];
                                arr[j + 1] = temp;
                            }
                        }
                    }
                    System.out.print("Mảng sau sắp xếp giảm dần: ");
                    for (int i = 0; i < n; i++) System.out.print(arr[i] + " ");
                    System.out.println();
                    break;

                case 6:
                    if (n == -1) {
                        System.out.println("Vui lòng nhập mảng trước");
                        break;
                    }
                    int countPrime = 0;
                    for (int i = 0; i < n; i++) {
                        if (arr[i] >= 2) {
                            boolean isPrime = true;
                            for (int j = 2; j <= arr[i] / 2; j++) {
                                if (arr[i] % j == 0) {
                                    isPrime = false;
                                    break;
                                }
                            }
                            if (isPrime) countPrime++;
                        }
                    }
                    System.out.println("Số lượng số nguyên tố: " + countPrime);
                    break;

                case 7:
                    if (n == -1) {
                        System.out.println("Vui lòng nhập mảng trước");
                        break;
                    }
                    int[] chanChia3 = new int[n], leChia3 = new int[n], conLai = new int[n];
                    int chanIdx = 0, leIdx = 0, conLaiIdx = 0;
                    for (int i = 0; i < n; i++) {
                        if (arr[i] % 3 == 0 && arr[i] % 2 == 0) chanChia3[chanIdx++] = arr[i];
                        else if (arr[i] % 3 == 0 && arr[i] % 2 != 0) leChia3[leIdx++] = arr[i];
                        else conLai[conLaiIdx++] = arr[i];
                    }
                    // Sắp tăng dần
                    for (int i = 0; i < chanIdx - 1; i++)
                        for (int j = i + 1; j < chanIdx; j++)
                            if (chanChia3[i] > chanChia3[j]) {
                                int temp = chanChia3[i]; chanChia3[i] = chanChia3[j]; chanChia3[j] = temp;
                            }
                    for (int i = 0; i < conLaiIdx - 1; i++)
                        for (int j = i + 1; j < conLaiIdx; j++)
                            if (conLai[i] > conLai[j]) {
                                int temp = conLai[i]; conLai[i] = conLai[j]; conLai[j] = temp;
                            }
                    // Sắp giảm dần
                    for (int i = 0; i < leIdx - 1; i++)
                        for (int j = i + 1; j < leIdx; j++)
                            if (leChia3[i] < leChia3[j]) {
                                int temp = leChia3[i]; leChia3[i] = leChia3[j]; leChia3[j] = temp;
                            }
                    int index = 0;
                    for (int i = 0; i < chanIdx; i++) arr[index++] = chanChia3[i];
                    for (int i = 0; i < conLaiIdx; i++) arr[index++] = conLai[i];
                    for (int i = 0; i < leIdx; i++) arr[index++] = leChia3[i];
                    System.out.print("Mảng sau khi sắp xếp: ");
                    for (int i = 0; i < n; i++) System.out.print(arr[i] + " ");
                    System.out.println();
                    break;

                case 8:
                    if (n == -1) {
                        System.out.println("Vui lòng nhập mảng trước");
                        break;
                    }
                    for (int i = 0; i < n - 1; i++)
                        for (int j = i + 1; j < n; j++)
                            if (arr[i] < arr[j]) {
                                int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
                            }
                    System.out.print("Nhập m: ");
                    int m = scanner.nextInt();
                    int i = n - 1;
                    while (i >= 0 && arr[i] < m) {
                        arr[i + 1] = arr[i];
                        i--;
                    }
                    arr[i + 1] = m;
                    n++;
                    System.out.print("Mảng sau khi chèn: ");
                    for (int j = 0; j < n; j++) System.out.print(arr[j] + " ");
                    System.out.println();
                    break;

                case 9:
                    System.out.println("Kết thúc chương trình");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        } while (choice != 9);
    }
}
