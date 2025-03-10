import java.util.Scanner;

public class Bai2 {
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
        boolean check=false;
        int sum=0;
        for(int i=0; i<n; i++){
            if(arr[i]%3==0){
                check=true;
                sum+=arr[i];
            }
        }
        if(!check){
            System.out.println("Không có số chia hết cho 3");
            return;
        }
        System.out.println("Tổng số chia hết cho 3: "+sum);
    }
}
