package Bai9;

import java.util.List;

interface ProductProcessor {
    double calculateTotalValue(List<Product> products);
    static void printProductList(List<Product> products) {
        System.out.println("Product List:");
        for (Product product : products) {
            System.out.println(product.getName() + " - $" + product.getPrice());
        }
    }

    default boolean hasExpensiveProduct(List<Product> products) {
        return products.stream()
                .anyMatch(product -> product.getPrice() > 100);
    }
}
