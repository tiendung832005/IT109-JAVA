package ra.entity;

import java.util.Scanner;

public class Product {
    private String productId;
    private String productName;
    private float importPrice;
    private float exportPrice;
    private float profit;
    private int quantity;
    private String descriptions;
    private boolean status;

    public Product() {
    }

    public Product(String productId, String productName, float importPrice, float exportPrice,
                   int quantity, String descriptions, boolean status) {
        this.productId = productId;
        this.productName = productName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.quantity = quantity;
        this.descriptions = descriptions;
        this.status = status;
        this.calProfit();
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getProfit() {
        return profit;
    }

    public void setProfit(float profit) {
        this.profit = profit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void inputData(Scanner scanner, Product[] arrProduct) {
        boolean isValidProductId = false;
        do {
            System.out.print("Nhập mã sản phẩm (4 ký tự): ");
            String inputId = scanner.nextLine().trim();

            if (inputId.length() == 4) {
                boolean isDuplicate = false;
                for (Product product : arrProduct) {
                    if (product != null && product.getProductId() != null && product.getProductId().equals(inputId)) {
                        isDuplicate = true;
                        System.out.println("Mã sản phẩm đã tồn tại");
                        break;
                    }
                }

                if (!isDuplicate) {
                    this.productId = inputId;
                    isValidProductId = true;
                }
            } else {
                System.out.println("Mã sản phẩm phải gồm 4 ký tự");
            }
        } while (!isValidProductId);

        boolean isValidProductName = false;
        do {
            System.out.print("Nhập tên sản phẩm (6-50 ký tự): ");
            String inputName = scanner.nextLine().trim();

            if (inputName.length() >= 6 && inputName.length() <= 50) {
                // Check for duplicates
                boolean isDuplicate = false;
                for (Product product : arrProduct) {
                    if (product != null && product.getProductName() != null && product.getProductName().equals(inputName)) {
                        isDuplicate = true;
                        System.out.println("Tên sản phẩm đã tồn tại");
                        break;
                    }
                }

                if (!isDuplicate) {
                    this.productName = inputName;
                    isValidProductName = true;
                }
            } else {
                System.out.println("Tên sản phẩm phải từ 6-50 ký tự");
            }
        } while (!isValidProductName);

        boolean isValidImportPrice = false;
        do {
            System.out.print("Nhập giá nhập: ");
            try {
                float inputImportPrice = Float.parseFloat(scanner.nextLine());
                if (inputImportPrice > 0) {
                    this.importPrice = inputImportPrice;
                    isValidImportPrice = true;
                } else {
                    System.out.println("Giá nhập phải lớn hơn 0");
                }
            } catch (NumberFormatException e) {
                System.out.println("Giá nhập không hợp lệ");
            }
        } while (!isValidImportPrice);

        boolean isValidExportPrice = false;
        do {
            System.out.print("Nhập giá xuất: ");
            try {
                float inputExportPrice = Float.parseFloat(scanner.nextLine());
                float minExportPrice = importPrice * 1.2f;
                if (inputExportPrice >= minExportPrice) {
                    this.exportPrice = inputExportPrice;
                    isValidExportPrice = true;
                } else {
                    System.out.println("Giá xuất phải lớn hơn ít nhất 20% so với giá nhập");
                    System.out.println("Giá xuất tối thiểu: " + minExportPrice);
                }
            } catch (NumberFormatException e) {
                System.out.println("Giá xuất không hợp lệ");
            }
        } while (!isValidExportPrice);

        boolean isValidQuantity = false;
        do {
            System.out.print("Nhập số lượng sản phẩm: ");
            try {
                int inputQuantity = Integer.parseInt(scanner.nextLine());
                if (inputQuantity > 0) {
                    this.quantity = inputQuantity;
                    isValidQuantity = true;
                } else {
                    System.out.println("Số lượng sản phẩm phải lớn hơn 0");
                }
            } catch (NumberFormatException e) {
                System.out.println("Số lượng không hợp lệ");
            }
        } while (!isValidQuantity);

        System.out.print("Nhập mô tả sản phẩm: ");
        this.descriptions = scanner.nextLine().trim();

        System.out.print("Nhập trạng thái sản phẩm (true - Đang bán, false - Không bán): ");
        this.status = Boolean.parseBoolean(scanner.nextLine());

        // Calculate profit
        this.calProfit();
    }

    public void displayData() {
        System.out.println("Thông tin sản phẩm:");
        System.out.println("Mã sản phẩm: " + this.productId);
        System.out.println("Tên sản phẩm: " + this.productName);
        System.out.println("Giá nhập: " + this.importPrice);
        System.out.println("Giá xuất: " + this.exportPrice);
        System.out.println("Lợi nhuận: " + this.profit);
        System.out.println("Số lượng: " + this.quantity);
        System.out.println("Mô tả: " + this.descriptions);
        System.out.println("Trạng thái: " + (this.status ? "Đang bán" : "Không bán"));
    }

    public void calProfit() {
        this.profit = this.exportPrice - this.importPrice;
    }
}