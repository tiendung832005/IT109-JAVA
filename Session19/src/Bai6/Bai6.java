package Bai6;

import java.util.ArrayList;
import java.util.List;

public class Bai6 {
    public static void main(String[] args) {
        String[] inputStrings = {
                "java",
                "python",
                "javascript",
                "typescript"
        };
        List<String> processedStrings = new ArrayList<>();

        StringProcessor processor = input -> {
            String upperCaseString = input.toUpperCase();

            return upperCaseString + " - TECHNICAL";
        };

        for (String str : inputStrings) {
            processedStrings.add(processor.processString(str));
        }

        System.out.println("Chuỗi đã xử lý:");
        processor.printList(processedStrings);
    }
}
