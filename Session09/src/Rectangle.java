import java.util.Scanner;
// Bai 3
public class Rectangle {
    private double length;
    private double width;

    public Rectangle(){
        this.length = 1;
        this.width = 1;
    }

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getArea() {
        return length * width;
    }

    public double getPerimeter() {
        return (length + width) * 2;
    }

    public void display() {
        System.out.println("Chiều dài: " + length);
        System.out.println("Chiều rộng: " + width);
        System.out.println("Diện tích: " + getArea());
        System.out.println("Chu vi: " + getPerimeter());
    }

    public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hình chữ nhật mặc định: ");
        Rectangle rectangle = new Rectangle();
        rectangle.display();

        System.out.println("\nNhập chiều dài: ");
        double length = scanner.nextDouble();
        System.out.println("Nhập chiều rộng: ");
        double width = scanner.nextDouble();

        Rectangle rectangle1 = new Rectangle(length, width);

        System.out.println("\nHình chữ nhật vừa nhập: ");
        rectangle1.display();

        scanner.close();
    }
}
