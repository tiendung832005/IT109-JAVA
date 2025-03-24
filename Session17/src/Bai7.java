import java.util.*;

public class Bai7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập đoạn văn bản:");
        String text = scanner.nextLine();

        String[] words = text.split("\\W+");

        List<String> wordList = new ArrayList<>();

        Set<String> uniqueWords = new HashSet<>();

        for (String word : words) {
            if (!word.isEmpty()) {
                String lowerCaseWord = word.toLowerCase();
                wordList.add(lowerCaseWord);
                uniqueWords.add(lowerCaseWord);
            }
        }

        List<String> sortedUniqueWords = new ArrayList<>(uniqueWords);

        Collections.sort(sortedUniqueWords);

        System.out.println("Danh sách các từ và số lần xuất hiện:");
        for (String word : sortedUniqueWords) {
            int frequency = Collections.frequency(wordList, word);
            System.out.println(word + ": " + frequency);
        }

        scanner.close();
    }
}