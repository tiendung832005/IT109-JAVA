public class Bai2 implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
        }
    }
    public static void main(String[] args) {
        Bai2 myRunnable = new Bai2();

        Thread thread = new Thread(myRunnable);

        thread.start();
    }
}