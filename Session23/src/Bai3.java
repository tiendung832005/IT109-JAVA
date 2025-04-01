public class Bai3 {
    static class SharedResource {
        public synchronized void printAlphabet(String threadName) {
            System.out.println(threadName + " bắt đầu in bảng chữ cái:");
            for (char c = 'A'; c <= 'Z'; c++) {
                System.out.println(threadName + ": " + c);

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(threadName + " đã hoàn thành");
        }
    }

    static class AlphabetThread extends Thread {
        private SharedResource sharedResource;

        public AlphabetThread(String name, SharedResource sharedResource) {
            super(name);
            this.sharedResource = sharedResource;
        }

        @Override
        public void run() {
            sharedResource.printAlphabet(getName());
        }
    }

    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        AlphabetThread thread1 = new AlphabetThread("Thread-1", sharedResource);
        AlphabetThread thread2 = new AlphabetThread("Thread-2", sharedResource);

        thread1.start();
        thread2.start();
    }
}