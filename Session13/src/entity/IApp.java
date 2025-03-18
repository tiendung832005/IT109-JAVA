package entity;
import java.util.Scanner;

public interface IApp {
    void inputData(Scanner scanner);
    void displayData();
    double INTEREST = 1.1;

}

class Categories implements IApp {
    private static int AUTO_ID = 1;
    private int categoryId;
    private String categoryName;
    private int priority;
    private String description;
    private boolean status;

    public Categories() {
        this.categoryId = AUTO_ID++;
    }

    public Categories(String categoryName, int priority, String description, boolean status) {
        this.categoryId = AUTO_ID++;
        this.categoryName = categoryName;
        this.priority = priority;
        this.description = description;
        this.status = status;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.println("Nhập tên danh mục:");
        categoryName = scanner.nextLine();
        while (categoryName.length() < 6 || categoryName.length() > 50) {
            System.out.println("Tên danh mục phải từ 6 đến 50 ký tự:");
            categoryName = scanner.nextLine();
        }
        System.out.println("Nhập độ ưu tiên:");
        priority = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập mô tả danh mục:");
        description = scanner.nextLine();
        if (description.length() > 255) {
            description = description.substring(0, 255);
        }
        System.out.println("Nhập trạng thái danh mục (true/false):");
        status = Boolean.parseBoolean(scanner.nextLine());
    }

    @Override
    public void displayData() {
        System.out.println("Mã danh mục: " + categoryId);
        System.out.println("Tên danh mục: " + categoryName);
        System.out.println("Độ ưu tiên: " + priority);
        System.out.println("Mô tả: " + description);
        System.out.println("Trạng thái: " + (status ? "Hoạt động" : "Không hoạt động"));
    }
}



class Product implements IApp {
    private String productId;
    private String productName;
    private float importPrice;
    private float exportPrice;
    private String title;
    private String description;
    private int quantity;
    private int categoryId;
    private int status;

    public Product() {
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.println("Nhập mã sản phẩm:");
        productId = scanner.nextLine();
        while (!productId.matches("[CET]{1}\\w{4}")) {
            System.out.println("Mã phải 5 ký tự, bắt đầu là C,E,T:");
            productId = scanner.nextLine();
        }
        System.out.println("Nhập tên sản phẩm:");
        productName = scanner.nextLine();
        while (productName.length() < 10 || productName.length() > 100) {
            System.out.println("Tên sản phẩm 10-100 ký tự:");
            productName = scanner.nextLine();
        }
        System.out.println("Nhập giá nhập:");
        importPrice = Float.parseFloat(scanner.nextLine());
        while (importPrice <= 0) {
            System.out.println("Giá nhập phải > 0:");
            importPrice = Float.parseFloat(scanner.nextLine());
        }
        System.out.println("Nhập giá xuất:");
        exportPrice = Float.parseFloat(scanner.nextLine());
        while (exportPrice < importPrice * INTEREST) {
            System.out.println("Giá xuất phải lớn hơn giá nhập:");
            exportPrice = Float.parseFloat(scanner.nextLine());
        }
        System.out.println("Nhập tiêu đề:");
        title = scanner.nextLine();
        if (title.length() > 200) {
            title = title.substring(0, 200);
        }
        System.out.println("Nhập mô tả:");
        description = scanner.nextLine();
        System.out.println("Nhập số lượng:");
        quantity = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập mã danh mục:");
        categoryId = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập trạng thái (0: Hoạt động, 1: Hết hàng, 2: Không hoạt động):");
        status = Integer.parseInt(scanner.nextLine());
    }

    @Override
    public void displayData() {
        System.out.println("Mã SP: " + productId);
        System.out.println("Tên SP: " + productName);
        System.out.println("Giá nhập: " + importPrice);
        System.out.println("Giá xuất: " + exportPrice);
        System.out.println("Tiêu đề: " + title);
        System.out.println("Mô tả: " + description);
        System.out.println("Số lượng: " + quantity);
        System.out.println("Mã danh mục: " + categoryId);
        String statusStr = (status == 0) ? "Đang hoạt động" : (status == 1) ? "Hết hàng" : "Không hoạt động";
        System.out.println("Trạng thái: " + statusStr);
    }
}

class ShopManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Categories[] categories = new Categories[100];
        Product[] products = new Product[100];
        int categoryCount = 0;
        int productCount = 0;

        while (true) {
            System.out.println("*********************SHOP MENU*********************");
            System.out.println("1. Quản lý danh mục");
            System.out.println("2. Quản lý sản phẩm");
            System.out.println("3. Thoát");
            System.out.print("Chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());

            if (choice == 1) {
                while (true) {
                    System.out.println("********************CATEGORIE MANAGEMENT*********************");
                    System.out.println("1. Danh sách danh mục");
                    System.out.println("2. Thêm mới danh mục");
                    System.out.println("3. Cập nhật danh mục");
                    System.out.println("4. Xóa danh mục");
                    System.out.println("5. Tìm kiếm danh mục theo tên");
                    System.out.println("6. Thoát");
                    System.out.print("Chọn: ");
                    int c = Integer.parseInt(scanner.nextLine());

                    if (c == 1) {
                        for (int i = 0; i < categoryCount; i++) {
                            categories[i].displayData();
                        }
                    } else if (c == 2) {
                        Categories category = new Categories();
                        category.inputData(scanner);
                        categories[categoryCount] = category;
                        categoryCount++;
                    } else if (c == 3) {
                        System.out.print("Nhập mã danh mục cần cập nhật: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        for (int i = 0; i < categoryCount; i++) {
                            if (categories[i].getCategoryId() == id) {
                                categories[i].inputData(scanner);
                            }
                        }
                    } else if (c == 4) {
                        System.out.print("Nhập mã danh mục cần xóa: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        boolean found = false;
                        for (int i = 0; i < productCount; i++) {
                            if (products[i].getCategoryId() == id) {
                                found = true;
                            }
                        }
                        if (!found) {
                            for (int i = 0; i < categoryCount; i++) {
                                if (categories[i].getCategoryId() == id) {
                                    for (int j = i; j < categoryCount - 1; j++) {
                                        categories[j] = categories[j + 1];
                                    }
                                    categoryCount--;
                                    break;
                                }
                            }
                        }
                    } else if (c == 5) {
                        System.out.print("Nhập tên danh mục cần tìm: ");
                        String name = scanner.nextLine();
                        for (int i = 0; i < categoryCount; i++) {
                            if (categories[i].getCategoryName().equals(name)) {
                                categories[i].displayData();
                            }
                        }
                    } else if (c == 6) {
                        break;
                    }
                }
            } else if (choice == 2) {
                while (true) {
                    System.out.println("************************PRODUCT MANAGEMENT*******************");
                    System.out.println("1. Danh sách sản phẩm");
                    System.out.println("2. Thêm mới sản phẩm");
                    System.out.println("3. Cập nhật sản phẩm");
                    System.out.println("4. Xóa sản phẩm");
                    System.out.println("5. Tìm kiếm sản phẩm theo tên hoặc tiêu đề");
                    System.out.println("6. Tìm kiếm sản phẩm theo khoảng giá bán");
                    System.out.println("7. Thoát");
                    System.out.print("Chọn: ");
                    int p = Integer.parseInt(scanner.nextLine());

                    if (p == 1) {
                        for (int i = 0; i < productCount; i++) {
                            products[i].displayData();
                        }
                    } else if (p == 2) {
                        Product product = new Product();
                        product.inputData(scanner);
                        products[productCount] = product;
                        productCount++;
                    } else if (p == 3) {
                        System.out.print("Nhập mã sản phẩm cần cập nhật: ");
                        String id = scanner.nextLine();
                        for (int i = 0; i < productCount; i++) {
                            if (products[i].getProductId().equals(id)) {
                                products[i].inputData(scanner);
                            }
                        }
                    } else if (p == 4) {
                        System.out.print("Nhập mã sản phẩm cần xóa: ");
                        String id = scanner.nextLine();
                        for (int i = 0; i < productCount; i++) {
                            if (products[i].getProductId().equals(id)) {
                                for (int j = i; j < productCount - 1; j++) {
                                    products[j] = products[j + 1];
                                }
                                productCount--;
                                break;
                            }
                        }
                    } else if (p == 5) {
                        System.out.print("Nhập tên hoặc tiêu đề sản phẩm: ");
                        String name = scanner.nextLine();
                        for (int i = 0; i < productCount; i++) {
                            if (products[i].getProductName().equals(name) || products[i].getTitle().equals(name)) {
                                products[i].displayData();
                            }
                        }
                    } else if (p == 6) {
                        System.out.print("Nhập giá thấp nhất: ");
                        float min = Float.parseFloat(scanner.nextLine());
                        System.out.print("Nhập giá cao nhất: ");
                        float max = Float.parseFloat(scanner.nextLine());
                        for (int i = 0; i < productCount; i++) {
                            if (products[i].getExportPrice() >= min && products[i].getExportPrice() <= max) {
                                products[i].displayData();
                            }
                        }
                    } else if (p == 7) {
                        break;
                    }
                }
            } else if (choice == 3) {
                break;
            }
        }
    }
}