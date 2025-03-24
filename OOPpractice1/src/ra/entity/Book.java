package ra.entity;

import java.util.Scanner;

public class Book {
    private String bookId;
    private String bookName;
    private float importPrice;
    private float exportPrice;
    private String author;
    private float interest;
    private int year;

    // Constructor
    public Book() {
    }

    public Book(String bookId, String bookName, float importPrice, float exportPrice, String author, int year) {
        this.bookId = bookId;
        this.setBookName(bookName);
        this.setImportPrice(importPrice);
        this.setExportPrice(exportPrice);
        this.setAuthor(author);
        this.setYear(year);
        this.calculateInterest();
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
        if (bookName.length() == 4 && bookName.charAt(0) == 'B') {
            this.bookName = bookName;
        } else {
            throw new IllegalArgumentException("Tên sách phải dài 4 ký tự và bắt đầu bằng 'B'");
        }
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        if (importPrice > 0) {
            this.importPrice = importPrice;
        } else {
            throw new IllegalArgumentException("Giá nhập khẩu phải lớn hơn 0");
        }
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        if (exportPrice >= 1.3 * this.importPrice) {
            this.exportPrice = exportPrice;
        } else {
            throw new IllegalArgumentException("Giá xuất khẩu phải cao hơn giá nhập khẩu ít nhất 30%");
        }
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author.length() >= 6 && author.length() <= 50) {
            this.author = author;
        } else {
            throw new IllegalArgumentException("Tên tác giả phải dài từ 6 đến 50 ký tự");
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year > 2000) {
            this.year = year;
        } else {
            throw new IllegalArgumentException("Năm xuất bản phải sau năm 2000");
        }
    }

    public float getInterest() {
        return interest;
    }

    private void calculateInterest() {
        this.interest = this.exportPrice - this.importPrice;
    }

    public void inputBookData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập ID sách: ");
        this.bookId = scanner.nextLine();

        while (true) {
            System.out.print("Nhập Tên Sách (4 ký tự, bắt đầu bằng 'B'): ");
            try {
                setBookName(scanner.nextLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            System.out.print("Nhập giá nhập: ");
            try {
                setImportPrice(Float.parseFloat(scanner.nextLine()));
                break;
            } catch (Exception e) {
                System.out.println("Đầu vào không hợp lệ" + e.getMessage());
            }
        }

        while (true) {
            System.out.print("Nhập giá xuất khẩu: ");
            try {
                setExportPrice(Float.parseFloat(scanner.nextLine()));
                break;
            } catch (Exception e) {
                System.out.println("Đầu vào không hợp lệ " + e.getMessage());
            }
        }

        while (true) {
            System.out.print("Nhập tên tác giả (6-50 ký tự): ");
            try {
                setAuthor(scanner.nextLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            System.out.print("Nhập năm xuất bản (sau năm 2000): ");
            try {
                setYear(Integer.parseInt(scanner.nextLine()));
                break;
            } catch (Exception e) {
                System.out.println("Đầu vào không hợp lệ " + e.getMessage());
            }
        }

        calculateInterest();
    }

    // Method to display book data
    public void displayBookData() {
        System.out.println("Chi tiết sách:");
        System.out.println("Mã sách: " + bookId);
        System.out.println("Tên sách: " + bookName);
        System.out.println("Giá nhập khẩu: " + importPrice);
        System.out.println("Giá xuất khẩu: " + exportPrice);
        System.out.println("Tác giả: " + author);
        System.out.println("Năm xuất bản: " + year);
        System.out.println("Quan tâm: " + interest);
    }
}
