import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        System.out.print("Nhâp số lượng trong mảng: ");
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        System.out.println("Nhập các giá trị cho mảng: ");

        int countEven = 0;
        for(int i = 0; i < n; i++){
            numbers[i] =  scanner.nextInt();
        }

        for(int num : numbers){
            if(num % 2 == 0){
                countEven++;
            }
        }

        System.out.println("tổng số phần tử chẵn trong mảng là: " +countEven);
        scanner.close();
    }
}
