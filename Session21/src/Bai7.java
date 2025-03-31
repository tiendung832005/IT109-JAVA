import java.util.Scanner;

public class Bai7 {
    static class TaiKhoan {
        private double soDu;

        private static final double SO_DU_TOI_THIEU = 50000;

        public TaiKhoan(double soDuBanDau) {
            this.soDu = soDuBanDau;
        }

        public void rutTien(double soTienRut) throws Exception {
            if (soTienRut > soDu) {
                throw new Exception("Lỗi: Số tiền rút vượt quá số dư!");
            }

            if ((soDu - soTienRut) < SO_DU_TOI_THIEU) {
                throw new Exception("Lỗi: Tài khoản phải duy trì số dư tối thiểu 50.000 đồng!");
            }

            soDu -= soTienRut;

            System.out.printf("Rút tiền thành công. Số tiền rút: %.0f đồng%n", soTienRut);
            System.out.printf("Số dư còn lại: %.0f đồng%n", soDu);
        }

        public double getSoDu() {
            return soDu;
        }
    }

    public static void main(String[] args) {
        TaiKhoan taiKhoan = new TaiKhoan(1_000_000);

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.printf("Số dư tài khoản: %.0f đồng%n", taiKhoan.getSoDu());

            System.out.print("Nhập số tiền muốn rút: ");

            try {
                double soTienRut = scanner.nextDouble();

                if (soTienRut <= 0) {
                    throw new IllegalArgumentException("Lỗi: Số tiền rút phải là số dương!");
                }

                taiKhoan.rutTien(soTienRut);
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            scanner.close();
        }
    }
}