import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhâp số lượng trong mảng: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Nhập các giá trị cho mảng: ");
        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int maxOdd = -1;
        int minOdd = Integer.MAX_VALUE;
        boolean hasOdd = false;

        for(int i = 0; i < n; i++) {
            if(arr[i] > 0 && arr[i] % 2 != 0) {
                if(arr[i] > maxOdd){
                    maxOdd = arr[i];
                }
                if(arr[i] < minOdd){
                    minOdd = arr[i];
                }
                hasOdd = true;
            }
        }

        if(!hasOdd) {
            System.out.println("Không có số lẻ trong mảng");
        }else{
            System.out.println("Giá trị lẻ lớn nhất: " + maxOdd);
            System.out.println("Giá trị lẻ nhỏ nhất: " + minOdd);
        }

        scanner.close();
    }
}
