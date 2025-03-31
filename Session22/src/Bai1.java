import java.io.*;
import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập chuỗi văn bản: ");
        String text = scanner.nextLine();

        try {
            FileWriter fileWriter = new FileWriter("output.txt");
            fileWriter.write(text);
            fileWriter.close();
            System.out.println("Đã ghi chuỗi vào file output.txt thành công.");

            System.out.println("\nNội dung của file output.txt:");
            BufferedReader reader = new BufferedReader(new FileReader("output.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();

        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi khi thao tác với file: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}