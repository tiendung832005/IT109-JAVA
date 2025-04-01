package Bai10;

public class OrderedLockTransfer implements Runnable {
    private final Account fromAccount;
    private final Account toAccount;
    private final double amount;
    private final String threadName;

    public OrderedLockTransfer(Account fromAccount, Account toAccount, double amount, String threadName) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        try {
            Account firstLock, secondLock;
            if (fromAccount.getId() < toAccount.getId()) {
                firstLock = fromAccount;
                secondLock = toAccount;
            } else {
                firstLock = toAccount;
                secondLock = fromAccount;
            }

            System.out.println(threadName + ": Đang cố gắng khóa " + firstLock.getName());
            firstLock.getLock().lock();
            System.out.println(threadName + ": Đã khóa " + firstLock.getName());

            Thread.sleep(200);

            System.out.println(threadName + ": Đang cố gắng khóa " + secondLock.getName());
            secondLock.getLock().lock();
            System.out.println(threadName + ": Đã khóa " + secondLock.getName());

            if (fromAccount.withdraw(amount)) {
                toAccount.deposit(amount);
                System.out.println(threadName + ": Chuyển $" + amount + " từ " +
                        fromAccount.getName() + " sang " + toAccount.getName());
            } else {
                System.out.println(threadName + ": Không đủ tiền để chuyển từ " +
                        fromAccount.getName());
            }

            secondLock.getLock().unlock();
            firstLock.getLock().unlock();

        } catch (InterruptedException e) {
            e.printStackTrace();
            if (fromAccount.getLock().isHeldByCurrentThread()) {
                fromAccount.getLock().unlock();
            }
            if (toAccount.getLock().isHeldByCurrentThread()) {
                toAccount.getLock().unlock();
            }
        }
    }
}

