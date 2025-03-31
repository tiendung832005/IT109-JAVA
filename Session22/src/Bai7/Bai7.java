package Bai7;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Bai7 {
    public static void main(String[] args) {
        String fileName = "data.txt";

        try {
            createDataFile(fileName);
            System.out.println("Đã tạo file " + fileName + " thành công");

            List<Country> countries = readCountriesFromFile(fileName);

            System.out.println("\nDanh sách Country:");
            for (Country country : countries) {
                System.out.println(country);
            }

        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void createDataFile(String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("1,\"AU\",\"Australia\"");
            writer.newLine();
            writer.write("2,\"CN\",\"China\"");
            writer.newLine();
            writer.write("3,\"AU\",\"Australia\"");
            writer.newLine();
            writer.write("4,\"CN\",\"China\"");
            writer.newLine();
            writer.write("5,\"JP\",\"Japan\"");
            writer.newLine();
            writer.write("6,\"CN\",\"China\"");
            writer.newLine();
            writer.write("7,\"JP\",\"Japan\"");
            writer.newLine();
            writer.write("8,\"TH\",\"Thailand\"");
        }
    }

    private static List<Country> readCountriesFromFile(String fileName) throws IOException {
        List<Country> countries = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Country country = parseCountry(line);
                if (country != null) {
                    countries.add(country);
                }
            }
        }

        return countries;
    }

    private static Country parseCountry(String line) {
        try {
            String[] parts = line.split(",");

            if (parts.length == 3) {
                int id = Integer.parseInt(parts[0].trim());
                String code = parts[1].trim().replaceAll("\"", "");
                String name = parts[2].trim().replaceAll("\"", "");

                return new Country(id, code, name);
            }
        } catch (NumberFormatException e) {
            System.out.println("Lỗi khi chuyển đổi ID sang số: " + e.getMessage());
        }

        return null;
    }
}