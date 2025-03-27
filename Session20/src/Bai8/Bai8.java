package Bai8;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Bai8 {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Quý", "IT", 8.5),
                new Student("Lan", "Business", 7.2),
                new Student("Minh", "IT", 9.0),
                new Student("Huyền", "Design", 6.8),
                new Student("Long", "IT", 7.9),
                new Student("Trang", "Business", 8.1),
                new Student("Việt", "IT", 8.0),
                new Student("Tú", "Design", 7.5),
                new Student("Phúc", "Business", 6.9),
                new Student("An", "AI", 9.5)
        );

        Map<String, Long> majorStatistics = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getMajor,
                        Collectors.counting()
                ));

        System.out.println("Thống kê sinh viên theo chuyên ngành:");
        majorStatistics.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEach(entry ->
                        System.out.printf("Chuyên ngành: %-15s | Số lượng: %d%n",
                                entry.getKey(), entry.getValue())
                );
    }
}
