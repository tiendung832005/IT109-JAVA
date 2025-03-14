
class Shape {
    private String name;


    public Shape(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double calculateArea() {
        return 0.0;
    }

    public double calculatePerimeter() {
        return 0.0;
    }

    @Override
    public String toString() {
        return "Hình: " + name + ", Diện tích: " + calculateArea() + ", Chu vi: " + calculatePerimeter();
    }
}

class Circle1 extends Shape {
    // Thuộc tính
    private double radius;

    public Circle1(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return super.toString() + ", Bán kính: " + radius;
    }
}

class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(String name, double width, double height) {
        super(name);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);
    }

    @Override
    public String toString() {
        return super.toString() + ", Chiều rộng: " + width + ", Chiều cao: " + height;
    }
}

class Triangle extends Shape {
    // Thuộc tính
    private double a;
    private double b;
    private double c;

    public Triangle(String name, double a, double b, double c) {
        super(name);

        if (!isValidTriangle(a, b, c)) {
            throw new IllegalArgumentException("Ba cạnh đã cho không tạo thành tam giác hợp lệ!");
        }

        this.a = a;
        this.b = b;
        this.c = c;
    }

    private boolean isValidTriangle(double a, double b, double c) {
        return a > 0 && b > 0 && c > 0 && (a + b > c) && (a + c > b) && (b + c > a);
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        if (!isValidTriangle(a, this.b, this.c)) {
            throw new IllegalArgumentException("Cạnh mới không tạo thành tam giác hợp lệ");
        }
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        if (!isValidTriangle(this.a, b, this.c)) {
            throw new IllegalArgumentException("Cạnh mới không tạo thành tam giác hợp lệ");
        }
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        if (!isValidTriangle(this.a, this.b, c)) {
            throw new IllegalArgumentException("Cạnh mới không tạo thành tam giác hợp lệ");
        }
        this.c = c;
    }

    @Override
    public double calculateArea() {
        double p = calculatePerimeter() / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public double calculatePerimeter() {
        return a + b + c;
    }

    @Override
    public String toString() {
        return super.toString() + ", cạnh a: " + a + ", cạnh b: " + b + ", cạnh c: " + c;
    }
}

class ShapeManagement {
    public static void main(String[] args) {
        try {
            Circle1 circle = new Circle1("Hình tròn", 5.0);
            Rectangle rectangle = new Rectangle("Hình chữ nhật", 4.0, 6.0);
            Triangle triangle = new Triangle("Tam giác", 3.0, 4.0, 5.0);

            // Tạo một mảng chứa các đối tượng Shape
            Shape[] shapes = new Shape[3];
            shapes[0] = circle;
            shapes[1] = rectangle;
            shapes[2] = triangle;

            System.out.println("THÔNG TIN HÌNH:");

            for (int i = 0; i < shapes.length; i++) {
                System.out.println(shapes[i].toString());
                System.out.println("Diện tích: " + String.format("%.2f", shapes[i].calculateArea()));
                System.out.println("Chu vi: " + String.format("%.2f", shapes[i].calculatePerimeter()));

            }

            double totalArea = 0;
            for (Shape shape : shapes) {
                totalArea += shape.calculateArea();
            }
            System.out.println("Tổng diện tích của tất cả các hình: " + String.format("%.2f", totalArea));

        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}