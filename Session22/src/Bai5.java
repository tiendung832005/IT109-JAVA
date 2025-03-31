import java.io.*;
import java.util.*;

public class Bai5 {
    public static void main(String[] args) {
        String fileName = "input.txt";

        try {
            createInputFile(fileName);
            System.out.println("Đã tạo file " + fileName + " thành công.");

            List<String> names = readFile(fileName);
            System.out.println("Nội dung của file " + fileName + ":");
            for (String name : names) {
                System.out.println(name);
            }

            String longestName = findLongestName(names);
            int longestLength = longestName.length();

            System.out.println("\nKết quả:");
            System.out.println("- Tên cầu thủ dài nhất: " + longestName);
            System.out.println("- Độ dài của tên đó: " + longestLength + " ký tự");

        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void createInputFile(String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Văn Lâm");
            writer.newLine();
            writer.write("Tiến Linh");
            writer.newLine();
            writer.write("Xuân Sơn");
            writer.newLine();
            writer.write("Hoàng Đức");
            writer.newLine();
            writer.write("Văn Hậu");
        }
    }

    private static List<String> readFile(String fileName) throws IOException {
        List<String> names = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                names.add(line);
            }
        }
        return names;
    }

    private static String findLongestName(List<String> names) {
        String longest = "";
        for (String name : names) {
            if (name.length() > longest.length()) {
                longest = name;
            }
        }
        return longest;
    }
}