import java.util.function.Function;

public class Bai2 {
    public static void main(String[] args) {
        Function<Integer, Integer> polynomialFunction = x -> x * x + 3 * x + 2;

        System.out.println("f(1) = " + polynomialFunction.apply(1));
        System.out.println("f(2) = " + polynomialFunction.apply(2));
        System.out.println("f(3) = " + polynomialFunction.apply(3));
    }
}