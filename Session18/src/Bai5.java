import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Bai5 {
    public static void main(String[] args) {
        Map<String, Double> products = new HashMap<>();

        products.put("Điện thoại Samsung", 800.0);
        products.put("Laptop Dell", 1200.0);
        products.put("Tai nghe Bluetooth", 300.0);
        products.put("Máy tính bảng", 600.0);
        products.put("Smart TV", 1500.0);
        products.put("Đồng hồ thông minh", 450.0);
        products.put("Máy ảnh Canon", 1000.0);
        products.put("Bàn phím cơ", 150.0);
        products.put("Chuột không dây", 50.0);
        products.put("Loa Bluetooth", 700.0);

        System.out.println("Danh sách sản phẩm ban đầu:");
        for (Map.Entry<String, Double> entry : products.entrySet()) {
            System.out.println("Tên sản phẩm: " + entry.getKey() + " - Giá: " + entry.getValue());
        }

        Map<String, Double> filteredAndSortedProducts = products.entrySet().stream()
                .filter(entry -> entry.getValue() >= 500 && entry.getValue() <= 1500)
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));

        System.out.println("\nDanh sách sản phẩm có giá từ 500 đến 1500:");
        for (Map.Entry<String, Double> entry : filteredAndSortedProducts.entrySet()) {
            System.out.println("Tên sản phẩm: " + entry.getKey() + " - Giá: " + entry.getValue());
        }
    }
}