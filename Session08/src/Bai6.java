import java.util.Scanner;

public class Bai6 {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = "";
        int n;
        int[] arr = null;
        while (true) {
            System.out.print("===== MENU CHÍNH =====\n" +
                    "1. Xử lý chuỗi\n" +
                    "2. Xử lý số nguyên\n" +
                    "3. Thoát chương trình\n" +
                    "Chọn chức năng (1-3): ");
            int choice1 = scanner.nextInt();
            scanner.nextLine();
            if (choice1 == 1) {
                while (true) {
                    System.out.print("===== MENU XỬ LÝ CHUỖI =====\n" +
                            "1. Nhập chuỗi\n" +
                            "2. Loại bỏ khoảng trắng thừa trong chuỗi\n" +
                            "3. Đếm số lần xuất hiện của từng ký tự\n" +
                            "4. Chuyển đổi chuỗi thành dạng chuẩn\n" +
                            "5. Quay lại menu chính\n" +
                            "Chọn chức năng (1-5): ");
                    int choice = scanner.nextInt();
                    scanner.nextLine();
                    switch (choice) {
                        case 1:
                            System.out.print("Nhập chuỗi: ");
                            str = scanner.nextLine();
                            break;
                        case 2:
                            if (str.isEmpty()) {
                                System.out.println("Bạn cần nhập chuỗi trước");
                                break;
                            }
                            str = str.trim().replaceAll("\\s+", " ");
                            System.out.println("Chuỗi sau khi loại bỏ khoảng trắng thừa: " + str);
                            break;
                        case 3:
                            if (str.isEmpty()) {
                                System.out.println("Bạn cần nhập chuỗi trước");
                                break;
                            }
                            int[] freq = new int[256];
                            for (char c : str.toCharArray()) {
                                freq[c]++;
                            }
                            System.out.println("Số lần xuất hiện của từng ký tự:");
                            for (int i = 0; i < 256; i++) {
                                if (freq[i] > 0) {
                                    System.out.println((char) i + ": " + freq[i]);
                                }
                            }
                            break;
                        case 4:
                            if (str.isEmpty()) {
                                System.out.println("Bạn cần nhập chuỗi trước");
                                break;
                            }
                            String[] words = str.toLowerCase().trim().split("\\s+");
                            StringBuilder formattedStr = new StringBuilder();
                            for (String word : words) {
                                formattedStr.append(Character.toUpperCase(word.charAt(0)))
                                        .append(word.substring(1)).append(" ");
                            }
                            str = formattedStr.toString().trim();
                            System.out.println("Chuỗi sau khi chuẩn hóa: " + str);
                            break;
                        case 5:
                            System.out.println("Quay lại menu chính");
                            break;
                        default:
                            System.out.println("Vui lòng chọn đúng");
                            continue;
                    }
                    if (choice == 5) break;
                }
            } else if (choice1 == 2) {
                while (true) {
                    System.out.print("===== MENU XỬ LÝ MẢNG SỐ NGUYÊN =====\n" +
                            "1. Nhập mảng số nguyên\n" +
                            "2. Tìm số nguyên tố lớn nhất trong mảng\n" +
                            "3. Đếm số phần tử có chữ số đầu tiên là số lẻ\n" +
                            "4. Kiểm tra mảng có phải là mảng đối xứng không\n" +
                            "5. Quay lại menu chính\n" +
                            "Chọn chức năng (1-5): ");
                    int choice2 = scanner.nextInt();
                    switch (choice2) {
                        case 1:
                            System.out.print("Nhập n cho mảng: ");
                            n = scanner.nextInt();
                            arr = new int[n];
                            for (int i = 0; i < n; i++) {
                                System.out.printf("Nhập arr[%d]: ", i);
                                arr[i] = scanner.nextInt();
                            }
                            break;
                        case 2:
                            if (arr == null) {
                                System.out.println("Bạn cần nhập mảng trước");
                                break;
                            }
                            int maxPrime = -1;
                            for (int num : arr) {
                                // Kiểm tra số nguyên tố không dùng hàm
                                if (num >= 2) {
                                    boolean isPrime = true;
                                    for (int i = 2; i * i <= num; i++) {
                                        if (num % i == 0) {
                                            isPrime = false;
                                            break;
                                        }
                                    }
                                    if (isPrime && num > maxPrime) {
                                        maxPrime = num;
                                    }
                                }
                            }
                            if (maxPrime == -1) {
                                System.out.println("Không có số nguyên tố trong mảng.");
                            } else {
                                System.out.println("Số nguyên tố lớn nhất trong mảng: " + maxPrime);
                            }
                            break;
                        case 3:
                            if (arr == null) {
                                System.out.println("Bạn cần nhập mảng trước");
                                break;
                            }
                            int count = 0;
                            for (int num : arr) {
                                int temp = Math.abs(num);
                                while (temp >= 10) {
                                    temp /= 10;
                                }
                                if (temp % 2 != 0) {
                                    count++;
                                }
                            }
                            System.out.println("Số phần tử có chữ số đầu tiên lẻ là: " + count);
                            break;
                        case 4:
                            if (arr == null) {
                                System.out.println("Bạn cần nhập mảng trước");
                                break;
                            }
                            boolean isSymmetric = true;
                            for (int i = 0; i < arr.length / 2; i++) {
                                if (arr[i] != arr[arr.length - i - 1]) {
                                    isSymmetric = false;
                                    break;
                                }
                            }
                            System.out.println(isSymmetric ? "Là mảng đối xứng" : "Không phải là mảng đối xứng");
                            break;
                        case 5:
                            System.out.println("Quay lại menu chính");
                            break;
                        default:
                            System.out.println("Vui lòng chọn đúng");
                            continue;
                    }
                    if (choice2 == 5) break;
                }
            } else if (choice1 == 3) {
                System.out.println("Thoát chương trình");
                scanner.close();
                System.exit(0);
            } else {
                System.out.println("Vui lòng chọn đúng");
            }
        }
    }
}
