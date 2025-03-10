import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        while(true){
            System.out.println("Nhập n: ");
            n = scanner.nextInt();
            if(n>0){
                break;
            }
            System.out.println("Kích thước không hợp lệ");
        }
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            System.out.printf("Nhập giá trị cho phần tử thứ %d: ", i+1);
            arr[i] = scanner.nextInt();
        }
        int max = arr[0];
        int min = arr[0];
        for(int i=1; i<n; i++){
            if(arr[i]>max){
                max = arr[i];
            }
            if(arr[i]<min){
                min = arr[i];
            }
        }
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
    }
}
