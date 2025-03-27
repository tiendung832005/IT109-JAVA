import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Bai1 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        List<Integer> evenNumbers = numbers.stream()
                .filter(number -> number % 2 == 0)
                .collect(Collectors.toList());

        System.out.println("Các số chẵn trong danh sách: ");
        evenNumbers.forEach(System.out::println);

        System.out.println("\nCách in trực tiếp");
        numbers.stream()
                .filter(number -> number % 2 == 0)
                .forEach(System.out::println);
    }
}
