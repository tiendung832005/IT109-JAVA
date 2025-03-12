import java.util.Scanner;
// Bai4
public class Circle {
        private double radius;

        public Circle(){
            this.radius = 1.0;
        }

        public Circle(double radius){
            this.radius = radius;
        }

        public double getArea() {
            return Math.PI * radius * radius;
        }

        public double getCircumference() {
            return 2 * Math.PI * radius;
        }

        public void display() {
            System.out.printf("Bán kính: %.2f\n", radius);
            System.out.printf("Diện tích: %.2f\n", getArea());
            System.out.printf("Chu vi: %.2f\n", getCircumference());
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Hình tròn mặc định:");
            Circle circle = new Circle();
            circle.display();

            System.out.print("Nhập bán kính hình tròn: ");
            double radiusInput = scanner.nextDouble();
            Circle circle1 = new Circle(radiusInput);

            System.out.println("\nHình tròn laf:");
            circle1.display();
            scanner.close();

        }
    }
