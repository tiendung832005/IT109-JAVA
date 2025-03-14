// Lớp Point
public class Point {
    private double x;
    private double y;

    public Point() {
        this.x = 0.0;
        this.y = 0.0;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setXY(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

class MoveablePoint extends Point {
    private double xSpeed;
    private double ySpeed;

    public MoveablePoint() {
        super();
        this.xSpeed = 0.0;
        this.ySpeed = 0.0;
    }

    public MoveablePoint(double x, double y) {
        super(x, y);
        this.xSpeed = 0.0;
        this.ySpeed = 0.0;
    }

    public MoveablePoint(double x, double y, double xSpeed, double ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public double getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(double xSpeed) {
        this.xSpeed = xSpeed;
    }

    public double getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(double ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(double xSpeed, double ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public double[] getSpeed() {
        return new double[]{xSpeed, ySpeed};
    }

    public MoveablePoint move() {
        setX(getX() + xSpeed);
        setY(getY() + ySpeed);
        return this;
    }

    @Override
    public String toString() {
        return super.toString() + " tốc độ (" + xSpeed + ", " + ySpeed + ")";
    }
}

class TestMoveablePoint {
    public static void main(String[] args) {
        Point point = new Point(3.0, 4.0);
        System.out.println("Điểm ban đầu: " + point);

        point.setX(5.0);
        point.setY(6.0);
        System.out.println("Điểm sau khi thay đổi tọa độ: " + point);


        MoveablePoint movePoint1 = new MoveablePoint(1.0, 2.0, 0.5, 0.5);
        System.out.println("Điểm di chuyển 1: " + movePoint1);

        movePoint1.move();
        System.out.println("Điểm di chuyển 1 lần 1: " + movePoint1);


        movePoint1.move();
        System.out.println("Điểm di chuyển 1 lần 2: " + movePoint1);

        MoveablePoint movePoint2 = new MoveablePoint(10.0, 20.0);
        System.out.println("\nĐiểm di chuyển 2 : " + movePoint2);


        movePoint2.setXSpeed(1.5);
        movePoint2.setYSpeed(-0.5);
        System.out.println("Điểm di chuyển 2 lần 1: " + movePoint2);

        movePoint2.move().move();
        System.out.println("Điểm di chuyển 2 lần 2: " + movePoint2);


        System.out.println("\nThay đổi cả tọa độ và tốc độ:");
        movePoint2.setXY(5.0, 5.0);
        movePoint2.setSpeed(2.0, 2.0);
        System.out.println("Điểm di chuyển 2 sau: " + movePoint2);

        movePoint2.move();
        System.out.println("Điểm di chuyển 2 tốc độ mới: " + movePoint2);
    }
}