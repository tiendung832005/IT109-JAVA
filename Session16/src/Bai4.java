import java.util.ArrayList;

public class Bai4 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        numbers.add(50);
        numbers.add(15);
        numbers.add(25);
        numbers.add(35);

        System.out.println("Danh sách các số nguyên:");
        for (Integer num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();
        int sum = calculateSum(numbers);
        System.out.println("Tổng của tất cả các phần tử: " + sum);
    }

    private static int calculateSum(ArrayList<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }
}