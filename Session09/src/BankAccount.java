// Bai8
public class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("Nạp thành công %.2f vào tài khoản %s\n", amount, accountNumber);
        } else {
            System.out.println("Số tiền nạp không hợp lệ");
        }
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Số dư không đủ để rút tiền");
        } else if (amount <= 0) {
            System.out.println("Số tiền rút phải lớn hơn 0");
        } else {
            balance -= amount;
            System.out.printf("Rút thành công %.2f từ tài khoản %s\n", amount, accountNumber);
        }
    }

    public void transfer(BankAccount recipient, double amount) {
        if (amount > balance) {
            System.out.println("Số dư không đủ để chuyển tiền");
        } else if (amount <= 0) {
            System.out.println("Số tiền chuyển phải lớn hơn 0");
        } else {
            balance -= amount;
            recipient.balance += amount;
            System.out.printf("Chuyển thành công %.2f từ tài khoản %s sang tài khoản %s\n",
                    amount, accountNumber, recipient.accountNumber);
        }
    }

    public void display() {
        System.out.println("----- Thông tin tài khoản -----");
        System.out.println("Số tài khoản: " + accountNumber);
        System.out.println("Chủ tài khoản: " + accountHolder);
        System.out.printf("Số dư hiện tại: %.2f\n", balance);
    }
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("686868", "Nguyen Van A", 5000);
        BankAccount acc2 = new BankAccount("123456", "Tran Thi B", 3000);

        acc1.display();
        acc2.display();

        System.out.println("\nNạp tiền vào tài khoản 686868 ");
        acc1.deposit(2000);
        acc1.display();

        System.out.println("\n Rút tiền từ tài khoản 123456");
        acc2.withdraw(1000);
        acc2.display();

        System.out.println("\n Chuyển tiền từ tài khoản 686868 sang 123456 ");
        acc1.transfer(acc2, 1500);
        acc1.display();
        acc2.display();

        System.out.println("\n Thử rút tiền vượt quá số dư từ tài khoản 123456");
        acc2.withdraw(10000);
        acc2.display();
    }
}

