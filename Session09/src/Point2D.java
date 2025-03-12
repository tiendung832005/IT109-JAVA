// Bai6
public class Point2D {
    private double x;
    private double y;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double distanceTo(Point2D p) {
        return Math.sqrt((this.x - p.x) * (this.x - p.x) + (this.y - p.y) * (this.y - p.y));
    }

    public void displayPoint() {
        System.out.printf("(%.2f, %.2f)\n", x, y);
    }

    public static void main(String[] args) {
        Point2D point1 = new Point2D(5, 6);
        Point2D point2 = new Point2D(10, 4);

        System.out.println("Điểm 1:");
        point1.displayPoint();

        System.out.println("Điểm 2:");
        point2.displayPoint();

        double distance = point1.distanceTo(point2);
        System.out.printf("Khoảng cách giữa điểm 1 và điểm 2: %.2f\n", distance);

        point1.setX(5);

        point1.setY(6);

        System.out.println("Tọa độ mới của điểm 1:");
        point1.displayPoint();
    }
}

