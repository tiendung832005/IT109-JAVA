import java.io.*;

public class Bai3 {
    public static void main(String[] args) {
        String inputFilePath = "input.txt";
        String outputFilePath = "copy.txt";

        try {
            createInputFile(inputFilePath);
            System.out.println("Đã tạo file input.txt thành công.");

            copyFile(inputFilePath, outputFilePath);
            System.out.println("Đã sao chép nội dung sang file copy.txt thành công.");

            System.out.println("\nNội dung của file copy.txt:");
            displayFileContent(outputFilePath);

        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void createInputFile(String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("Đây là dòng văn bản đầu tiên.\n");
            writer.write("Đây là dòng thứ hai.\n");
            writer.write("Đây là dòng thứ ba với các ký tự đặc biệt: !@#$%^&*().\n");
            writer.write("Dòng cuối cùng: Chương trình Java sao chép file.");
        }
    }
    
    private static void copyFile(String sourcePath, String destinationPath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(sourcePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destinationPath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
        }
    }

    // Phương thức đọc và hiển thị nội dung của file
    private static void displayFileContent(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}