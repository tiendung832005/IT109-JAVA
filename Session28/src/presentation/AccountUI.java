package presentation;

import business.service.account.AccountService;
import business.service.account.AccountServiceImp;

import java.util.Scanner;

public class AccountUI {

    public static void displayAccountMenu(Scanner scanner) {
        AccountService accountService = new AccountServiceImp();
        do {
            System.out.println("***************ACCOUNT MENU**************");
            System.out.println("1. Danh sách tài khoản");
            System.out.println("2. Tạo tài khoản");
            System.out.println("3. Cập nhật tài khoản"); //Tên + trạng thái
            System.out.println("4. Xóa tài khoản");//Cập nhật trạng thái là inactive
            System.out.println("5. Chuyển khoản");
            System.out.println("6. Tra cứu số dư tài khoản");
            System.out.println("7. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    break;
                case 5:
                    fundsTransfer(scanner, accountService);
                    break;
                default:
                    System.err.println("Vui lòng chọn từ 1-7");
            }
        } while (true);
    }

    public static void fundsTransfer(Scanner scanner, AccountService accountService) {
        System.out.println("Nhập số tài khoản người gửi:");
        int accSenderId = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên tài khoản người gửi:");
        String accSenderName = scanner.nextLine();
        System.out.println("Nhập số tài khoản người nhận:");
        int accReceiverId = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên tài khoản người nhận:");
        String accReceiverName = scanner.nextLine();
        System.out.println("Nhập số tiền chuyển:");
        double amount = Double.parseDouble(scanner.nextLine());
        int result = accountService.fundsTransfer(accSenderId, accSenderName, accReceiverId, accReceiverName, amount);
        switch (result) {
            case 1:
                System.err.println("Thông tin tài khoản người gửi không chính xác");
                break;
            case 2:
                System.err.println("Thông tin tài khoản người nhận không chính xác");
                break;
            case 3:
                System.err.println("Số dư tài khoản không đủ để chuyển khoản");
                break;
            case 4:
                System.out.println("Chuyển khoản thành công!!!");
                break;
        }
    }
}