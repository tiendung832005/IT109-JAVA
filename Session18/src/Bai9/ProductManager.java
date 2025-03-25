package Bai9;

import java.util.Scanner;

public class ProductManager {
    public static void main(String[] args) {
        ProductService productService = new ProductService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    productService.addProduct();
                    break;
                case 2:
                    productService.updateProduct();
                    break;
                case 3:
                    productService.deleteProduct();
                    break;
                case 4:
                    productService.calculateTotalInventoryValue();
                    break;
                case 5:
                    productService.displayAllProducts();
                    break;
                case 6:
                    System.out.println("Thoát chương trình");
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n--- QUẢN LÝ SẢN PHẨM ---");
        System.out.println("1. Thêm sản phẩm mới");
        System.out.println("2. Cập nhật sản phẩm");
        System.out.println("3. Xóa sản phẩm");
        System.out.println("4. Tính tổng giá trị kho");
        System.out.println("5. Hiển thị tất cả sản phẩm");
        System.out.println("6. Thoát");
        System.out.print("Chọn chức năng: ");
    }
}