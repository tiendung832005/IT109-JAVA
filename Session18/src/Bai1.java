import java.util.HashMap;
import java.util.Map;

public class Bai1 {
    public static void main(String[] args) {
        HashMap<String, Double> studentScores = new HashMap<>();

        studentScores.put("Nguyen Van A", 8.5);
        studentScores.put("Nguyen Thi B", 9.0);
        studentScores.put("Nguyen Van C", 7.5);
        studentScores.put("Nguyen Thi D", 8.0);
        studentScores.put("Nguyen Van E", 6.5);

        System.out.println("Danh sách học sinh và điểm số:");
        for (Map.Entry<String, Double> entry : studentScores.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        String studentName = "Nguyen Van A";
        if (studentScores.containsKey(studentName)) {
            System.out.println("\nĐiểm số của " + studentName + ": " + studentScores.get(studentName));
        } else {
            System.out.println("\nKhông tìm thấy học sinh " + studentName);
        }
    }
}