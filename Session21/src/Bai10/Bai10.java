package Bai10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bai10 {
    private static List<Product> productList = new ArrayList<>();
    private static ShoppingCart cart = new ShoppingCart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeProducts();

        int choice = 0;
        do {
            displayMenu();
            try {
                System.out.print("Nhập lựa chọn của bạn: ");
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        displayProducts();
                        break;
                    case 2:
                        addProduct();
                        break;
                    case 3:
                        removeProduct();
                        break;
                    case 4:
                        cart.displayCart();
                        break;
                    case 5:
                        cart.checkout();
                        break;
                    case 6:
                        System.out.println("Kết thu chương trình");
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập số!");
            }

            System.out.println();
        } while (choice != 6);

        scanner.close();
    }

    private static void initializeProducts() {
        productList.add(new Product("P001", "Laptop Dell XPS 13", 30000000));
        productList.add(new Product("P002", "Điện thoại iPhone 15 Pro", 28000000));
        productList.add(new Product("P003", "Tai nghe AirPods Pro", 5000000));
        productList.add(new Product("P004", "Máy ảnh Canon EOS R6", 45000000));
        productList.add(new Product("P005", "Đồng hồ thông minh Apple Watch", 12000000));

        System.out.println("Đã khởi tạo " + productList.size() + " sản phẩm mẫu.");
    }

    private static void displayMenu() {
        System.out.println("===== MENU =====");
        System.out.println("1. Xem danh sách sản phẩm");
        System.out.println("2. Thêm sản phẩm vào giỏ hàng");
        System.out.println("3. Xóa sản phẩm khỏi giỏ hàng");
        System.out.println("4. Xem giỏ hàng");
        System.out.println("5. Thanh toán");
        System.out.println("6. Thoát");
    }


    private static void displayProducts() {
        System.out.println("======== DANH SÁCH SẢN PHẨM ========");
        System.out.println(String.format("%-5s %-30s %15s", "ID", "Tên sản phẩm", "Giá"));
        System.out.println("--------------------------------------------------");

        for (Product product : productList) {
            System.out.println(product);
        }
    }

    private static Product findProductById(String id) {
        for (Product product : productList) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }


    private static void addProduct() {
        displayProducts();

        System.out.print("Nhập mã sản phẩm muốn thêm vào giỏ: ");
        String id = scanner.nextLine();

        Product product = findProductById(id);
        if (product == null) {
            System.out.println("Lỗi: Không tìm thấy sản phẩm với mã " + id);
            return;
        }

        try {
            System.out.print("Nhập số lượng: ");
            int quantity = Integer.parseInt(scanner.nextLine());

            cart.addToCart(product, quantity);

        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Số lượng không hợp lệ!");
        } catch (InvalidQuantityException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void removeProduct() {
        cart.displayCart();

        System.out.print("Nhập mã sản phẩm muốn xóa khỏi giỏ: ");
        String id = scanner.nextLine();

        try {
            cart.removeFromCart(id);
        } catch (ProductNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
