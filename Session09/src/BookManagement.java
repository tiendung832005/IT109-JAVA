import java.util.*;

public class BookManagement {
    private String bookId;
    private String bookName;
    private double importPrice;
    private double exportPrice;
    private String title;
    private String author;
    private double interest;
    private int year;

    public BookManagement() {
    }
    public BookManagement(String bookId, String bookName, double importPrice, double exportPrice, String title, String author, int year) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.title = title;
        this.author = author;
        this.year = year;
        this.interest = calInterest();
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void inputData(Scanner scanner) {
        boolean valid = false;

        // Validate bookId
        while (!valid) {
            System.out.print("Nhập Mã sách (bắt đầu bằng chữ B): ");
            bookId = scanner.nextLine().trim();
            if (bookId.matches("B\\w{4}")) {
                valid = true;
            } else {
                System.out.println("Mã sách không hợp lệ");
            }
        }

        valid = false;
        // Validate bookName
        while (!valid) {
            System.out.print("Nhập Tên sách: ");
            bookName = scanner.nextLine().trim();
            if (bookName.length() >= 6 && bookName.length() <= 100) {
                valid = true;
            } else {
                System.out.println("Tên sách không hợp lệ");
            }
        }
        valid = false;
        while (!valid) {
            try {
                System.out.print("Nhập Giá nhập: ");
                importPrice = Double.parseDouble(scanner.nextLine().trim());
                if (importPrice > 0) {
                    valid = true;
                } else {
                    System.out.println("Giá nhập không hợp lệ");
                }
            } catch (NumberFormatException e) {
                System.out.println("Định dạng số không hợp lệ");
            }
        }
        valid = false;
        while (!valid) {
            try {
                System.out.print("Nhập Giá bán: ");
                exportPrice = Double.parseDouble(scanner.nextLine().trim());
                if (exportPrice >= importPrice * 1.1) {
                    valid = true;
                } else {
                    System.out.println("Giá bán không hợp lệ! Phải ít nhất 10% lớn hơn Giá nhập (" + (importPrice * 1.1) + ").");
                }
            } catch (NumberFormatException e) {
                System.out.println("Định dạng số không hợp lệ");
            }
        }

        do {
            System.out.print("Nhập Tiêu đề sách: ");
            title = scanner.nextLine().trim();
            if (title.isEmpty()) {
                System.out.println("Tiêu đề sách là bắt buộc");
            }
        } while (title.isEmpty());

        // Validate author (required)
        do {
            System.out.print("Nhập Tác giả: ");
            author = scanner.nextLine().trim();
            if (author.isEmpty()) {
                System.out.println("Tác giả là bắt buộc");
            }
        } while (author.isEmpty());
        valid = false;
        while (!valid) {
            try {
                System.out.print("Nhập Năm xuất bản: ");
                year = Integer.parseInt(scanner.nextLine().trim());
                if (year > 1970) {
                    valid = true;
                } else {
                    System.out.println("Năm không hợp lệ");
                }
            } catch (NumberFormatException e) {
                System.out.println("Định dạng số không hợp lệ");
            }
        }

        interest = calInterest();
    }

    public void displayData() {
        System.out.printf("| %-7s | %-30s | %-30s | %-15s | %-15s | %-15s | %-10s | %-15s |%n",
                bookId, bookName, title, author, importPrice, exportPrice, year, interest);
    }

    public double calInterest() {
        return exportPrice - importPrice;
    }

    public class Main {
        private static List<BookManagement> bookList = new ArrayList<>();
        private static Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
            int choice;
            do {
                displayMenu();
                System.out.print("Nhập lựa chọn của bạn: ");
                try {
                    choice = Integer.parseInt(scanner.nextLine().trim());
                    switch (choice) {
                        case 1:
                            displayBooks();
                            break;
                        case 2:
                            addBook();
                            break;
                        case 3:
                            calculateInterest();
                            break;
                        case 4:
                            updateBook();
                            break;
                        case 5:
                            deleteBook();
                            break;
                        case 6:
                            sortBooksByInterest();
                            break;
                        case 7:
                            searchBooksByAuthor();
                            break;
                        case 8:
                            searchBooksByPriceRange();
                            break;
                        case 9:
                            statisticsByAuthor();
                            break;
                        case 10:
                            System.out.println("Thoát chương trình");
                            break;
                        default:
                            System.out.println("Lựa chọn không hợp lệ");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Đầu vào không hợp lệ");
                    choice = 0;
                }
            } while (choice != 10);
        }

        private static void displayMenu() {
            System.out.println("\n****************************MENU*************************");
            System.out.println("1. Danh sách sách");
            System.out.println("2. Thêm mới sách");
            System.out.println("3. Tính lợi nhuận của các sách");
            System.out.println("4. Cập nhật sách");
            System.out.println("5. Xóa sách");
            System.out.println("6. Sắp xếp sách theo lợi nhuận tăng dần");
            System.out.println("7. Tìm kiếm sách theo tác giả");
            System.out.println("8. Tìm kiếm sách theo khoảng giá (tìm theo khoảng giá bán)");
            System.out.println("9. Thống kê sách theo mỗi tác giả");
            System.out.println("10.Thoát");

        }

        private static void displayBooks() {
            if (bookList.isEmpty()) {
                System.out.println("Không có sách nào trong danh sách");
                return;
            }
            printTableHeader();
            for (BookManagement book : bookList) {
                book.displayData();
            }

        }

