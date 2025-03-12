// Bài 9
public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Mẫu không được bằng 0");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
    }

    public Fraction add(Fraction other) {
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction subtract(Fraction other) {
        int newNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction multiply(Fraction other) {
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction divide(Fraction other) {
        if (other.numerator == 0) {
            throw new IllegalArgumentException("Không thể chia cho phân số có tử bằng 0");
        }
        int newNumerator = this.numerator * other.denominator;
        int newDenominator = this.denominator * other.numerator;
        return new Fraction(newNumerator, newDenominator);
    }

    private void simplify() {
        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
        numerator /= gcd;
        denominator /= gcd;
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    @Override
    public String toString() {
        if (denominator == 1) {
            return numerator + "";
        }
        return numerator + "/" + denominator;
    }
        public static void main(String[] args) {
            Fraction f1 = new Fraction(1, 4);
            Fraction f2 = new Fraction(3, 4);

            Fraction sum = f1.add(f2);
            System.out.println(f1 + " + " + f2 + " = " + sum);

            Fraction difference = f1.subtract(f2);
            System.out.println(f1 + " - " + f2 + " = " + difference);

            Fraction product = f1.multiply(f2);
            System.out.println(f1 + " * " + f2 + " = " + product);

            Fraction quotient = f1.divide(f2);
            System.out.println(f1 + " / " + f2 + " = " + quotient);
        }

}
