import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Bai6 {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        set1.add(10);
        set1.add(20);
        set1.add(30);
        set1.add(40);

        Set<Integer> set2 = new HashSet<>();
        set2.add(30);
        set2.add(40);
        set2.add(50);
        set2.add(60);

        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);

        Set<Integer> intersectionSet = new HashSet<>(set1);
        intersectionSet.retainAll(set2);

        System.out.println("Tập hợp giao của hai HashSet: " + intersectionSet);

        TreeSet<Integer> sortedIntersection = new TreeSet<>(intersectionSet);

        System.out.println("Tập hợp giao sau khi sắp xếp tăng dần: " + sortedIntersection);
    }
}