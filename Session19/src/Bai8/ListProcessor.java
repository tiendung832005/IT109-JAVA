package Bai8;

import java.util.List;
import java.util.function.Predicate;


interface ListProcessor {
    static void printList(List<Integer> list) {
        for (Integer num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }


    boolean checkOdd(List<Integer> list);

    int sumOddNumbers(List<Integer> list);
}

