import java.util.Scanner;

public class Practice02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        System.out.print("Nhập số hàng n: ");
        n = scanner.nextInt();
        System.out.print("Nhập số cột m: ");
        m = scanner.nextInt();
        int[][] matrix = new int[n][m];
        int choice;

        do {
            System.out.println("\n************** MENU **************");
            System.out.println("1. Nhập giá trị các phần tử của mảng");
            System.out.println("2. In giá trị các phần tử trong mảng theo ma trận");
            System.out.println("3. Đếm số phần tử chia hết cho 2 và 3");
            System.out.println("4. In phần tử và tổng đường biên, chéo chính, chéo phụ");
            System.out.println("5. Sắp xếp cột tăng dần");
            System.out.println("6. In các số nguyên tố");
            System.out.println("7. Sắp xếp đường chéo chính giảm dần");
            System.out.println("8. Chèn mảng vào dòng chỉ định");
            System.out.println("9. Thoát");
            System.out.print("Nhập lựa chọn: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Nhập các phần tử của mảng:");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            System.out.print("matrix[" + i + "][" + j + "]: ");
                            matrix[i][j] = scanner.nextInt();
                        }
                    }
                    break;

                case 2:
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            System.out.print(matrix[i][j] + " ");
                        }
                        System.out.println();
                    }
                    break;

                case 3:
                    int count = 0;
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            if (matrix[i][j] % 2 == 0 && matrix[i][j] % 3 == 0) {
                                count++;
                            }
                        }
                    }
                    System.out.println("Số phần tử chia hết cho 2 và 3: " + count);
                    break;

                case 4:
                    int sum = 0;
                    System.out.println("Các phần tử ở biên, chéo chính và chéo phụ:");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            if (i == 0 || i == n - 1 || j == 0 || j == m - 1 || i == j || i + j == n - 1) {
                                System.out.print(matrix[i][j] + " ");
                                sum += matrix[i][j];
                            }
                        }
                    }
                    System.out.println("\nTổng các phần tử: " + sum);
                    break;

                case 5:
                    for (int j = 0; j < m; j++) {
                        for (int i = 0; i < n - 1; i++) {
                            for (int k = i + 1; k < n; k++) {
                                if (matrix[i][j] > matrix[k][j]) {
                                    int temp = matrix[i][j];
                                    matrix[i][j] = matrix[k][j];
                                    matrix[k][j] = temp;
                                }
                            }
                        }
                    }
                    System.out.println("Mảng sau khi sắp xếp các cột tăng dần:");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            System.out.print(matrix[i][j] + " ");
                        }
                        System.out.println();
                    }
                    break;

                case 6:
                    System.out.print("Các số nguyên tố trong mảng: ");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            int num = matrix[i][j];
                            if (num >= 2) {
                                int check = 1;
                                for (int k = 2; k <= num / 2; k++) {
                                    if (num % k == 0) {
                                        check = 0;
                                        break;
                                    }
                                }
                                if (check == 1) {
                                    System.out.print(num + " ");
                                }
                            }
                        }
                    }
                    System.out.println();
                    break;

                case 7:
                    int len = (n < m) ? n : m;
                    int[] diagonal = new int[len];
                    for (int i = 0; i < len; i++) {
                        diagonal[i] = matrix[i][i];
                    }
                    for (int i = 1; i < len; i++) {
                        int key = diagonal[i];
                        int j = i - 1;
                        while (j >= 0 && diagonal[j] < key) {
                            diagonal[j + 1] = diagonal[j];
                            j--;
                        }
                        diagonal[j + 1] = key;
                    }
                    for (int i = 0; i < len; i++) {
                        matrix[i][i] = diagonal[i];
                    }
                    System.out.println("Mảng sau khi sắp xếp đường chéo chính giảm dần:");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            System.out.print(matrix[i][j] + " ");
                        }
                        System.out.println();
                    }
                    break;

                case 8:
                    System.out.print("Nhập vị trí dòng cần chèn: ");
                    int pos = scanner.nextInt();
                    if (pos < 0 || pos > n) {
                        System.out.println("Vị trí không hợp lệ");
                        break;
                    }
                    int[] newRow = new int[m];
                    System.out.println("Nhập các phần tử của dòng mới:");
                    for (int i = 0; i < m; i++) {
                        System.out.print("newRow[" + i + "]: ");
                        newRow[i] = scanner.nextInt();
                    }
                    int[][] newMatrix = new int[n + 1][m];
                    for (int i = 0; i < pos; i++) {
                        for (int j = 0; j < m; j++) {
                            newMatrix[i][j] = matrix[i][j];
                        }
                    }
                    for (int j = 0; j < m; j++) {
                        newMatrix[pos][j] = newRow[j];
                    }
                    for (int i = pos + 1; i <= n; i++) {
                        for (int j = 0; j < m; j++) {
                            newMatrix[i][j] = matrix[i - 1][j];
                        }
                    }
                    matrix = newMatrix;
                    n++;
                    System.out.println("Mảng sau khi chèn:");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            System.out.print(matrix[i][j] + " ");
                        }
                        System.out.println();
                    }
                    break;

                case 9:
                    System.out.println("Thoát chương trình");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        } while (choice != 9);
    }
}
