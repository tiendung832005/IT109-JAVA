package Bai5;

public interface Colorable {
    void setColor(String color);
}
class Circle implements Colorable {
    private double radius;
    private String color;

    public Circle(double radius) {
        this.radius = radius;
        this.color = "Không co màu";
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
        System.out.println("Màu của hình tròn: " + color);
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Hình tròn [radius=" + radius + ", màu=" + color + "]";
    }
}
class Rectangle implements Colorable {
    private double length;
    private double width;
    private String color;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
        this.color = "Khong màu";
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public String getColor() {
        return color;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
        System.out.println("Màu Rectangle: " + color);
    }

    public double getArea() {
        return length * width;
    }

    @Override
    public String toString() {
        return "Rectangle [length=" + length + ", width=" + width + ", color=" + color + "]";
    }
}
class Square implements Colorable {
    private double side;
    private String color;

    public Square(double side) {
        this.side = side;
        this.color = "Không màu";
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public String getColor() {
        return color;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
        System.out.println("Mauf hình vuông: " + color);
    }

    public double getArea() {
        return side * side;
    }

    @Override
    public String toString() {
        return "Square [side=" + side + ", color=" + color + "]";
    }
}
class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(5.0);
        Rectangle rectangle = new Rectangle(4.0, 6.0);
        Square square = new Square(3.0);

        circle.setColor("Red");
        rectangle.setColor("Blue");
        square.setColor("Green");

        System.out.println("\n===== Thông tin các hình =====");
        System.out.println(circle);
        System.out.println(rectangle);
        System.out.println(square);

        System.out.println("\n===== Màu của các hình =====");
        System.out.println("Circle color: " + circle.getColor());
        System.out.println("Rectangle color: " + rectangle.getColor());
        System.out.println("Square color: " + square.getColor());
    }
}