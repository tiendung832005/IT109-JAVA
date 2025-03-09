import java.util.Scanner;

public class TwoArray {
    public static void main(String[] args) {
        /*
        * Viết chương trình thực hiện:
        * 1. Khai báo mảng số nguyên 2 chieeuf gồm n dòng và m cột (n,m nhập từ bàn phím)
        * 2. In menu và thực hiện các chức năng theo menu
        * ********************** MENU ************************
        * 1. Nhập giá trị các phần tử của mảng
        * 2. In giá trị các phần tử của mảng
        * 3. Kiem tra sự tồn tại của 1 giá trị trong mảng
        * 4. Thoát
        * */
        //1. Khai báo mảng số nguyên 2 chiều
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào số dòng của mảng 2 chieu: ");
        int n = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập vào số cột của mảng 2 chiêu: ");
        int m = Integer.parseInt(scanner.nextLine());
        int [][] numbers = new int[n][m];

        do{
            System.out.println("\n********************* MENU ************************");
            System.out.println("1. Nhập giá trị các phần tử của mảng");
            System.out.println("2. In giá trị các phần tử của mảng");
            System.out.println("3. Kiem tra sự tồn tại của 1 giá trị trong mảng");
            System.out.println("4. Thoát");
            System.out.print("Chọn chức năng (1-4): ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    // Nhập giá trị các phần tử của mảng
                    System.out.println("Nhập giá trị cho mảng:");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            System.out.print("numbers[" + i + "][" + j + "]: ");
                            numbers[i][j] = scanner.nextInt();
                        }
                    }
                    break;
                case 2:
                    // In giá trị các phần tử của mảng
                    for (int i = 0; i < numbers.length; i++) {
                        for (int j = 0; j < numbers[i].length; j++) {
                            System.out.print(numbers[i][j] + "\t");
                        }
                        System.out.printf("\n");
                    }
                    break;


            }
        }while(true);
    }
}
