package Bai8;

public class Product {
    protected String name;
    protected double price;
    
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }


    public double getDiscount() {
        return 0.0;
    }


    public double getFinalPrice() {
        double discount = getDiscount();
        return price - (price * discount / 100);
    }

    public double getDiscount(int quantity) {
        if (quantity > 100) {
            return 5.0;
        } else {
            return getDiscount();
        }
    }


    public double getFinalPrice(int quantity) {
        double discount = getDiscount(quantity);
        return price - (price * discount / 100);
    }
}
class Electronics extends Product {

    // Constructor
    public Electronics(String name, double price) {
        super(name, price);
    }

    // Ghi đè chiết khấu 10%
    @Override
    public double getDiscount() {
        return 10.0;
    }
}
class Clothing extends Product {


    public Clothing(String name, double price) {
        super(name, price);
    }


    @Override
    public double getDiscount() {
        return 20.0;
    }
}
class Food extends Product {

    public Food(String name, double price) {
        super(name, price);
    }


    @Override
    public double getDiscount() {
        return 5.0;
    }
}
class Main {
    public static void main(String[] args) {

        Product genericProduct = new Product("Generic Product", 1000);
        Product electronic = new Electronics("Laptop", 2000);
        Product clothing = new Clothing("T-Shirt", 500);
        Product food = new Food("Bread", 100);


        System.out.println("Giá sản phẩm thông thường (sau chiết khấu): " + genericProduct.getFinalPrice());
        System.out.println("Giá điện tử (sau chiết khấu): " + electronic.getFinalPrice());
        System.out.println("Giá quần áo (sau chiết khấu): " + clothing.getFinalPrice());
        System.out.println("Giá thực phẩm (sau chiết khấu): " + food.getFinalPrice());



        int quantity = 150;

        System.out.println("Giá sản phẩm thông thường (mua " + quantity + " cái, sau chiết khấu): " + genericProduct.getFinalPrice(quantity));
        System.out.println("Giá điện tử (mua " + quantity + " cái, sau chiết khấu): " + electronic.getFinalPrice(quantity));
        System.out.println("Giá quần áo (mua " + quantity + " cái, sau chiết khấu): " + clothing.getFinalPrice(quantity));
        System.out.println("Giá thực phẩm (mua " + quantity + " cái, sau chiết khấu): " + food.getFinalPrice(quantity));
    }
}
