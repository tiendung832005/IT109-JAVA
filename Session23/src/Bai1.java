public class Bai1 extends Thread {
    public Bai1(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Thread đang chạy: " + getName());
    }

    public static void main(String[] args) {
        // Tạo hai đối tượng thread
        Bai1 thread1 = new Bai1("Thread-1");
        Bai1 thread2 = new Bai1("Thread-2");

        // Khởi chạy hai thread
        thread1.start();
        thread2.start();
    }
}