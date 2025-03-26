package Bai7;

import java.util.ArrayList;
import java.util.List;

public class Bai7 {
    public static void main(String[] args) {
        ListProcessor processor = new ListProcessorImpl();

        List<Integer> positiveList = new ArrayList<>();
        positiveList.add(1);
        positiveList.add(2);
        positiveList.add(3);

        List<Integer> mixedList = new ArrayList<>();
        mixedList.add(1);
        mixedList.add(-2);
        mixedList.add(3);

        System.out.println("Danh sách positive:");
        ListProcessor.printList(positiveList);
        System.out.println("Danh sách Negative: " + processor.containsNegative(positiveList));

        System.out.println("\nDanh sách hỗn hợp:");
        ListProcessor.printList(mixedList);
        System.out.println("Danh sách Negative: " + processor.containsNegative(mixedList));
    }
}
