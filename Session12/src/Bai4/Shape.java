package Bai4;

public class Shape {
    public double area() {
        return 0;
    }

    public double area(double radius) {
        return Math.PI * radius * radius;
    }

    public double area(double width, double height) {
        return width * height;
    }
}
class Circle extends Shape {
    private double radius;

    // Constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}
class Rectangle extends Shape {
    private double width;
    private double height;

    // Constructor
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }
}
class Main {
    public static void main(String[] args) {
        // Kiểm tra Overriding
        Shape circle = new Circle(7);
        Shape rectangle = new Rectangle(6, 8);

        System.out.println("Diện tích hình tròn (Overriding): " + circle.area());
        System.out.println("Diện tích hình chữ nhật (Overriding): " + rectangle.area());

        Shape shape = new Shape();
        System.out.println("Diện tích hình tròn (Overloading): " + shape.area(10));
        System.out.println("Diện tích hình chữ nhật (Overloading): " + shape.area(2, 8));
    }
}
