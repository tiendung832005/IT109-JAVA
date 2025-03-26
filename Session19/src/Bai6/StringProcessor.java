package Bai6;

import java.util.List;

public interface StringProcessor {
    String processString(String input);

    default void printList(List<String> list) {
        for (String item : list) {
            System.out.println(item);
        }
    }
}
