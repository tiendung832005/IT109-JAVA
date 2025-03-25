import java.util.*;

public class Bai7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N;

        while (true) {
            System.out.print("Nhập số phần tử của mảng: ");
            N = scanner.nextInt();
            if (N > 0) break;
            System.out.println("Giá trị N không hợp lệ");
        }

        int[] arr = new int[N];
        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < N; i++) {
            System.out.print("Phần tử thứ " + (i + 1) + ": ");
            arr[i] = scanner.nextInt();
        }


        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> frequencyList = new ArrayList<>(frequencyMap.entrySet());
        frequencyList.sort(Comparator.comparingInt(Map.Entry::getValue));

        System.out.println("\nCác phần tử theo số lần xuất hiện tăng dần:");
        for (Map.Entry<Integer, Integer> entry : frequencyList) {
            System.out.println("Giá trị " + entry.getKey() + " xuất hiện " + entry.getValue() + " lần");
        }
    }
}
