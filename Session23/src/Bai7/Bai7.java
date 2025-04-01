package Bai7;

public class Bai7 {
    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        Producer producer = new Producer(fibonacci);
        Consumer consumer = new Consumer(fibonacci);

        producer.start();
        consumer.start();
    }
}