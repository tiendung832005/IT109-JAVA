import java.util.Scanner;

public class Bai10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder strBuilder = new StringBuilder();

        System.out.print("Nhập chuỗi ban đầu: ");
        strBuilder.append(scanner.nextLine());

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Đảo ngược chuỗi");
            System.out.println("2. Chèn chuỗi vào vị trí bất kỳ");
            System.out.println("3. Xóa một đoạn trong chuỗi");
            System.out.println("4. Thay thế một đoạn trong chuỗi");
            System.out.println("5. Chuyển đổi toàn bộ chuỗi thành chữ hoa/chữ thường");
            System.out.println("6. Thoát chương trình");
            System.out.print("Chọn chức năng: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    strBuilder.reverse();
                    System.out.println("Chuỗi sau khi đảo ngược: " + strBuilder.toString());

                    break;

                case 2:
                    System.out.print("Nhập chuỗi cần chèn: ");
                    String insertStr = scanner.nextLine();
                    System.out.print("Nhập vị trí cần chèn" + strBuilder.length() );
                    int insertPos = scanner.nextInt();
                    scanner.nextLine();
                    if (insertPos >= 0 && insertPos <= strBuilder.length()) {
                        strBuilder.insert(insertPos, insertStr);
                        System.out.println("Chuỗi sau khi chèn: " + strBuilder.toString());
                    } else {
                        System.out.println("Vị trí chèn không hợp lệ");
                    }

                    break;

                case 3:

                    System.out.print("Nhập vị trí bắt đầu xóa " + (strBuilder.length() - 1));
                    int startDel = scanner.nextInt();
                    System.out.print("Nhập vị trí kết thúc xóa (lớn hơn vị trí bắt đầu " + strBuilder.length());
                    int endDel = scanner.nextInt();
                    scanner.nextLine();

                    if (startDel >= 0 && endDel <= strBuilder.length() && startDel < endDel) {
                        strBuilder.delete(startDel, endDel);
                        System.out.println("Chuỗi sau khi xóa: " + strBuilder.toString());
                    } else {
                        System.out.println("Vị trí xóa không hợp lệ");
                    }

                    break;

                case 4:
                    System.out.print("Nhập vị trí bắt đầu thay thế " + (strBuilder.length() - 1));
                    int startRep = scanner.nextInt();
                    System.out.print("Nhập vị trí kết thúc thay thế " + strBuilder.length());
                    int endRep = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Nhập chuỗi thay thế: ");
                    String replaceStr = scanner.nextLine();

                    if (startRep >= 0 && endRep <= strBuilder.length() && startRep < endRep) {
                        strBuilder.replace(startRep, endRep, replaceStr);
                        System.out.println("Chuỗi sau khi thay thế: " + strBuilder.toString());
                    } else {
                        System.out.println("Vị trí thay thế không hợp lệ");
                    }

                    break;

                case 5:
                    System.out.println("1. Chuyển thành chữ hoa");
                    System.out.println("2. Chuyển thành chữ thường");
                    System.out.print("Chọn (1 hoặc 2): ");
                    int convertChoice = scanner.nextInt();
                    scanner.nextLine();

                    if (convertChoice == 1) {
                        String upperStr = strBuilder.toString().toUpperCase();
                        strBuilder.setLength(0);
                        strBuilder.append(upperStr);
                        System.out.println("Chuỗi sau khi chuyển thành chữ hoa: " + strBuilder.toString());
                    } else if (convertChoice == 2) {
                        String lowerStr = strBuilder.toString().toLowerCase();
                        strBuilder.setLength(0);
                        strBuilder.append(lowerStr);
                        System.out.println("Chuỗi sau khi chuyển thành chữ thường: " + strBuilder.toString());
                    } else {
                        System.out.println("Lựa chọn không hợp lệ");
                    }

                    break;

                case 6:
                    System.out.println("Thoát chương trình");
                    scanner.close();
                    return;

                default:
                    System.out.println("Chức năng không hợp lệ");
                    break;
            }
        }while(true);
    }
}
