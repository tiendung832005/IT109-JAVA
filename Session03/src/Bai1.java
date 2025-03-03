import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        System.out.print("Nhập số n: ");
        int n = scanner.nextInt();
        if(n % 2 == 0){
            System.out.println("n là số chẵn");
        } else if (n % 2 == 1){
            System.out.println("n là số lẻ");
        }else{
            System.out.println("n không phải là số chẵn và số lẻ");
        }
    }
}
