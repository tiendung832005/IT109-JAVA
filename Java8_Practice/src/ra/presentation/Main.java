package ra.presentation;
import ra.entity.Product;
import ra.util.ProductFilter;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static List<Product> productList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    displayProductList();
                    break;
                case 2:
                    addNewProduct();
                    break;
                case 3:
                    updateProduct();
                    break;
                case 4:
                    deleteProductById();
                    break;
                case 5:
                    searchProductByName();
                    break;
                case 6:
                    filterProducts();
                    break;
                case 7:
                    sortProducts();
                    break;
                case 8:
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("**************************MENU*************************");
        System.out.println("1. Danh sách sản phẩm");
        System.out.println("2. Thêm mới sản phẩm");
        System.out.println("3. Cập nhật sản phẩm");
        System.out.println("4. Xóa sản phẩm theo ID");
        System.out.println("5. Tìm sản phẩm theo tên");
        System.out.println("6. Lọc sản phẩm theo điều kiện");
        System.out.println("7. Sắp xếp sản phẩm theo giá");
        System.out.println("8. Thoát");
        System.out.print("Chọn chức năng (1-8): ");
    }

    private static void displayProductList() {
        if (productList.isEmpty()) {
            System.out.println("Danh sách sản phẩm trống");
            return;
        }
        productList.forEach(Product::displayData);
    }

    private static void addNewProduct() {
        Product newProduct = new Product();
        newProduct.inputData(scanner);
        productList.add(newProduct);
        System.out.println("Thêm sản phẩm thành công");
    }

    private static void updateProduct() {
        System.out.print("Nhập mã sản phẩm cần cập nhật: ");
        int updateId = Integer.parseInt(scanner.nextLine());

        Optional<Product> productOptional = productList.stream()
                .filter(p -> p.getProductId() == updateId)
                .findFirst();

        if (productOptional.isPresent()) {
            Product productToUpdate = productOptional.get();
            productToUpdate.inputData(scanner);
            System.out.println("Cập nhật sản phẩm thành công");
        } else {
            System.out.println("Không tìm thấy sản phẩm");
        }
    }

    private static void deleteProductById() {
        System.out.print("Nhập mã sản phẩm cần xóa: ");
        int deleteId = Integer.parseInt(scanner.nextLine());

        boolean removed = productList.removeIf(p -> p.getProductId() == deleteId);
        if (removed) {
            System.out.println("Xóa sản phẩm thành công");
        } else {
            System.out.println("Không tìm thấy sản phẩm");
        }
    }

    private static void searchProductByName() {
        System.out.print("Nhập tên sản phẩm cần tìm: ");
        String searchName = scanner.nextLine();

        List<Product> foundProducts = productList.stream()
                .filter(p -> p.getProductName().toLowerCase().contains(searchName.toLowerCase()))
                .collect(Collectors.toList());

        if (foundProducts.isEmpty()) {
            System.out.println("Không tìm thấy sản phẩm.");
        } else {
            foundProducts.forEach(Product::displayData);
        }
    }

    private static void filterProducts() {
        System.out.println("Chọn loại lọc:");
        System.out.println("1. Lọc sản phẩm có giá lớn hơn X");
        System.out.println("2. Lọc sản phẩm theo danh mục");
        int filterChoice = Integer.parseInt(scanner.nextLine());

        ProductFilter filter;
        switch (filterChoice) {
            case 1:
                System.out.print("Nhập giá tối thiểu: ");
                float minPrice = Float.parseFloat(scanner.nextLine());
                filter = product -> product.getPrice() > minPrice;
                break;
            case 2:
                System.out.print("Nhập danh mục: ");
                String category = scanner.nextLine();
                filter = product -> product.getCategory().equalsIgnoreCase(category);
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ.");
                return;
        }

        List<Product> filteredProducts = productList.stream()
                .filter(filter::filter)
                .collect(Collectors.toList());

        if (filteredProducts.isEmpty()) {
            System.out.println("Không tìm thấy sản phẩm thỏa mãn điều kiện");
        } else {
            filteredProducts.forEach(Product::displayData);
        }
    }

    private static void sortProducts() {
        System.out.println("Chọn cách sắp xếp:");
        System.out.println("1. Sắp xếp tăng dần");
        System.out.println("2. Sắp xếp giảm dần");
        int sortChoice = Integer.parseInt(scanner.nextLine());

        List<Product> sortedProducts;
        switch (sortChoice) {
            case 1:
                sortedProducts = productList.stream()
                        .sorted(Comparator.comparing(Product::getPrice))
                        .collect(Collectors.toList());
                break;
            case 2:
                sortedProducts = productList.stream()
                        .sorted(Comparator.comparing(Product::getPrice).reversed())
                        .collect(Collectors.toList());
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ");
                return;
        }
        sortedProducts.forEach(Product::displayData);
    }
}
