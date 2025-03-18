package entity2;
import java.util.Scanner;


/*
* Giải thích các phần được bổ sung:
Danh sách sản phẩm (Option 1):

Hiển thị toàn bộ sản phẩm hiện có trong mảng products.
Thêm mới sản phẩm (Option 2):

Sau khi nhập thông tin sản phẩm, kiểm tra mã danh mục phải tồn tại thì mới cho phép thêm sản phẩm đó.
Nếu không có danh mục hợp lệ, thông báo lỗi cho người dùng.
Cập nhật sản phẩm (Option 3):

Cho phép nhập mã sản phẩm cần cập nhật, tìm và cập nhật thông tin mới.
Xóa sản phẩm (Option 4):

Tìm và xóa sản phẩm dựa theo mã sản phẩm nhập vào. Sau khi xóa, dịch mảng để tránh phần tử rỗng.
Tìm kiếm sản phẩm theo tên (Option 5):

Cho phép tìm kiếm sản phẩm dựa theo tên nhập vào (không phân biệt hoa thường).
Thoát (Option 6):

Thoát ra menu chính.
* */
public interface IApp {
    void inputData(Scanner scanner); // Phương thức nhập dữ liệu
    void displayData(); // Phương thức hiển thị dữ liệu
    double INTEREST = 1.1; // Hằng số tỷ lệ giá xuất/giá nhập
}

class Categories implements IApp {
    private static int AUTO_ID = 1; // Biến static để tự động tăng mã danh mục
    private int categoryId; // Mã danh mục
    private String categoryName; // Tên danh mục
    private int priority; // Độ ưu tiên
    private String description; // Mô tả danh mục
    private boolean status; // Trạng thái hoạt động

    public Categories() {
        this.categoryId = AUTO_ID++; // Gán mã danh mục tự động
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
        // Nhập dữ liệu cho danh mục
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
    // Hiển thị dữ liệu cho danh mục
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
    private String productId; // Mã sản phẩm
    private String productName; // Tên sản phẩm
    private float importPrice; // Giá nhập
    private float exportPrice; // Giá xuất
    private String title; // Tiêu đề sản phẩm
    private String description; // Mô tả sản phẩm
    private int quantity; // Số lượng tồn kho
    private int categoryId; // Mã danh mục của sản phẩm
    private int status; // Trạng thái sản phẩm

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
    // Nhập dữ liệu cho sản phẩm
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
    // Hiển thị dữ liệu cho sản phẩm
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
        Categories[] categories = new Categories[100]; // Mảng chứa danh mục
        Product[] products = new Product[100]; // Mảng chứa sản phẩm
        int categoryCount = 0; // Số lượng danh mục
        int productCount = 0; // Số lượng sản phẩm

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
                    System.out.println("5. Tìm kiếm sản phẩm theo tên");
                    System.out.println("6. Thoát");
                    System.out.print("Chọn: ");
                    int p = Integer.parseInt(scanner.nextLine());

                    if (p == 1) {
                        for (int i = 0; i < productCount; i++) {
                            products[i].displayData();
                        }
                    } else if (p == 2) {
                        Product product = new Product();
                        product.inputData(scanner);
                        boolean isExistCategory = false;
                        for (int i = 0; i < categoryCount; i++) {
                            if (categories[i].getCategoryId() == product.getCategoryId()) {
                                isExistCategory = true;
                                break;
                            }
                        }
                        if (!isExistCategory) {
                            System.out.println("Mã danh mục không tồn tại. Vui lòng thêm danh mục trước khi thêm sản phẩm.");
                        } else {
                            products[productCount] = product;
                            productCount++;
                        }
                    } else if (p == 3) {
                        System.out.print("Nhập mã sản phẩm cần cập nhật: ");
                        String id = scanner.nextLine();
                        boolean found = false;
                        for (int i = 0; i < productCount; i++) {
                            if (products[i].getProductId().equals(id)) {
                                products[i].inputData(scanner);
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Không tìm thấy sản phẩm có mã: " + id);
                        }
                    } else if (p == 4) {
                        System.out.print("Nhập mã sản phẩm cần xóa: ");
                        String id = scanner.nextLine();
                        boolean deleted = false;
                        for (int i = 0; i < productCount; i++) {
                            if (products[i].getProductId().equals(id)) {
                                for (int j = i; j < productCount - 1; j++) {
                                    products[j] = products[j + 1];
                                }
                                productCount--;
                                deleted = true;
                                System.out.println("Đã xóa sản phẩm thành công.");
                                break;
                            }
                        }
                        if (!deleted) {
                            System.out.println("Không tìm thấy sản phẩm cần xóa.");
                        }
                    } else if (p == 5) {
                        System.out.print("Nhập tên sản phẩm cần tìm: ");
                        String name = scanner.nextLine();
                        boolean found = false;
                        for (int i = 0; i < productCount; i++) {
                            if (products[i].getProductName().toLowerCase().contains(name.toLowerCase())) {
                                products[i].displayData();
                                found = true;
                            }
                        }
                        if (!found) {
                            System.out.println("Không tìm thấy sản phẩm nào phù hợp.");
                        }
                    } else if (p == 6) {
                        break;
                    } else {
                        System.out.println("Vui lòng chọn đúng chức năng!");
                    }
                }
            } else if (choice == 3) {
                System.out.println("Thoát chương trình.");
                break;
            } else {
                System.out.println("Vui lòng chọn đúng chức năng!");
            }
        }
    }
}