package Bai10;

public class DeadlockSimulation {
    public static void main(String[] args) {
        Account accountA = new Account(1, "Account A", 1000);
        Account accountB = new Account(2, "Account B", 1000);

        System.out.println("Trạng thái ban đầu:");
        System.out.println(accountA);
        System.out.println(accountB);
        System.out.println();

        System.out.println("=== GIAI ĐOẠN 1: TẠO DEADLOCK ===");
        Thread thread1 = new Thread(new DeadlockTransfer(accountA, accountB, 100, "Thread 1"));
        Thread thread2 = new Thread(new DeadlockTransfer(accountB, accountA, 50, "Thread 2"));
        Thread thread3 = new Thread(new DeadlockTransfer(accountA, accountB, 200, "Thread 3"));

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            Thread.sleep(5000);
            System.out.println("\nDeadlock đã xảy ra! Các thread đang chờ lẫn nhau.");

            thread1.interrupt();
            thread2.interrupt();
            thread3.interrupt();

            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nTrạng thái sau khi xảy ra deadlock:");
        System.out.println(accountA);
        System.out.println(accountB);
        System.out.println();

        accountA = new Account(1, "Account A", 1000);
        accountB = new Account(2, "Account B", 1000);

        System.out.println("=== GIAI ĐOẠN 2a: GIẢI QUYẾT BẰNG ORDERED LOCKS ===");
        System.out.println("Trạng thái ban đầu:");
        System.out.println(accountA);
        System.out.println(accountB);
        System.out.println();

        Thread orderedThread1 = new Thread(new OrderedLockTransfer(accountA, accountB, 100, "Ordered Thread 1"));
        Thread orderedThread2 = new Thread(new OrderedLockTransfer(accountB, accountA, 50, "Ordered Thread 2"));
        Thread orderedThread3 = new Thread(new OrderedLockTransfer(accountA, accountB, 200, "Ordered Thread 3"));

        orderedThread1.start();
        orderedThread2.start();
        orderedThread3.start();

        try {
            orderedThread1.join();
            orderedThread2.join();
            orderedThread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nTrạng thái sau khi sử dụng Ordered Locks:");
        System.out.println(accountA);
        System.out.println(accountB);
        System.out.println();

        accountA = new Account(1, "Account A", 1000);
        accountB = new Account(2, "Account B", 1000);

        System.out.println("=== GIAI ĐOẠN 2b: GIẢI QUYẾT BẰNG TRYLOCK + TIMEOUT ===");
        System.out.println("Trạng thái ban đầu:");
        System.out.println(accountA);
        System.out.println(accountB);
        System.out.println();

        Thread tryLockThread1 = new Thread(new TryLockTransfer(accountA, accountB, 100, "TryLock Thread 1"));
        Thread tryLockThread2 = new Thread(new TryLockTransfer(accountB, accountA, 50, "TryLock Thread 2"));
        Thread tryLockThread3 = new Thread(new TryLockTransfer(accountA, accountB, 200, "TryLock Thread 3"));

        tryLockThread1.start();
        tryLockThread2.start();
        tryLockThread3.start();

        try {
            tryLockThread1.join();
            tryLockThread2.join();
            tryLockThread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nTrạng thái sau khi sử dụng TryLock + Timeout:");
        System.out.println(accountA);
        System.out.println(accountB);
    }
}
