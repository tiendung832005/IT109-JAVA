import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        System.out.println("Nhap vao so nguyen duong: ");
        int n = scanner.nextInt();
        scanner.close();

        if(n <= 0){
            System.out.println("So nhap vao khong hop le.");
        }else{
            for(int i = 1; i <= 10; i++){
                int total = n * i;
                System.out.println(n + " x " + i + " = " + total);
            }
        }
    }
}
