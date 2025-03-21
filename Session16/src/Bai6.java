import java.util.ArrayList;
import java.util.LinkedHashSet;

public class Bai6 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(2);
        numbers.add(4);
        numbers.add(1);
        numbers.add(5);
        numbers.add(7);
        numbers.add(8);
        numbers.add(9);
        numbers.add(10);
        numbers.add(42);

        System.out.println("Danh sách ban đầu:");
        printList(numbers);

        ArrayList<Integer> uniqueList = removeDuplicates(numbers);

        System.out.println("\nDanh sách sau khi xóa các phần tử trùng lặp:");
        printList(uniqueList);
    }
    private static ArrayList<Integer> removeDuplicates(ArrayList<Integer> list) {
        ArrayList<Integer> result = new ArrayList<>();
        
        for (Integer number : list) {
            if (!result.contains(number)) {
                result.add(number);
            }
        }
        
        return result;

    }

    private static void printList(ArrayList<Integer> list) {
        for (Integer number : list) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}