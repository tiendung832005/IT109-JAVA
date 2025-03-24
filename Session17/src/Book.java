import java.util.*;

class Book {
    private String id;
    private String title;
    private String author;
    private int year;

    public Book(String id, String title, String author, int year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                '}';
    }
}

class Library {
    private Set<Book> books;

    // Constructor
    public Library() {
        this.books = new HashSet<>();
    }

    public boolean addBook(Book book) {
        return books.add(book);
    }

    public List<Book> filterBooksByYear(int year) {
        List<Book> filteredBooks = new ArrayList<>();

        for (Book book : books) {
            if (book.getYear() > year) {
                filteredBooks.add(book);
            }
        }

        return filteredBooks;
    }

    public void sortBooksByTitle(List<Book> bookList) {
        Collections.sort(bookList, new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                return b1.getTitle().compareTo(b2.getTitle());
            }
        });
    }

    public void printBooks(List<Book> bookList) {
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

    public void printAllBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}

 class LibraryManagement {
    public static void main(String[] args) {
        Library library = new Library();

        library.addBook(new Book("B001", "Chí Phèo", "Nam Cao", 1941));
        library.addBook(new Book("B002", "Vợ Nhặt", "Kim Lân", 1962));
        library.addBook(new Book("B003", "Dế Mèn phiêu lưu ký", "Tô Hoài", 1941));
        library.addBook(new Book("B004", "Tuổi thơ dữ dội", "Phùng Quán", 1988));
        library.addBook(new Book("B005", "Tắt đèn", "Ngô Tất Tố", 1939));
        library.addBook(new Book("B006", "Nhật ký trong tù", "Hồ Chí Minh", 1960));

        boolean added = library.addBook(new Book("B001", "Chí Phèo", "Nam Cao", 1941));
        System.out.println("Thêm sách trùng id B001: " + (added ? "Thành công" : "Thất bại"));

        System.out.println("\nDanh sách tất cả sách trong thư viện:");
        library.printAllBooks();

        int filterYear = 1945;
        System.out.println("\nDanh sách sách xuất bản sau năm " + filterYear + ":");
        List<Book> filteredBooks = library.filterBooksByYear(filterYear);
        library.printBooks(filteredBooks);

        System.out.println("\nDanh sách sách xuất bản sau năm " + filterYear + " (đã sắp xếp theo tên):");
        library.sortBooksByTitle(filteredBooks);
        library.printBooks(filteredBooks);


        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Thêm sách mới");
            System.out.println("2. Xem tất cả sách");
            System.out.println("3. Lọc sách theo năm xuất bản");
            System.out.println("4. Thoát");
            System.out.print("Chọn chức năng (1-4): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nhập ID sách: ");
                    String id = scanner.nextLine();
                    System.out.print("Nhập tên sách: ");
                    String title = scanner.nextLine();
                    System.out.print("Nhập tác giả: ");
                    String author = scanner.nextLine();
                    System.out.print("Nhập năm xuất bản: ");
                    int year = scanner.nextInt();
                    scanner.nextLine();

                    Book newBook = new Book(id, title, author, year);
                    boolean success = library.addBook(newBook);
                    if (success) {
                        System.out.println("Thêm sách thành công");
                    } else {
                        System.out.println("Thêm sách thất bại. ID đã tồn tại");
                    }
                    break;

                case 2:
                    System.out.println("\nDanh sách tất cả sách trong thư viện:");
                    library.printAllBooks();
                    break;

                case 3:
                    System.out.print("Nhập năm xuất bản cần lọc : ");
                    int yearFilter = scanner.nextInt();
                    scanner.nextLine();

                    List<Book> filtered = library.filterBooksByYear(yearFilter);
                    library.sortBooksByTitle(filtered);

                    System.out.println("\nDanh sách sách xuất bản sau năm " + yearFilter + " (đã sắp xếp theo tên):");
                    library.printBooks(filtered);
                    break;

                case 4:
                    System.out.println("Kết thúc chương trình");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        }
    }
}