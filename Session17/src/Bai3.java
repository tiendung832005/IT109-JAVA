import java.util.HashSet;
import java.util.Iterator;

public class Bai3 {
    public static void main(String[] args) {
        HashSet<Integer> numbers = new HashSet<>();
        for (int i = 1; i <= 10; i++) {
            numbers.add(i);
        }

        System.out.println("HashSet ban đầu:");
        System.out.println(numbers);

        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            int number = iterator.next();
            if (number % 2 == 0) {
                iterator.remove();
            }
        }

        System.out.println("\nHashSet sau khi xóa các số chẵn:");
        System.out.println(numbers);
    }
}