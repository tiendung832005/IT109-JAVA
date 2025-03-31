package Bai9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bai9 {
    private static List<BankAccount> accounts = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeAccounts();

        int choice;
        do {
            displayMenu();
            System.out.print("Nhập lựa chọn của bạn: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        depositMoney();
                        break;
                    case 2:
                        withdrawMoney();
                        break;
                    case 3:
                        transferMoney();
                        break;
                    case 4:
                        displayAccounts();
                        break;
                    case 5:
                        System.out.println("Kết thúc chương trình");
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lỗi");
                choice = 0;
            }

            System.out.println();
        } while (choice != 5);

        scanner.close();
    }


    private static void initializeAccounts() {
        accounts.add(new BankAccount("ACC001", 1000000));
        accounts.add(new BankAccount("ACC002", 2000000));
        accounts.add(new BankAccount("ACC003", 3000000));
        System.out.println("Đã khởi tạo " + accounts.size() + " tài khoản.");
    }


    private static void displayMenu() {
        System.out.println("===== MENU GIAO DỊCH NGÂN HÀNG =====");
        System.out.println("1. Gửi tiền");
        System.out.println("2. Rút tiền");
        System.out.println("3. Chuyển tiền");
        System.out.println("4. Hiển thị danh sách tài khoản");
        System.out.println("5. Thoát");
    }


    private static void displayAccounts() {
        System.out.println("===== DANH SÁCH TÀI KHOẢN =====");
        for (BankAccount account : accounts) {
            System.out.println("Tài khoản: " + account.getAccountId() + ", Số dư: " + account.getBalance());
        }
    }


    private static BankAccount findAccount(String accountId) throws AccountNotFoundException {
        for (BankAccount account : accounts) {
            if (account.getAccountId().equals(accountId)) {
                return account;
            }
        }
        throw new AccountNotFoundException("Không tìm thấy tài khoản: " + accountId);
    }


    private static void depositMoney() {
        System.out.println("===== GỬI TIỀN =====");
        System.out.print("Nhập số tài khoản: ");
        String accountId = scanner.nextLine();

        try {
            BankAccount account = findAccount(accountId);
            System.out.print("Nhập số tiền gửi: ");
            double amount = Double.parseDouble(scanner.nextLine());

            account.deposit(amount);

        } catch (AccountNotFoundException e) {
            System.out.println("Lỗi: " + e.getMessage());
        } catch (InvalidAmountException e) {
            System.out.println("Lỗi: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Số tiền không hợp lệ");
        }
    }


    private static void withdrawMoney() {
        System.out.println("===== RÚT TIỀN =====");
        System.out.print("Nhập số tài khoản: ");
        String accountId = scanner.nextLine();

        try {
            BankAccount account = findAccount(accountId);
            System.out.print("Nhập số tiền rút: ");
            double amount = Double.parseDouble(scanner.nextLine());

            account.withdraw(amount);

        } catch (AccountNotFoundException e) {
            System.out.println("Lỗi: " + e.getMessage());
        } catch (InvalidAmountException | InsufficientFundsException e) {
            System.out.println("Lỗi: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Số tiền không hợp lệ");
        }
    }


    private static void transferMoney() {
        System.out.println("===== CHUYỂN TIỀN =====");
        System.out.print("Nhập số tài khoản nguồn: ");
        String sourceAccountId = scanner.nextLine();

        try {
            BankAccount sourceAccount = findAccount(sourceAccountId);

            System.out.print("Nhập số tài khoản đích: ");
            String destAccountId = scanner.nextLine();

            if (sourceAccountId.equals(destAccountId)) {
                System.out.println("Lỗi: Không thể chuyển tiền cho chính mình");
                return;
            }

            BankAccount destAccount = findAccount(destAccountId);

            System.out.print("Nhập số tiền chuyển: ");
            double amount = Double.parseDouble(scanner.nextLine());

            sourceAccount.transfer(destAccount, amount);

        } catch (AccountNotFoundException e) {
            System.out.println("Lỗi: " + e.getMessage());
        } catch (InvalidAmountException | InsufficientFundsException e) {
            System.out.println("Lỗi: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Số tiền không hợp lệ");
        }
    }
}