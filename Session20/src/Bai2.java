import java.util.Arrays;
import java.util.List;

public class Bai2 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        int oddNumbersSum = numbers.stream()
                .filter(num -> num % 2 == 0)
                .reduce(0, (a,b) -> a + b);

        System.out.println("Tổng các số lẻ:" +oddNumbersSum);

        System.out.println("\nCác số lẻ trong danh sách:");
        numbers.stream()
                .filter(num -> num % 2 != 0)
                .forEach(System.out::println);
    }
}
