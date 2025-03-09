import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập chuỗi văn bản: ");
        String a = scanner.nextLine();
        System.out.println("chuỗi cần tìm: ");
        String b = scanner.nextLine();

        int index = a.indexOf(b);
        if(index==-1){
            System.out.printf("Không tìm thấy %s trong chuỗi", b);
            return;
        }
        System.out.printf("Từ %s xuất hiện tại vị trí %d trong chuỗi", b, index);
        scanner.close();
    }
    }

