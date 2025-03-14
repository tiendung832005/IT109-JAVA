public class Book {
    private String title;
    private String author;
    private double price;

    public Book(){

    }

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        setPrice(price);
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

    public void setAuthor (String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice (double price) {
        if(price > 0) {
            this.price = price;
        }else{
            System.out.println("Lỗi giá sách");
        }
    }

    public void displayInfo(){
        System.out.println("Thông tin sách: ");
        System.out.println("Tên sách: " + title);
        System.out.println("Tác giả: " + author);
        System.out.println("Giá: " + price);
    }

    public class TestBook{
        public static void main(String[] args) {
            Book myBook = new Book("Tôi thấy hoa vàng trên cỏ xanh", "Nguyeenx Ngọc Ánh", 50000);

            System.out.println("Thôn tin sách: ");
            myBook.displayInfo();

            System.out.println("\n Sử dụng getter: ");
            System.out.println("Tên sách: " + myBook.getTitle());
            System.out.println("Tác giả: " + myBook.getAuthor());
            System.out.println("Giá: " + myBook.getPrice());

            System.out.println("\n Sử dụng setter: ");
            System.out.println("Dế mèn phiêu lưu kí");
            System.out.println("Tô Hoài ");
            System.out.println("75000");


            myBook.setPrice(-10000);
            System.out.println("Giá sách sau khi thử thay đổi: " + myBook.getPrice() + " VND");

            System.out.println("\nTạo sách mới với giá không hợp lệ");
            Book invalidBook = new Book("Truyện Kiều", "Nguyễn Du", -50000);
            System.out.println("Giá sách mới: " + invalidBook.getPrice() + " VND");


        }
    }

}
