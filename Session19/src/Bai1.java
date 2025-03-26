import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.Arrays;

public class Bai1 {
    public static List<String> filterNonEmptyStrings(List<String> inputList) {
        Predicate<String> nonEmptyPredicate = str -> !str.isEmpty();

        return inputList.stream()
                .filter(nonEmptyPredicate)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Hello", "", "World", "  ", "Java", "");

        List<String> nonEmptyStrings = filterNonEmptyStrings(strings);

        System.out.println("Các chuỗi không rỗng:");
        nonEmptyStrings.forEach(System.out::println);
    }
}