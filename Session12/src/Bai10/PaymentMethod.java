package Bai10;

abstract class PaymentMethod {
    protected double amount;

    public PaymentMethod(double amount) {
        this.amount = amount;
    }

    public abstract double calculateFee();

    public abstract double processPayment();

    public abstract String processPayment(double amount, String currency);
}

class CreditCard extends PaymentMethod {
    public CreditCard(double amount) {
        super(amount);
    }

    @Override
    public double calculateFee() {
        return amount * 0.02;
    }

    @Override
    public double processPayment() {
        double fee = calculateFee();
        double totalAmount = amount + fee;
        System.out.println("--- Credit Card ---");
        System.out.println("Total Payment (CreditCard): " + totalAmount);
        return totalAmount;
    }

    @Override
    public String processPayment(double amount, String currency) {
        this.amount = amount;
        double totalAmount = processPayment();
        String result = "Processed payment of " + amount + " " + currency + " with total: " + totalAmount + " " + currency;
        System.out.println(result);
        return result;
    }
}


class DebitCard extends PaymentMethod {
    public DebitCard(double amount) {
        super(amount);
    }

    @Override
    public double calculateFee() {
        return amount * 0.01;
    }

    @Override
    public double processPayment() {
        double fee = calculateFee();
        double totalAmount = amount + fee;
        System.out.println("--- Debit Card ---");
        System.out.println("Total Payment (DebitCard): " + totalAmount);
        return totalAmount;
    }

    @Override
    public String processPayment(double amount, String currency) {
        this.amount = amount;
        double totalAmount = processPayment();
        String result = "Processed payment of " + amount + " " + currency + " with total: " + totalAmount + " " + currency;
        System.out.println(result);
        return result;
    }
}

class Cash extends PaymentMethod {
    public Cash(double amount) {
        super(amount);
    }

    @Override
    public double calculateFee() {
        return 0.0;
    }

    @Override
    public double processPayment() {
        double fee = calculateFee();
        double totalAmount = amount + fee;
        System.out.println("--- Cash ---");
        System.out.println("Total Payment (Cash): " + totalAmount);
        return totalAmount;
    }

    @Override
    public String processPayment(double amount, String currency) {
        this.amount = amount;
        double totalAmount = processPayment();
        String result = "Processed payment of " + amount + " " + currency + " with total: " + totalAmount + " " + currency;
        System.out.println(result);
        return result;
    }
}

// Lớp Main để mô phỏng giao dịch thanh toán
class Main {
    public static void main(String[] args) {
        PaymentMethod creditCard = new CreditCard(1000.0);
        PaymentMethod debitCard = new DebitCard(1000.0);
        PaymentMethod cash = new Cash(1000.0);

        creditCard.processPayment(1000.0, "USD");

        debitCard.processPayment(1000.0, "EUR");

        cash.processPayment(1000.0, "JPY");
    }
}
