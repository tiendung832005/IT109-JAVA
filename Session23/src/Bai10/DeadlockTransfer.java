package Bai10;

public class DeadlockTransfer implements Runnable {
    private final Account fromAccount;
    private final Account toAccount;
    private final double amount;
    private final String threadName;

    public DeadlockTransfer(Account fromAccount, Account toAccount, double amount, String threadName) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        try {
            System.out.println(threadName + ": Đang cố gắng khóa " + fromAccount.getName());
            fromAccount.getLock().lock();
            System.out.println(threadName + ": Đã khóa " + fromAccount.getName());

            Thread.sleep(1000);

            System.out.println(threadName + ": Đang cố gắng khóa " + toAccount.getName());
            toAccount.getLock().lock();
            System.out.println(threadName + ": Đã khóa " + toAccount.getName());

            if (fromAccount.withdraw(amount)) {
                toAccount.deposit(amount);
                System.out.println(threadName + ": Chuyển $" + amount + " từ " +
                        fromAccount.getName() + " sang " + toAccount.getName());
            } else {
                System.out.println(threadName + ": Không đủ tiền để chuyển từ " +
                        fromAccount.getName());
            }

            toAccount.getLock().unlock();
            fromAccount.getLock().unlock();

        } catch (InterruptedException e) {
            System.out.println(threadName + ": Bị ngắt (có thể do deadlock)");
            if (fromAccount.getLock().isHeldByCurrentThread()) {
                fromAccount.getLock().unlock();
            }
        }
    }
}
