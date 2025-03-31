package bai9;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookManager {
    private static final String FILE_NAME = "books.dat";
    private List<Book> books;

    public BookManager() {
        books = new ArrayList<>();
        loadBooksFromFile();
    }

    public void addBook(Book book) {
        // Kiểm tra xem sách đã tồn tại chưa
        for (Book b : books) {
            if (b.getId() == book.getId()) {
                System.out.println("Sách với ID " + book.getId() + " đã tồn tại!");
                return;
            }
        }
        books.add(book);
        saveBooks();
        System.out.println("Thêm sách thành công!");
    }

    public void updateBook(Book book) {
        boolean found = false;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == book.getId()) {
                books.set(i, book);
                found = true;
                break;
            }
        }

        if (found) {
            saveBooks();
            System.out.println("Cập nhật sách thành công!");
        } else {
            System.out.println("Không tìm thấy sách với ID " + book.getId());
        }
    }

    public void deleteBook(int id) {
        boolean removed = books.removeIf(book -> book.getId() == id);

        if (removed) {
            saveBooks();
            System.out.println("Xóa sách thành công!");
        } else {
            System.out.println("Không tìm thấy sách với ID " + id);
        }
    }

    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("Danh sách sách trống!");
            return;
        }

        System.out.println("Danh sách tất cả sách:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    private void saveBooks() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(books);
        } catch (IOException e) {
            System.out.println("Lỗi khi lưu sách: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private void loadBooksFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            books = (List<Book>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Lỗi khi đọc file sách: " + e.getMessage());
            books = new ArrayList<>();
        }
    }
}
