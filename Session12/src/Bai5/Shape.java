package Bai5;

public class Shape {
    public double area() {
        return 0.0;
    }
}
class Circle extends Shape {
    private double radius;


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


    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }
}
class Square extends Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }


    @Override
    public double area() {
        return side * side;
    }
}
class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(7);
        shapes[1] = new Rectangle(6, 8);
        shapes[2] = new Square(5);

        // Vòng lặp tính và in diện tích từng hình
        for (int i = 0; i < shapes.length; i++) {
            System.out.println("Diện tích hình " + (i + 1) + ": " + shapes[i].area());
        }
    }
}