        private static void printTableHeader() {

            System.out.printf("| %-7s | %-30s | %-30s | %-15s | %-15s | %-15s | %-10s | %-15s |%n",
                    "Mã sách", "Tên sách", "Tiêu đề", "Tác giả", "Giá nhập", "Giá bán", "Năm XB", "Lợi nhuận");
        }

        private static void addBook() {
            BookManagement newBook = new BookManagement();
            newBook.inputData(scanner);
            bookList.add(newBook);
            System.out.println("Thêm sách thành công");
        }

        private static void calculateInterest() {
            if (bookList.isEmpty()) {
                System.out.println("Không có sách nào trong danh sách");
                return;
            }

            for (BookManagement book : bookList) {
                book.setInterest(book.calInterest());
                System.out.println("Sách: " + book.getBookName() + ", Lợi nhuận: " + book.getInterest());
            }
        }

        private static void updateBook() {
            if (bookList.isEmpty()) {
                System.out.println("Không có sách nào để cập nhật.");
                return;
            }

            System.out.print("Nhập Mã sách cần cập nhật: ");
            String bookId = scanner.nextLine().trim();

            boolean found = false;
            for (int i = 0; i < bookList.size(); i++) {
                if (bookList.get(i).getBookId().equals(bookId)) {
                    BookManagement updatedBook = new BookManagement();
                    updatedBook.inputData(scanner);
                    bookList.set(i, updatedBook);
                    System.out.println("Cập nhật sách thành công");
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Không tìm thấy sách có mã " + bookId);
            }
        }

        private static void deleteBook() {
            if (bookList.isEmpty()) {
                System.out.println("Không có sách nào để xóa");
                return;
            }

            System.out.print("Nhập Mã sách cần xóa: ");
            String bookId = scanner.nextLine().trim();

            boolean found = false;
            for (int i = 0; i < bookList.size(); i++) {
                if (bookList.get(i).getBookId().equals(bookId)) {
                    bookList.remove(i);
                    System.out.println("Xóa sách thành công");
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Không tìm thấy sách có mã " + bookId);
            }
        }

        private static void sortBooksByInterest() {
            if (bookList.isEmpty()) {
                System.out.println("Không có sách nào để sắp xếp");
                return;
            }

            Collections.sort(bookList, Comparator.comparingDouble(BookManagement::getInterest));
            printTableHeader();
            for (BookManagement book : bookList) {
                book.displayData();
            }
        }

        private static void searchBooksByAuthor() {
            if (bookList.isEmpty()) {
                System.out.println("Không có sách nào để tìm kiếm");
                return;
            }

            System.out.print("Nhập tên tác giả: ");
            String authorName = scanner.nextLine().trim().toLowerCase();

            List<BookManagement> found = new ArrayList<>();
            for (BookManagement book : bookList) {
                if (book.getAuthor().toLowerCase().contains(authorName)) {
                    found.add(book);
                }
            }

            if (found.isEmpty()) {
                System.out.println("Không tìm thấy sách nào của tác giả: " + authorName);
            } else {
                System.out.println("Tìm thấy " + found.size() + " sách của tác giả có chứa '" + authorName + "':");
                printTableHeader();
                for (BookManagement book : found) {
                    book.displayData();
                }
            }
        }

        private static void searchBooksByPriceRange() {
            if (bookList.isEmpty()) {
                System.out.println("Không có sách nào để tìm kiếm");
                return;
            }

            double minPrice = 0;
            double maxPrice = 0;
            boolean validInput = false;

            while (!validInput) {
                try {
                    System.out.print("Nhập giá bán tối thiểu: ");
                    minPrice = Double.parseDouble(scanner.nextLine().trim());

                    System.out.print("Nhập giá bán tối đa: ");
                    maxPrice = Double.parseDouble(scanner.nextLine().trim());

                    if (minPrice > maxPrice) {
                        System.out.println("Giá tối thiểu không thể lớn hơn giá tối đa");
                    } else {
                        validInput = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Đầu vào không hợp lệ");
                }
            }

            List<BookManagement> found = new ArrayList<>();
            for (BookManagement book : bookList) {
                if (book.getExportPrice() >= minPrice && book.getExportPrice() <= maxPrice) {
                    found.add(book);
                }
            }

            if (found.isEmpty()) {
                System.out.println("Không tìm thấy sách nào trong khoảng giá " + minPrice + " - " + maxPrice);
            } else {
                System.out.println("Tìm thấy " + found.size() + " sách trong khoảng giá " + minPrice + " - " + maxPrice + ":");
                printTableHeader();
                for (BookManagement book : found) {
                    book.displayData();
                }
            }
        }

        private static void statisticsByAuthor() {
            if (bookList.isEmpty()) {
                System.out.println("Không có sách nào để thống kê");
                return;
            }

            Map<String, Integer> authorStats = new HashMap<>();

            for (BookManagement book : bookList) {
                String author = book.getAuthor();
                authorStats.put(author, authorStats.getOrDefault(author, 0) + 1);
            }

            System.out.println("+----------------------+-------------+");
            System.out.printf("| %-20s | %-11s |%n", "Tác giả", "Số lượng sách");
            System.out.println("+----------------------+-------------+");

            for (Map.Entry<String, Integer> entry : authorStats.entrySet()) {
                System.out.printf("| %-20s | %-11d |%n", entry.getKey(), entry.getValue());
            }
        }
    }
}
