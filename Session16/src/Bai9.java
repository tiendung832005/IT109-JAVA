import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bai9 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập các số nguyên (cách nhau bởi dấu cách): ");
        String input = scanner.nextLine();

        List<Integer> danhSachDauVao = new ArrayList<>();
        for (String s : input.trim().split("\\s+")) {
            try {
                danhSachDauVao.add(Integer.parseInt(s));
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: '" + s + "' không phải là số nguyên hợp lệ");
            }
        }

        List<Integer> soNguyenTo = new ArrayList<>();
        List<Integer> soChan = new ArrayList<>();
        List<Integer> soLe = new ArrayList<>();

        for (int so : danhSachDauVao) {
            if (laSoNguyenTo(so)) {
                soNguyenTo.add(so);
            } else if (so % 2 == 0) {
                soChan.add(so);
            } else {
                soLe.add(so);
            }
        }

        System.out.println("\nKết quả phân loại:");
        System.out.printf("| %-20s | %-20s |\n", "Danh sách đầu vào", danhSachDauVao);
        System.out.printf("| %-20s | %-20s |\n", "Số nguyên tố", soNguyenTo);
        System.out.printf("| %-20s | %-20s |\n", "Số chẵn", soChan);
        System.out.printf("| %-20s | %-20s |\n", "Số lẻ", soLe);

        scanner.close();
    }
    public static boolean laSoNguyenTo(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}