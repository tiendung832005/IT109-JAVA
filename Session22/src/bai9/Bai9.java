package bai9;

import java.util.Scanner;

public class Bai9 {
    private static BookManager bookManager = new BookManager();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            displayMenu();
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    updateBook();
                    break;
                case 3:
                    deleteBook();
                    break;
                case 4:
                    bookManager.displayAllBooks();
                    break;
                case 0:
                    System.out.println("Tạm biệt!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }

            System.out.println();
        } while (choice != 0);

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("===== QUẢN LÝ SÁCH =====");
        System.out.println("1. Thêm sách mới");
        System.out.println("2. Cập nhật thông tin sách");
        System.out.println("3. Xóa sách");
        System.out.println("4. Hiển thị tất cả sách");
        System.out.println("0. Thoát");
    }

    private static void addBook() {
        System.out.println("Nhập thông tin sách mới:");
        Book book = inputBookData();
        bookManager.addBook(book);
    }

    private static void updateBook() {
        System.out.print("Nhập ID của sách cần cập nhật: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Nhập thông tin mới cho sách:");
        Book book = inputBookData();
        book.setId(id);

        bookManager.updateBook(book);
    }

    private static void deleteBook() {
        System.out.print("Nhập ID của sách cần xóa: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        bookManager.deleteBook(id);
    }

    private static Book inputBookData() {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Tên sách: ");
        String name = scanner.nextLine();

        System.out.print("Tác giả: ");
        String author = scanner.nextLine();

        System.out.print("Nhà xuất bản: ");
        String publisher = scanner.nextLine();

        System.out.print("Giá: ");
        double price = scanner.nextDouble();

        return new Book(id, name, author, publisher, price);
    }
}
