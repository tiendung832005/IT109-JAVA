import java.util.ArrayList;
import java.util.Comparator;

public class Bai8 {
    public static void main(String[] args) {
        System.out.println("Trường hợp 1:");
        processStringList(createTestCase1());

        System.out.println("\nTrường hợp 2:");
        processStringList(createTestCase2());

        System.out.println("\nTrường hợp 3:");
        processStringList(createTestCase3());
    }

    private static void processStringList(ArrayList<String> strings) {
        System.out.println("Danh sách trước khi sắp xếp: " + strings);

        sortByLengthThenLexicographically(strings);

        System.out.println("Danh sách sau khi sắp xếp: " + strings);
    }

    private static void sortByLengthThenLexicographically(ArrayList<String> list) {
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int lengthComparison = Integer.compare(s1.length(), s2.length());
                if (lengthComparison == 0) {
                    return s1.compareTo(s2);
                }
                return lengthComparison;
            }
        });
    }

    private static ArrayList<String> createTestCase1() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("banana");
        strings.add("apple");
        strings.add("pear");
        strings.add("kiwi");
        strings.add("grape");
        return strings;
    }

    private static ArrayList<String> createTestCase2() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("hello");
        strings.add("world");
        strings.add("java");
        strings.add("code");
        return strings;
    }

    private static ArrayList<String> createTestCase3() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("abc");
        strings.add("a");
        strings.add("ab");
        strings.add("b");
        strings.add("bc");
        strings.add("ac");
        return strings;
    }
}