import java.util.TreeSet;

public class Bai4 {
    public static void main(String[] args) {
        TreeSet<Integer> numberSet = new TreeSet<>();

        numberSet.add(45);
        numberSet.add(12);
        numberSet.add(78);
        numberSet.add(34);
        numberSet.add(23);
        numberSet.add(89);

        System.out.println("Các phần tử trong TreeSet:");
        for (Integer number : numberSet) {
            System.out.println(number);
        }
    }
}