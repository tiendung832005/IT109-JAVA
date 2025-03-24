import java.util.*;

public class Bai8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập các số nguyên (cách nhau bằng dấu cách):");
        String input = scanner.nextLine();
        String[] numbers = input.trim().split("\\s+");

        int[] arr = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            arr[i] = Integer.parseInt(numbers[i]);
        }

        System.out.println("Nhập số nguyên tổng cần tìm k:");
        int k = scanner.nextInt();

        Set<Pair> pairSet = new HashSet<>();

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == k) {
                    int smaller = Math.min(arr[i], arr[j]);
                    int larger = Math.max(arr[i], arr[j]);
                    pairSet.add(new Pair(smaller, larger));
                }
            }
        }

        List<Pair> pairList = new ArrayList<>(pairSet);

        Collections.sort(pairList);

        if (pairList.isEmpty()) {
            System.out.println("Không có cặp số nào có tổng bằng " + k);
        } else {
            System.out.println("Các cặp số có tổng bằng " + k + ":");
            for (Pair pair : pairList) {
                System.out.println("(" + pair.first + ", " + pair.second + ")");
            }
        }

        scanner.close();
    }

    static class Pair implements Comparable<Pair> {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return first == pair.first && second == pair.second;
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }

        @Override
        public int compareTo(Pair other) {
            if (this.first != other.first) {
                return this.first - other.first;
            }
            return this.second - other.second;
        }
    }
}