import java.util.ArrayList;

public class Bai3 {
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

        System.out.println("Danh sách các số nguyên:");
        for (Integer num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();

        int max = findMax(numbers);
        int min = findMin(numbers);

        System.out.println("Phần tử lớn nhất: " + max);
        System.out.println("Phần tử nhỏ nhất: " + min);
    }

    private static int findMax(ArrayList<Integer> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Danh sách rỗng");
        }
        int max = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
            }
        }
        return max;
    }

    private static int findMin(ArrayList<Integer> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Danh sách rỗng");
        }
        int min = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < min) {
                min = list.get(i);
            }
        }
        return min;
    }
}