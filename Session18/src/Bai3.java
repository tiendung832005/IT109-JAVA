import java.util.LinkedHashMap;
import java.util.Map;

public class Bai3 {
    public static void main(String[] args) {
        LinkedHashMap<String, Double> products = new LinkedHashMap<>();

        products.put("Laptop", 1200.0);
        products.put("Điện thoại", 800.0);
        products.put("Tai nghe", 150.0);
        products.put("Chuột", 50.0);
        products.put("Bàn phím", 100.0);

        System.out.println("Danh sách sản phẩm ban đầu:");
        printProducts(products);

        String productToUpdate = "Laptop";
        double newPrice = 1500.0;

        if (products.containsKey(productToUpdate)) {
            products.put(productToUpdate, newPrice);
            System.out.println("\nĐã cập nhật giá của " + productToUpdate + " thành $" + newPrice);
        } else {
            System.out.println("\nKhông tìm thấy sản phẩm " + productToUpdate + " để cập nhật");
        }

        System.out.println("\nDanh sách sản phẩm sau khi cập nhật:");
        printProducts(products);

        String productToRemove = "Tai nghe";

        if (products.containsKey(productToRemove)) {
            products.remove(productToRemove);
            System.out.println("\nĐã xóa sản phẩm " + productToRemove);
        } else {
            System.out.println("\nKhông tìm thấy sản phẩm " + productToRemove + " để xóa");
        }

        System.out.println("\nDanh sách sản phẩm sau khi xóa:");
        printProducts(products);
    }

    private static void printProducts(LinkedHashMap<String, Double> products) {
        for (Map.Entry<String, Double> entry : products.entrySet()) {
            System.out.println(entry.getKey() + ": $" + entry.getValue());
        }
    }
}