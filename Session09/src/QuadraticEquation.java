// Bai7
public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getDiscriminant() {
        return b * b - 4 * a * c;
    }

    public boolean hasRealRoots() {
        return getDiscriminant() >= 0;
    }

    public double getRoot1() {
        double delta = getDiscriminant();
        if (delta >= 0) {
            return (-b + Math.sqrt(delta)) / (2 * a);
        } else {
            return Double.NaN;
        }
    }

    public double getRoot2() {
        double delta = getDiscriminant();
        if (delta >= 0) {
            return (-b - Math.sqrt(delta)) / (2 * a);
        } else {
            return Double.NaN;
        }
    }
    public void display() {
        double delta = getDiscriminant();
        System.out.printf("Phương trình: %.2fx^2 + %.2fx + %.2f = 0\n", a, b, c);
        System.out.printf("Biểu thức delta = %.2f\n", delta);

        if (delta > 0) {
            System.out.printf("Phương trình có 2 nghiệm phân biệt:\n");
            System.out.printf("x1 = %.2f\n", getRoot1());
            System.out.printf("x2 = %.2f\n", getRoot2());
        } else if (delta == 0) {
            System.out.printf("Phương trình có nghiệm kép:\n");
            System.out.printf("x = %.2f\n", getRoot1());
        } else {
            System.out.println("Phương trình không có nghiệm thực");
        }
    }

    public static void main(String[] args) {
        QuadraticEquation eq1 = new QuadraticEquation(1, -3, 2);
        eq1.display();

        System.out.println();

        QuadraticEquation eq2 = new QuadraticEquation(1, -2, 1);
        eq2.display();

        System.out.println();

        QuadraticEquation eq3 = new QuadraticEquation(1, 2, 5);
        eq3.display();
    }
}

