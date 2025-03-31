import java.util.Scanner;

public class Bai5 {
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập một số nguyên để kiểm tra: ");

            int soKiemTra = scanner.nextInt();
            if (soKiemTra <= 0) {
                throw new IllegalArgumentException("Vui lòng nhập số nguyên dương lớn hơn 0!");
            }

            if (laSoNguyenTo(soKiemTra)) {
                System.out.println(soKiemTra + " là số nguyên tố.");
            } else {
                System.out.println(soKiemTra + " không phải là số nguyên tố.");
            }
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        catch (Exception e) {
            System.out.println("Lỗi: Vui lòng nhập số nguyên hợp lệ!");
        }
        finally {
            scanner.close();
        }
    }
}