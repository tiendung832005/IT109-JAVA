package Bai9;

import java.util.List;

class ProductProcessorImpl implements ProductProcessor {
    @Override
    public boolean hasExpensiveProduct(List<Product> products) {
        for (Product product : products) {
            if (product.getPrice() > 100) {
                return true;
            }
        }
        return false;
    }

    @Override
    public double calculateTotalValue(List<Product> products) {
        double totalValue = 0;
        for (Product product : products) {
            totalValue += product.getPrice();
        }
        return totalValue;
    }
}
