import java.util.HashMap;
import java.util.Map;

public class Bai2 {
    public static void main(String[] args) {
        Map<String, Double> productPrices = new HashMap<>();
        
        productPrices.put("Điện thoại", 500.0);
        productPrices.put("Máy tính bảng", 300.0);
        productPrices.put("Tai nghe", 100.0);
        productPrices.put("Smartwatch", 200.0);
        productPrices.put("Tv", 1000.0);

        System.out.println("Danh sách sản phẩm và giá:");
        for (Map.Entry<String, Double> entry : productPrices.entrySet()) {
            System.out.println(entry.getKey() + ": $" + entry.getValue());
        }

        String productToCheck = "Laptop";
        if (productPrices.containsKey(productToCheck)) {
            System.out.println("\nSản phẩm '" + productToCheck + "' có trong danh sách với giá: $" + productPrices.get(productToCheck));
        } else {
            System.out.println("\nSản phẩm '" + productToCheck + "' không có trong danh sách.");
        }

        double priceToCheck = 1000.0;
        boolean foundPrice = productPrices.containsValue(priceToCheck);
        if (foundPrice) {
            System.out.println("\nCó sản phẩm có giá $" + priceToCheck + " trong danh sách.");

            System.out.println("Sản phẩm có giá $" + priceToCheck + ":");
            for (Map.Entry<String, Double> entry : productPrices.entrySet()) {
                if (entry.getValue() == priceToCheck) {
                    System.out.println("- " + entry.getKey());
                }
            }
        } else {
            System.out.println("\nKhông có sản phẩm nào có giá $" + priceToCheck + " trong danh sách.");
        }
    }
}