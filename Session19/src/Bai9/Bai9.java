package Bai9;

import java.util.ArrayList;
import java.util.List;

public class Bai9 {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", 1500.50));
        products.add(new Product("Mouse", 28.99));
        products.add(new Product("Keyboard", 85.00));
        products.add(new Product("Monitor", 350.70));

        ProductProcessorImpl processor = new ProductProcessorImpl();

        if (processor.hasExpensiveProduct(products)) {
            System.out.println("Sản phẩm đắt tiền:");
            for (Product product : products) {
                if (product.getPrice() > 100) {
                    System.out.println(product.getName() + " - $" + product.getPrice());
                }
            }
        } else {
            System.out.println("Không có sản phẩm đắt tiền");
        }

        double totalValue = processor.calculateTotalValue(products);
        System.out.println("\nTổng giá trị sản phẩm: $" + totalValue);

        ProductProcessor.printProductList(products);
    }
}
