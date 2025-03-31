import java.util.Scanner;

public class Bai3 {
    public static void checkAge(int age) throws Exception {
        if (age < 18) {
            throw new Exception("Bạn chưa đủ 18 tuổi");
        }

        System.out.println("Chào mừng bạn");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập tuổi của bạn: ");
            int tuoi = scanner.nextInt();

            checkAge(tuoi);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            scanner.close();
        }
    }
}