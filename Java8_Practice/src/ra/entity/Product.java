package ra.entity;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Product implements IProduct {
    private static int autoId = 1;

    private int productId;
    private String productName;
    private float price;
    private String category;
    private LocalDate createdDate;

    public Product() {
        this.productId = autoId++;
        this.createdDate = LocalDate.now();
    }

    public Product(String productName, float price, String category) {
        this();
        this.productName = productName;
        this.price = price;
        this.category = category;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        if (productName.length() >= 30 && productName.length() <= 100) {
            this.productName = productName;
        } else {
            throw new IllegalArgumentException("Tên sản phẩm phải từ 30-100 ký tự");
        }
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        // Validate price
        if (price > 0) {
            this.price = price;
        } else {
            throw new IllegalArgumentException("Giá sản phẩm phải lớn hơn 0");
        }
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.println("Nhập thông tin sản phẩm:");


        while (true) {
            System.out.print("Nhập tên sản phẩm (30-100 ký tự): ");
            String name = scanner.nextLine().trim();
            try {
                setProductName(name);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            System.out.print("Nhập giá sản phẩm (>0): ");
            try {
                float inputPrice = Float.parseFloat(scanner.nextLine());
                setPrice(inputPrice);
                break;
            } catch (NumberFormatException | IllegalArgumentException e) {
                System.out.println("Giá sản phẩm không hợp lệ. Vui lòng nhập lại.");
            }
        }

        System.out.print("Nhập danh mục sản phẩm: ");
        this.category = scanner.nextLine();
    }

    @Override
    public void displayData() {
        System.out.printf("Mã SP: %d | Tên SP: %s | Giá: %.2f | Danh mục: %s | Ngày tạo: %s%n",
                productId, productName, price, category, createdDate);
    }
}