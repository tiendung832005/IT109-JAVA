public class Bai6 {
    public static void main(String[] args) {
        int[] originalArray = {1, 2, 3, 5, 22, 7, 45, 100, 12, 45, 200, 300, 22, 7, 7, 45, 455, 455, 100, 500};

        int[] markingArray = new int[1001];
        int maxCount = 0;

        for (int num : originalArray) {
            markingArray[num]++;
        }

        for (int i = 0; i < markingArray.length; i++) {
            if (markingArray[i] > maxCount) {
                maxCount = markingArray[i];
            }
        }

        System.out.println("Các phần tử xuất hiện nhiều nhất:");
        for (int i = 0; i < markingArray.length; i++) {
            if (markingArray[i] == maxCount) {
                System.out.println("Phần tử " + i + " Số lần xuất hiện: " + maxCount);
            }
        }
    }
}
