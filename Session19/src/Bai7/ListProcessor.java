package Bai7;

import java.util.List;

interface ListProcessor {
    static void printList(List<Integer> list) {
        for (Integer num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    boolean containsNegative(List<Integer> list);
}

