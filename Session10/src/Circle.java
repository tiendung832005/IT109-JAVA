public class Circle {
    private double radius;

    public static final double PI = 3.14159;

    public Circle(){
        this.radius = 1.0;
    }

    public Circle(double radius){
        this.radius = radius;
    }

    public double getRadius(){
        return radius;
    }

    public void setRadius(double radius){
        if(radius > 0){
            this.radius = radius;
        }else{
            System.out.println("Lỗi bán kính");
        }
    }

    public double getArea(){
        return PI * radius * radius;
    }

    public void displayInfo(){
        System.out.println("Hình tròn có bán kính: " +radius);
        System.out.println("Diện tích: " +getArea());
    }

}

class Cylinder extends Circle {
    private double height;

    public Cylinder(){
        super();
        this.height = 1.0;
    }

    public Cylinder (double radius, double height) {
        super(radius);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if(height > 0){
            this.height = height;
        } else{
            System.out.println("Lỗi chiều cao");
        }
    }

    public double getVolume(){
        return getArea() * height;
    }

    @Override
    public void displayInfo(){
        System.out.println("Hình trụ có baán kính: " + getRadius() + ", chiều cao: " +height);
        System.out.println("diện tích đáy: " + getArea());
        System.out.println("Thể tích: " +getVolume());
    }

    public class TestShape {
        public static void main(String[] args) {
            Circle circle  = new Circle(8.0);
            System.out.println("Thôn tin: ");
            circle.displayInfo();

            System.out.println("\n Sau khi thay đổi");
            circle.setRadius(5.0);
            circle.displayInfo();

            Cylinder cylinder = new Cylinder(6.0, 12.0);
            System.out.println("Thông tin hình trụ:");
            cylinder.displayInfo();

            System.out.println("\nSau khi thay đổi bán kính và chiều cao:");
            cylinder.setRadius(4.0);
            cylinder.setHeight(10.0);
            cylinder.displayInfo();
        }
    }
}
