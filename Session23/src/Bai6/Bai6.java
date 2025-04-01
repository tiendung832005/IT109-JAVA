package Bai6;

public class Bai6 {
    public static void main(String[] args) {
        PriorityThread thread1 = new PriorityThread("Thread 1 (MIN_PRIORITY)");
        PriorityThread thread2 = new PriorityThread("Thread 2 (NORM_PRIORITY)");
        PriorityThread thread3 = new PriorityThread("Thread 3 (MAX_PRIORITY)");

        thread1.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.NORM_PRIORITY);
        thread3.setPriority(Thread.MAX_PRIORITY);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
