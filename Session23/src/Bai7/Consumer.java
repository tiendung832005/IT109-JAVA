package Bai7;

class Consumer extends Thread {
    private Fibonacci fibonacci;

    public Consumer(Fibonacci fibonacci) {
        this.fibonacci = fibonacci;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Fibonacci: " + fibonacci.consume());
        }
    }
}
