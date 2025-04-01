public class Bai4 {

    static class MyThread extends Thread {
        private Thread waitForThread;

        public MyThread(String name) {
            super(name);
        }

        public MyThread(String name, Thread waitForThread) {
            super(name);
            this.waitForThread = waitForThread;
        }

        @Override
        public void run() {
            try {
                if (waitForThread != null) {
                    System.out.println(getName() + " đang đợi " + waitForThread.getName() + " kết thúc...");
                    waitForThread.join();
                }

                if (getName().equals("Thread-1")) {
                    System.out.println(getName() + " bắt đầu in các số từ 1 đến 5:");
                    for (int i = 1; i <= 5; i++) {
                        System.out.println(getName() + ": " + i);
                        // Sleep 1 giây giữa mỗi số
                        Thread.sleep(1000);
                    }
                    System.out.println(getName() + " đã kết thúc!");
                }
                else {
                    System.out.println(getName() + " bắt đầu...");
                    System.out.println(getName() + " đang thực hiện công việc của mình...");
                    // Sleep một chút để giả lập công việc
                    Thread.sleep(2000);
                    System.out.println(getName() + " đã kết thúc");
                }
            } catch (InterruptedException e) {
                System.out.println(getName() + " đã bị ngắt");
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyThread thread1 = new MyThread("Thread-1");

        MyThread thread2 = new MyThread("Thread-2", thread1);
        MyThread thread3 = new MyThread("Thread-3", thread1);

        System.out.println("Bắt đầu chương trình...");
        thread1.start();
        thread2.start();
        thread3.start();

        System.out.println("Tất cả các thread đã được khởi động");
    }
}