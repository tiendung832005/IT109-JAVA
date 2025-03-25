package Bai9;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProductService {
    private Map<Integer, Product> productMap;
    private Scanner scanner;

    public ProductService() {
        this.productMap = new HashMap<>();
        this.scanner = new Scanner(System.in);
    }

    public void addProduct() {
        while (true) {
            try {
                System.out.print("Nhập ID sản phẩm: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                if (productMap.containsKey(id)) {
                    System.out.println("ID sản phẩm đã tồn tại");
                    continue;
                }

                System.out.print("Nhập tên sản phẩm: ");
                String name = scanner.nextLine();

                System.out.print("Nhập giá sản phẩm: ");
                double price = scanner.nextDouble();
                if (price < 0) {
                    System.out.println("Giá sản phẩm không được âm");
                    continue;
                }

                System.out.print("Nhập số lượng: ");
                int quantity = scanner.nextInt();
                if (quantity < 0) {
                    System.out.println("Số lượng không được âm");
                    continue;
                }

                Product product = new Product(id, name, price, quantity);
                productMap.put(id, product);
                System.out.println("Thêm sản phẩm thành công");
                break;
            } catch (Exception e) {
                System.out.println("Dữ liệu không hợp lệ");
                scanner.nextLine();
            }
        }
    }

    public void updateProduct() {
        if (productMap.isEmpty()) {
            System.out.println("Không có sản phẩm để cập nhật.");
            return;
        }

        while (true) {
            try {
                System.out.print("Nhập ID sản phẩm cần cập nhật: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                if (!productMap.containsKey(id)) {
                    System.out.println("Không tìm thấy sản phẩm với ID này");
                    continue;
                }

                Product product = productMap.get(id);
                System.out.println("1. Cập nhật giá");
                System.out.println("2. Cập nhật số lượng");
                System.out.print("Chọn loại cập nhật: ");
                int updateChoice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (updateChoice) {
                    case 1:
                        System.out.print("Nhập giá mới: ");
                        double newPrice = scanner.nextDouble();
                        if (newPrice < 0) {
                            System.out.println("Giá sản phẩm không được âm.");
                            continue;
                        }
                        product.setPrice(newPrice);
                        break;
                    case 2:
                        System.out.print("Nhập số lượng mới: ");
                        int newQuantity = scanner.nextInt();
                        if (newQuantity < 0) {
                            System.out.println("Số lượng không được âm.");
                            continue;
                        }
                        product.setQuantity(newQuantity);
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ.");
                        continue;
                }

                System.out.println("Cập nhật thành công!");
                break;
            } catch (Exception e) {
                System.out.println("Dữ liệu không hợp lệ");
                scanner.nextLine();
            }
        }
    }

    public void deleteProduct() {
        if (productMap.isEmpty()) {
            System.out.println("Không có sản phẩm để xóa.");
            return;
        }

        while (true) {
            System.out.print("Nhập ID sản phẩm cần xóa: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            if (!productMap.containsKey(id)) {
                System.out.println("Không tìm thấy sản phẩm với ID này");
                continue;
            }

            productMap.remove(id);
            System.out.println("Xóa sản phẩm thành công!");
            break;
        }
    }

    public void calculateTotalInventoryValue() {
        if (productMap.isEmpty()) {
            System.out.println("Kho hàng trống.");
            return;
        }

        double totalValue = productMap.values().stream()
                .mapToDouble(Product::calculateTotalValue)
                .sum();

        System.out.println("Tổng giá trị kho: " + totalValue + " VND");
    }

    public void displayAllProducts() {
        if (productMap.isEmpty()) {
            System.out.println("Không có sản phẩm nào trong kho.");
            return;
        }

        System.out.println("DANH SÁCH SẢN PHẨM:");
        productMap.values().forEach(System.out::println);
    }
}

