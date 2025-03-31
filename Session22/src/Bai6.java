import java.io.*;

public class Bai6 {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "copy.txt";

        try {
            createInputFile(inputFile);
            System.out.println("Đã tạo file " + inputFile + " thành công");

            String content = readFromFile(inputFile);
            System.out.println("Nội dung file " + inputFile + ": " + content);

            String reversedContent = reverseString(content);
            System.out.println("Chuỗi sau khi đảo ngược: " + reversedContent);

            writeToFile(outputFile, reversedContent);
            System.out.println("Đã ghi chuỗi đảo ngược vào file " + outputFile + " thành công");

            String verifyContent = readFromFile(outputFile);
            System.out.println("Nội dung file " + outputFile + ": " + verifyContent);

        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void createInputFile(String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Rikkei Academy");
        }
    }

    private static String readFromFile(String fileName) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        }
        return content.toString();
    }

    private static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    private static void writeToFile(String fileName, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
        }
    }
}