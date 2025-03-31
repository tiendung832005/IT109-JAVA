import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bai6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> danhSachHopLe = new ArrayList<>();

        int soLuongHopLe = 0;
        int soLuongKhongHopLe = 0;

        try {
            System.out.print("Nhập số lượng chuỗi: ");
            int soLuong = scanner.nextInt();
            scanner.nextLine();

            for (int i = 0; i < soLuong; i++) {
                System.out.print("Nhập chuỗi thứ " + (i + 1) + ": ");
                String chuoi = scanner.nextLine();

                try {
                    int soNguyen = Integer.parseInt(chuoi);

                    danhSachHopLe.add(soNguyen);
                    soLuongHopLe++;
                }
                catch (NumberFormatException e) {
                    soLuongKhongHopLe++;
                }
            }

            System.out.println("\nKết quả:");
            System.out.println("Số lượng chuỗi hợp lệ: " + soLuongHopLe);
            System.out.println("Số lượng chuỗi không hợp lệ: " + soLuongKhongHopLe);

            System.out.println("\nDanh sách số nguyên hợp lệ:");
            for (Integer so : danhSachHopLe) {
                System.out.print(so + " ");
            }
        }
        catch (Exception e) {
            System.out.println("Đã xảy ra lỗi: " + e.getMessage());
        }
        finally {
            scanner.close();
        }
    }
}