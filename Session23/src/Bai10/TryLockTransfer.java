package Bai10;

import java.util.concurrent.TimeUnit;

public class TryLockTransfer implements Runnable {
    private final Account fromAccount;
    private final Account toAccount;
    private final double amount;
    private final String threadName;
    private static final int MAX_RETRIES = 5;

    public TryLockTransfer(Account fromAccount, Account toAccount, double amount, String threadName) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        boolean success = false;
        int attemptCount = 0;

        while (!success && attemptCount < MAX_RETRIES) {
            attemptCount++;
            System.out.println(threadName + ": Lần thử " + attemptCount);

            try {
                System.out.println(threadName + ": Đang cố gắng khóa " + fromAccount.getName());
                boolean fromLocked = fromAccount.getLock().tryLock(1000, TimeUnit.MILLISECONDS);

                if (fromLocked) {
                    try {
                        System.out.println(threadName + ": Đã khóa " + fromAccount.getName());

                        Thread.sleep(100);

                        System.out.println(threadName + ": Đang cố gắng khóa " + toAccount.getName());
                        boolean toLocked = toAccount.getLock().tryLock(1000, TimeUnit.MILLISECONDS);

                        if (toLocked) {
                            try {
                                System.out.println(threadName + ": Đã khóa " + toAccount.getName());

                                if (fromAccount.withdraw(amount)) {
                                    toAccount.deposit(amount);
                                    System.out.println(threadName + ": Chuyển $" + amount + " từ " +
                                            fromAccount.getName() + " sang " + toAccount.getName());
                                    success = true;
                                } else {
                                    System.out.println(threadName + ": Không đủ tiền để chuyển từ " +
                                            fromAccount.getName());
                                }
                            } finally {
                                toAccount.getLock().unlock();
                                System.out.println(threadName + ": Đã giải phóng khóa " + toAccount.getName());
                            }
                        } else {
                            System.out.println(threadName + ": Không thể khóa " + toAccount.getName() +
                                    " sau khi chờ timeout. Thử lại sau.");
                            Thread.sleep((long) (Math.random() * 500));
                        }
                    } finally {
                        fromAccount.getLock().unlock();
                        System.out.println(threadName + ": Đã giải phóng khóa " + fromAccount.getName());
                    }
                } else {
                    System.out.println(threadName + ": Không thể khóa " + fromAccount.getName() +
                            " sau khi chờ timeout. Thử lại sau.");
                    Thread.sleep((long) (Math.random() * 500));
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }

        if (!success) {
            System.out.println(threadName + ": Không thể hoàn thành giao dịch sau " + MAX_RETRIES + " lần thử");
        }
    }
}