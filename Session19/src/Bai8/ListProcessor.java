package Bai8;

import java.util.List;
import java.util.function.Predicate;

public interface ListProcessor {
    int sumOddNumbers(List<Integer> list);

    static void printList(List<Integer> list) {
        for (Integer num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    default boolean checkOdd(List<Integer> list) {
        Predicate<Integer> isOdd = num -> num % 2 != 0;

        return list.stream().anyMatch(isOdd);
    }
}
