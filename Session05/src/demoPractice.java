import java.util.Scanner;

public class demoPractice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhap vao so mang cua ma tran:");
        int n = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhap vao so cot cua ma tran");
        int m = Integer.parseInt(scanner.nextLine());
        int [][] matrix = new int[n][m];

        do{
            System.out.println("*******************MENU***********************");
            System.out.println("1. Nhap gia tri cac phan tu cua mang");
            System.out.println("2. In giá trị các phần tử trong mảng theo ma trận");
            System.out.println("3. Đếm số phần tử chia hết cho 2 và 3");
            System.out.println("4. In phần tử và tổng đường biên, chéo chính, chéo phụ");
            System.out.println("5. Sắp xếp cột tăng dần");
            System.out.println("6. In các số nguyên tố");
            System.out.println("7. Sắp xếp đường chéo chính giảm dần");
            System.out.println("8. Chèn mảng vào dòng chỉ định");
            System.out.println("9. Thoát");
            System.out.print("Nhập lựa chọn: ");
            int choice = scanner.nextInt();

            switch(choice){
                case 1:
                    for(int i = 0;i < n;i++){
                        for(int j=0;j<m;j++){
                            System.out.print("Nhap gia tri cua ma tran["+i+"]["+j+"]: ");
                            matrix[i][j] = Integer.parseInt(scanner.nextLine());

                        }
                    }
                    break;

                case 2:

                    break;
            }
        }while(true);
    }
}
