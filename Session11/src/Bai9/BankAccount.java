package Bai9;

public abstract class BankAccount {
    protected String accountNumber;
    protected double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public abstract void withdraw(double amount);
    public abstract void deposit(double amount);
    public abstract void displayBalance();
}
class SavingAccount extends BankAccount {

    public SavingAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Rút " + amount + " từ tài khoản tiết kiệm thành công");
        } else {
            System.out.println("Không đủ số dư để rút " + amount + " từ tài khoản tiết kiệm");
        }
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Nạp " + amount + " vào tài khoản tiết kiệm thành công");
    }

    @Override
    public void displayBalance() {
        System.out.println("Số dư tài khoản tiết kiệm " + accountNumber + ": " + balance);
    }
}
class CheckingAccount extends BankAccount {

    public CheckingAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void withdraw(double amount) {
        balance -= amount;  // Cho phép số dư âm
        System.out.println("Rút " + amount + " từ tài khoản vãng lai thành công");
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Nạp " + amount + " vào tài khoản vãng lai thành công");
    }

    @Override
    public void displayBalance() {
        System.out.println("Số dư tài khoản vãng lai " + accountNumber + ": " + balance);
    }
}
class Bank {
    private BankAccount[] accounts;
    private int count;

    public Bank() {
        accounts = new BankAccount[10];  // Tối đa 10 tài khoản
        count = 0;
    }

    public void addAccount(BankAccount account) {
        if (count < accounts.length) {
            accounts[count] = account;
            count++;
            System.out.println("Thêm tài khoản " + account.accountNumber + " thành công");
        } else {
            System.out.println("Ngân hàng đã đầy, không thể thêm tài khoản mới");
        }
    }

    public void displayBalance() {
        System.out.println("\nDanh sách số dư các tài khoản");
        for (int i = 0; i < count; i++) {
            accounts[i].displayBalance();
        }
    }
}
class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();


        SavingAccount savingAccount1 = new SavingAccount("SA001", 5000);
        CheckingAccount checkingAccount1 = new CheckingAccount("CA001", 2000);

        bank.addAccount(savingAccount1);
        bank.addAccount(checkingAccount1);


        savingAccount1.deposit(1000);
        savingAccount1.withdraw(2000);
        savingAccount1.withdraw(5000);

        checkingAccount1.deposit(500);
        checkingAccount1.withdraw(3000);

        bank.displayBalance();
    }
}

