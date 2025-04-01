package Bai7;

class Fibonacci {
    private int sharedValue;
    private boolean hasNewValue = false;

    public synchronized void produce(int value) {
        while (hasNewValue) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        sharedValue = value;
        hasNewValue = true;
        notify();
    }

    public synchronized int consume() {
        while (!hasNewValue) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        hasNewValue = false;
        notify();
        return sharedValue;
    }
}
