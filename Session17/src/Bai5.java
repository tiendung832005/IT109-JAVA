import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Bai5 {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);
        set1.add(5);

        Set<Integer> set2 = new HashSet<>();
        set2.add(4);
        set2.add(5);
        set2.add(6);
        set2.add(7);
        set2.add(8);

        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);

        Set<Integer> unionSet = new HashSet<>(set1);
        unionSet.addAll(set2);

        System.out.println("Tập hợp sau khi hợp nhất: " + unionSet);

        TreeSet<Integer> sortedSet = new TreeSet<>(unionSet);

        System.out.println("Tập hợp sau khi sắp xếp tăng dần: " + sortedSet);
    }
}