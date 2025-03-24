package ra.run;
import ra.entity.Book;
import java.util.*;
public class BookImp {
    private static List<Book> bookList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("*********************MENU******************");
            System.out.println("1. Nhập thông tin n sách");
            System.out.println("2. Tính lợi nhuận các sách");
            System.out.println("3. Hiển thị thông tin sách");
            System.out.println("4. Sắp xếp sách theo giá bán tăng dần");
            System.out.println("5. Sắp xếp sách theo lợi nhuận giảm dần");
            System.out.println("6. Tìm sách theo tên sách");
            System.out.println("7. Thống kê số lượng sách theo năm xuất bản");
            System.out.println("8. Thống kê số lượng sách theo tác giả");
            System.out.println("9. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    inputBooks();
                    break;
                case 2:
                    calculateInterests();
                    break;
                case 3:
                    displayBooks();
                    break;
                case 4:
                    sortBooksByExportPrice();
                    break;
                case 5:
                    sortBooksByInterest();
                    break;
                case 6:
                    searchBookByName();
                    break;
                case 7:
                    statisticByYear();
                    break;
                case 8:
                    statisticByAuthor();
                    break;
                case 9:
                    System.out.println("Thoát chương trình");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        } while (choice != 9);
    }

    private static void inputBooks() {
        System.out.print("Nhập số lượng sách: ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin sách thứ " + (i + 1) + ":");
            Book book = new Book();
            book.inputBookData();
            bookList.add(book);
        }
    }

    private static void calculateInterests() {
        for (Book book : bookList) {
            System.out.println("Lợi nhuận của sách " + book.getBookName() + ": " + book.getInterest());
        }
    }

    private static void displayBooks() {
        for (Book book : bookList) {
            book.displayBookData();
        }
    }

    private static void sortBooksByExportPrice() {
        bookList.sort(Comparator.comparing(Book::getExportPrice));
        System.out.println("Sách đã được sắp xếp theo giá bán tăng dần");
    }

    private static void sortBooksByInterest() {
        bookList.sort((b1, b2) -> Float.compare(b2.getInterest(), b1.getInterest()));
        System.out.println("Sách đã được sắp xếp theo lợi nhuận giảm dần");
    }

    private static void searchBookByName() {
        System.out.print("Nhập tên sách cần tìm: ");
        String name = scanner.nextLine();
        boolean found = false;
        for (Book book : bookList) {
            if (book.getBookName().equalsIgnoreCase(name)) {
                book.displayBookData();
                found = true;
            }
        }
        if (!found) System.out.println("Không tìm thấy sách có tên: " + name);
    }

    private static void statisticByYear() {
        Map<Integer, Long> stats = new HashMap<>();
        for (Book book : bookList) {
            stats.put(book.getYear(), stats.getOrDefault(book.getYear(), 0L) + 1);
        }
        stats.forEach((year, count) -> System.out.println("Năm " + year + ": " + count + " sách"));
    }

    private static void statisticByAuthor() {
        Map<String, Long> stats = new HashMap<>();
        for (Book book : bookList) {
            stats.put(book.getAuthor(), stats.getOrDefault(book.getAuthor(), 0L) + 1);
        }
        stats.forEach((author, count) -> System.out.println("Tác giả " + author + ": " + count + " sách"));
    }
}
