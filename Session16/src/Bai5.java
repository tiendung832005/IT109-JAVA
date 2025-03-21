import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Bai5 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(2);
        numbers.add(4);
        numbers.add(1);
        numbers.add(5);
        numbers.add(3);
        numbers.add(3);
        numbers.add(3);
        numbers.add(3);

        System.out.println("Danh sách các số nguyên:");
        for (Integer num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();
        Map<Integer, Integer> occurrences = countOccurrences(numbers);

        System.out.println("\nSố lần xuất hiện của từng phần tử:");
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            System.out.println("Số " + entry.getKey() + " xuất hiện " + entry.getValue() + " lần");
        }
    }

    private static Map<Integer, Integer> countOccurrences(ArrayList<Integer> list) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (Integer number : list) {
            if (countMap.containsKey(number)) {
                countMap.put(number, countMap.get(number) + 1);
            }
            else {
                countMap.put(number, 1);
            }
        }
        return countMap;
    }
}