package Bai8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Bai8 {
    public static void main(String[] args) {
        ListProcessor processor = new ListProcessorImpl();

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);

        System.out.println("Danh sách ban đầu:");
        ListProcessor.printList(numbers);

        System.out.println("\nDanh sách có số lẻ: " + processor.checkOdd(numbers));

        List<Integer> oddNumbers = new ArrayList<>();
        for (Integer num : numbers) {
            if (num % 2 != 0) {
                oddNumbers.add(num);
            }
        }
        System.out.println("\nCác số lẻ:");
        ListProcessor.printList(oddNumbers);

        int sumOdd = processor.sumOddNumbers(numbers);
        System.out.println("\nTổng các số lẻ: " + sumOdd);
    }
}