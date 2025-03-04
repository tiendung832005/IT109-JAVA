import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập vào 1 số nguyên: ");
        int num;

        do {
            num = scanner.nextInt();
            if(num > 0){
                break;
            }
            System.err.println("Số p là số nguyên dương");
        }while (true);
        int count = 0;
        System.out.printf("Các số hoàn hảo trong khoảng từ 1 đến %d là: \n", num);
        for (int i = 1; i <= num; i++) {
            int sum = 0;
            for(int j = 1; j < i; j++) {
                if(i % j == 0){
                    sum += j;
                }
            }
            if(sum == i){
                System.out.printf("%d\t\n", i);
                count++;
            }
        }
        if(count == 0){
            System.out.println("Không có số hoàn hảo từ 1 đến " + num);
        }
    }
}
