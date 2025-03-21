import java.util.ArrayList;
import java.util.Iterator;

public class Bai1 {
    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList<>();

        students.add("Nguyễn Văn A");
        students.add("Trần Thị B");
        students.add("Lê Hoàng C");
        students.add("Phạm Minh D");
        students.add("Hoàng Thị E");

        System.out.println("Danh sách sinh viên:");

        System.out.println("\nSử dụng vòng lặp for");
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i));
        }

        System.out.println("\n Sử dụng vòng lặp foreach");
        int count = 1;
        for (String student : students) {
            System.out.println(count + ". " + student);
            count++;
        }

        System.out.println("\nSử dụng Iterator");
        Iterator<String> iterator = students.iterator();
        count = 1;
        while (iterator.hasNext()) {
            String student = iterator.next();
            System.out.println(count + ". " + student);
            count++;
        }
    }
}
