import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Bai6 {
    public static void main(String[] args) {
        List<String> items = List.of("apple", "banana", "apple", "orange", "banana", "apple");

        Map<String, Long> itemCounts = items.stream()
                .collect(Collectors.groupingBy(
                        item -> item,
                        Collectors.counting()
                ));

        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        System.out.println("Thời điểm thực thi: " + currentTime.format(formatter));

        System.out.println("\nSố lần xuất hiện của từng phần tử:");
        itemCounts.forEach((item, count) ->
                System.out.println(item + ": " + count + " lần")
        );
    }
}