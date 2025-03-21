import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bai7 {
    public static void main(String[] args) {
        System.out.println(" dữ liệu 1:");
        processDataset(createDataset1());

        System.out.println("\n dữ liệu 2:");
        processDataset(createDataset2());

        System.out.println("\n dữ liệu 3:");
        processDataset(createDataset3());
    }

    private static void processDataset(ArrayList<Integer> numbers) {
        System.out.println("Danh sách đầu vào: " + numbers);

        Map<Integer, Integer> countMap = countOccurrences(numbers);

        List<Integer> uniqueElements = new ArrayList<>();
        Map<Integer, Integer> duplicateElements = new HashMap<>();

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1) {
                uniqueElements.add(entry.getKey());
            } else {
                duplicateElements.put(entry.getKey(), entry.getValue());
            }
        }

        System.out.println("Phần tử xuất hiện đúng 1 lần: " + uniqueElements);

        System.out.println("Phần tử trùng lặp & số lần xuất hiện:");
        for (Map.Entry<Integer, Integer> entry : duplicateElements.entrySet()) {
            System.out.println(entry.getKey() + " xuất hiện " + entry.getValue() + " lần");
        }
    }

    private static Map<Integer, Integer> countOccurrences(ArrayList<Integer> list) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (Integer number : list) {
            countMap.put(number, countMap.getOrDefault(number, 0) + 1);
        }

        return countMap;
    }

    private static ArrayList<Integer> createDataset1() {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1); numbers.add(2); numbers.add(3); numbers.add(4);
        numbers.add(2); numbers.add(5); numbers.add(6); numbers.add(3);
        numbers.add(7); numbers.add(8); numbers.add(9); numbers.add(10);
        numbers.add(1); numbers.add(11); numbers.add(12); numbers.add(13);
        numbers.add(14); numbers.add(3); numbers.add(5); numbers.add(7);
        return numbers;
    }

    private static ArrayList<Integer> createDataset2() {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(10); numbers.add(20); numbers.add(30); numbers.add(40);
        numbers.add(50); numbers.add(60); numbers.add(70); numbers.add(10);
        numbers.add(20); numbers.add(30); numbers.add(80); numbers.add(90);
        numbers.add(100);
        return numbers;
    }

    private static ArrayList<Integer> createDataset3() {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(5); numbers.add(5); numbers.add(5); numbers.add(5);
        numbers.add(6); numbers.add(7); numbers.add(8); numbers.add(9);
        numbers.add(10); numbers.add(11);
        return numbers;
    }
}