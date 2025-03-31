import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Mảng hiện tại:");
            for (int i = 0; i < arr.length; i++) {
                System.out.println("Chỉ số " + i + ": " + arr[i]);
            }

            System.out.print("\nNhập chỉ số phần tử muốn lấy (0-" + (arr.length - 1) + "): ");
            int chiSo = scanner.nextInt();

            int giaTriPhanTu = arr[chiSo];

            System.out.println("Giá trị tại chỉ số " + chiSo + " là: " + giaTriPhanTu);
        }
        catch (ArrayIndexOutOfBoundsException e) {

            System.out.println("Lỗi: Chỉ số không hợp lệ Vui lòng nhập chỉ số từ 0 đến " + (arr.length - 1));
        }
        catch (Exception e) {
            System.out.println("Lỗi: Vui lòng nhập số nguyên hợp lệ");
        }
        finally {
            scanner.close();
        }
    }
}