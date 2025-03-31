package Bai9;

class BankAccount {
    private String accountId;
    private double balance;

    public BankAccount() {
        this.accountId = "";
        this.balance = 0.0;
    }

    public BankAccount(String accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Số tiền gửi phải lớn hơn 0");
        }

        this.balance += amount;
        System.out.println("Gửi tiền thành công. Số dư mới: " + this.balance);
    }

    public void withdraw(double amount) throws InvalidAmountException, InsufficientFundsException {
        if (amount <= 0) {
            throw new InvalidAmountException("Số tiền rút phải lớn hơn 0");
        }

        if (amount > this.balance) {
            throw new InsufficientFundsException("Số dư không đủ để thực hiện giao dịch");
        }

        this.balance -= amount;
        System.out.println("Rút tiền thành công. Số dư mới: " + this.balance);
    }

    public void transfer(BankAccount recipient, double amount) throws InvalidAmountException, InsufficientFundsException {
        if (amount <= 0) {
            throw new InvalidAmountException("Số tiền chuyển phải lớn hơn 0");
        }

        if (amount > this.balance) {
            throw new InsufficientFundsException("Số dư không đủ để thực hiện giao dịch");
        }

        this.balance -= amount;
        recipient.balance += amount;

        System.out.println("Chuyển tiền thành công.");
        System.out.println("Số dư tài khoản nguồn [" + this.accountId + "]: " + this.balance);
        System.out.println("Số dư tài khoản đích [" + recipient.accountId + "]: " + recipient.balance);
    }
}
