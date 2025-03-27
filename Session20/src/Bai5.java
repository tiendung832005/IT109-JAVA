import java.util.List;
import java.util.Optional;

public class Bai5 {
    public static void main(String[] args) {
        List<Integer> normalList = List.of(10, 5, 8, 20, 7);
        List<Integer> singleElementList = List.of(10);
        List<Integer> allSameList = List.of(10, 10, 10);

        findSecondLargest(normalList);
        findSecondLargest(singleElementList);
        findSecondLargest(allSameList);
    }

    private static void findSecondLargest(List<Integer> numbers) {
        Optional<Integer> secondLargest = numbers.stream()
                .distinct()
                .sorted((a, b) -> b.compareTo(a))
                .skip(1)
                .findFirst();

        secondLargest.ifPresentOrElse(
                num -> System.out.println("Số lớn thứ 2 là: " + num),
                () -> System.out.println("Không tìm thấy số lớn thứ 2")
        );
    }
}