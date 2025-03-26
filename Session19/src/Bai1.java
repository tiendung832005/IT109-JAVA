import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bai1 {
    public static List<String> filterNonEmptyStrings(List<String> inputList) {
        List<String> nonEmptyStrings = new ArrayList<>();

        for (String str : inputList) {
            if (str != null && !str.trim().isEmpty()) {
                nonEmptyStrings.add(str);
            }
        }

        return nonEmptyStrings;
    }

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Hello", "", "World", "  ", "Java", "");

        List<String> nonEmptyStrings = filterNonEmptyStrings(strings);

        System.out.println("Các chuỗi không rỗng:");
        for (String str : nonEmptyStrings) {
            System.out.println(str);
        }
    }
}