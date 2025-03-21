import java.util.ArrayList;
import java.util.Iterator;

public class Bai2 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(1);
        numbers.add(12);
        numbers.add(8);
        numbers.add(9);
        numbers.add(15);
        numbers.add(5);
        numbers.add(21);
        numbers.add(4);
        numbers.add(6);
        numbers.add(11);

        System.out.println("Danh sách trước khi xóa:");
        printList(numbers);

        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            Integer number = iterator.next();
            if (number % 3 == 0) {
                iterator.remove();
            }
        }

        System.out.println("\nDanh sách sau khi xóa các số chia hết cho 3:");
        printList(numbers);
    }

    private static void printList(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i < list.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}