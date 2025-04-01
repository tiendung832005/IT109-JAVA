public class Bai5 {
    static class SharedData {
        private String message;
        private boolean messageAvailable = false;

        public synchronized void writeMessage(String msg) {
            while (messageAvailable) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            message = msg;
            messageAvailable = true;
            System.out.println("Người gửi đã gửi: " + message);

            notify();
        }

        public synchronized String readMessage() {
            // Đợi cho đến khi có tin nhắn
            while (!messageAvailable) {
                try {
                    System.out.println("Người nhận đang đợi tin nhắn...");
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            messageAvailable = false;

            notify();

            return message;
        }
    }

    static class Writer implements Runnable {
        private SharedData sharedData;
        private String[] messages;

        public Writer(SharedData sharedData, String[] messages) {
            this.sharedData = sharedData;
            this.messages = messages;
        }

        @Override
        public void run() {
            for (String message : messages) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                sharedData.writeMessage(message);
            }
        }
    }

    static class Reader implements Runnable {
        private SharedData sharedData;
        private int messageCount;

        public Reader(SharedData sharedData, int messageCount) {
            this.sharedData = sharedData;
            this.messageCount = messageCount;
        }

        @Override
        public void run() {
            for (int i = 0; i < messageCount; i++) {
                String message = sharedData.readMessage();
                System.out.println("Người nhận đã nhận: " + message);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public static void main(String[] args) {
        SharedData sharedData = new SharedData();

        String[] messages = {
                "Chào bạn!",
                "Bạn khỏe không?",
                "Hôm nay thời tiết đẹp nhỉ!",
                "Tạm biệt!"
        };

        Thread readerThread = new Thread(new Reader(sharedData, messages.length));
        readerThread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        Thread writerThread = new Thread(new Writer(sharedData, messages));
        writerThread.start();
    }
}