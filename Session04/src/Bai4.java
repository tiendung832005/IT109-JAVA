import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = 0;
        int number;

        while(true){
            System.out.print("Nhập các số nguyên, nhập 0 để dừng: ");
            number = scanner.nextInt();
            if (number == 0) {
                break;
            }
            total += number;
        }

        System.out.println("Tổng các số đã nhập: " + total);
        scanner.close();
        }
    }

