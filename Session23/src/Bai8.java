public class Bai8 {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            System.out.println("Thread 1: Bắt đầu");

            synchronized (lock1) {
                System.out.println("Thread 1: Đã khóa lock1");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Thread 1: Đang cố gắng khóa lock2");

                synchronized (lock2) {
                    System.out.println("Thread 1: Đã khóa cả lock1 và lock2");
                }
            }

            System.out.println("Thread 1: Đã hoàn thành");
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("Thread 2: Bắt đầu");

            synchronized (lock2) {
                System.out.println("Thread 2: Đã khóa lock2");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Thread 2: Đang cố gắng khóa lock1");

                synchronized (lock1) {
                    System.out.println("Thread 2: Đã khóa cả lock1 và lock2");
                }
            }

            System.out.println("Thread 2: Đã hoàn thành");
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Chương trình đã kết thúc");
    }
}