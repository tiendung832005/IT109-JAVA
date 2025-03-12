//Bai5
public class Vector2D {

        private double x;
        private double y;

        public Vector2D(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double calculateMagnitude() {
            return Math.sqrt(x * x + y * y);
        }

        public Vector2D add(Vector2D v) {
            return new Vector2D(this.x + v.x, this.y + v.y);
        }

        public Vector2D subtract(Vector2D v) {
            return new Vector2D(this.x - v.x, this.y - v.y);
        }

        public double dotProduct(Vector2D v) {
            return this.x * v.x + this.y * v.y;
        }

        public void displayVector() {
            System.out.printf("(%.2f, %.2f)\n", x, y);
        }

        public static void main(String[] args) {
            Vector2D vector1 = new Vector2D(3, 4);
            Vector2D vector2 = new Vector2D(1, 2);

            System.out.println("vector 1: ");
            vector1.displayVector();

            System.out.println("vector 2: ");
            vector2.displayVector();

            System.out.printf("Độ dài vector 1: %.2f\n", vector1.calculateMagnitude());
            System.out.printf("Độ dài vector 2: %.2f\n", vector2.calculateMagnitude());

            Vector2D sumVector = vector1.add(vector2);
            System.out.print("Tổng vector 1 và vector 2: ");
            sumVector.displayVector();

            Vector2D diffVector = vector1.subtract(vector2);
            System.out.print("Hiệu vector 1 và vector 2: ");
            diffVector.displayVector();

            double dotProductResult = vector1.dotProduct(vector2);
            System.out.printf("Tích vô hướng vector 1 và vector 2: %.2f\n", dotProductResult);
        }
    }
