import java.util.Scanner;

public class demo {
    public static void main(String[] args) {
            int[] arr = new int[100];
            Scanner sc = new Scanner(System.in);
            int curentIndex  = 0;
            do{
                System.out.println("****************MENU*****************");
                System.out.println("1. nhap vao gia tri cac phan tu");
                System.out.println("2. In ra cac phan tu");
                System.out.println("3. Tinh tong cac phan tu");
                System.out.println("4. In ra cac phan tu chia het cho 3 va tinh tong");
                System.out.println("5. In ra cac phan tu la so nguyen to va tinh tong");
                System.out.println("nhap lua chon");
                int choice = sc.nextInt();
                switch(choice){
                    case 1:
                        System.out.println("nhap so phan tu can nhap");
                        int n = Integer.parseInt(sc.nextLine());

                        for (int i = curentIndex; i < n; i++) {
                            arr[i] = Integer.parseInt(sc.nextLine());
                            curentIndex++;
                        }
                        break;
                    case 2:
                        for (int i = 0; i < arr.length; i++) {
                            System.out.println(arr[i]);
                        }
                        break;
                    case 3:
                        int sum = 0;
                        for (int i = 0; i < arr.length; i++) {
                            sum += arr[i];
                        }
                        System.out.printf("tong cac phan tu %d",sum);
                        break;
                    case 4:
                        //In các phần tử chia hết cho 3 và tính tổng
                        int sumDiv3 = 0;
                        System.out.print("Các phần tử chia hết cho 3: ");
                        for (int i = 0; i < curentIndex; i++) {
                            if (arr[i] % 3 == 0) {
                                System.out.print(arr[i] + " ");
                                sumDiv3 += arr[i];
                            }
                        }
                        System.out.println("\nTổng các phần tử chia hết cho 3: " + sumDiv3);
                        break;
                    case 5:

                        break;
                    case 6:
                        break;
                }

            }while(true);
    }
}
