package Bai7;

class Producer extends Thread {
    private Fibonacci fibonacci;

    public Producer(Fibonacci fibonacci) {
        this.fibonacci = fibonacci;
    }

    @Override
    public void run() {
        int a = 0, b = 1;
        for (int i = 0; i < 10; i++) {
            fibonacci.produce(a);
            int next = a + b;
            a = b;
            b = next;
        }
    }
}
