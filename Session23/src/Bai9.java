import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Bai9 {
    public static void main(String[] args) {
        int numberOfThreads = 4;
        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);

        int[] numbers = {10000, 10001, 10002, 10003, 10004, 10005, 10006, 10007, 10008, 10009};

        List<Future<FactorialResult>> futureResults = new ArrayList<>();

        for (int number : numbers) {
            Callable<FactorialResult> task = new FactorialTask(number);
            Future<FactorialResult> future = executor.submit(task);
            futureResults.add(future);
        }

        for (Future<FactorialResult> future : futureResults) {
            try {
                FactorialResult result = future.get();
                System.out.println(result);
            } catch (InterruptedException | ExecutionException e) {
                System.err.println("Lỗi khi tính toán: " + e.getMessage());
            }
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }

    static class FactorialResult {
        private final int number;
        private final BigInteger result;
        private final long timeInMillis;

        public FactorialResult(int number, BigInteger result, long timeInMillis) {
            this.number = number;
            this.result = result;
            this.timeInMillis = timeInMillis;
        }

        @Override
        public String toString() {
            String resultStr = result.toString();
            String firstFive = resultStr.length() >= 5 ? resultStr.substring(0, 5) : resultStr;
            String lastFive = resultStr.length() >= 5 ? resultStr.substring(resultStr.length() - 5) : resultStr;

            return "Số: " + number + "\n" +
                    "5 chữ số đầu: " + firstFive + "\n" +
                    "5 chữ số cuối: " + lastFive + "\n" +
                    "Thời gian: " + timeInMillis + " ms\n";
        }
    }

    static class FactorialTask implements Callable<FactorialResult> {
        private final int number;

        public FactorialTask(int number) {
            this.number = number;
        }

        @Override
        public FactorialResult call() {
            long startTime = System.currentTimeMillis();

            BigInteger result = calculateFactorial(number);

            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;

            return new FactorialResult(number, result, duration);
        }

        private BigInteger calculateFactorial(int n) {
            BigInteger result = BigInteger.ONE;
            for (int i = 2; i <= n; i++) {
                result = result.multiply(BigInteger.valueOf(i));
            }
            return result;
        }
    }
}