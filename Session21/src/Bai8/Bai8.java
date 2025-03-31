package Bai8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bai8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Nhập danh sách số điện thoại (cách nhau bởi dấu phẩy): ");
            String input = scanner.nextLine();

            List<String> validPhoneNumbers = new ArrayList<>();
            List<InvalidPhoneNumberException> exceptions = new ArrayList<>();

            String[] phoneNumbers = input.split(",");

            for (String phoneNumber : phoneNumbers) {
                phoneNumber = phoneNumber.trim();

                try {
                    validatePhoneNumber(phoneNumber);
                    validPhoneNumbers.add(phoneNumber);
                } catch (InvalidPhoneNumberException e) {
                    exceptions.add(e);
                }
            }

            System.out.println("\n===== KẾT QUẢ =====");

            if (!validPhoneNumbers.isEmpty()) {
                System.out.println("Các số điện thoại hợp lệ:");
                for (String phone : validPhoneNumbers) {
                    System.out.println("- " + phone);
                }
            }

            if (!exceptions.isEmpty()) {
                System.out.println("\nCác số điện thoại không hợp lệ:");
                for (InvalidPhoneNumberException e : exceptions) {
                    System.out.println("- " + e.getPhoneNumber() + ": " + e.getMessage());
                }
            }

        } catch (Exception e) {
            System.out.println("Đã xảy ra lỗi: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
    public static void validatePhoneNumber(String phoneNumber) throws InvalidPhoneNumberException {
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            throw new InvalidPhoneNumberException(phoneNumber, "Số điện thoại không được để trống");
        }

        if (phoneNumber.length() != 10) {
            throw new InvalidPhoneNumberException(phoneNumber, "Số điện thoại phải có đúng 10 chữ số");
        }

        if (!phoneNumber.matches("\\d+")) {
            throw new InvalidPhoneNumberException(phoneNumber, "Số điện thoại chỉ được chứa chữ số");
        }
    }
}
