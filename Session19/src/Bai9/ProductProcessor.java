package Bai9;

import java.util.List;

interface ProductProcessor {
    static void printProductList(List<Product> products) {
        System.out.println("\nDanh sách sản phẩm:");
        for (Product product : products) {
            System.out.println(product.getName() + " - $" + product.getPrice());
        }
    }

    boolean hasExpensiveProduct(List<Product> products);

    double calculateTotalValue(List<Product> products);
}
