package ra.imp;

import ra.entity.Product;
import java.util.Scanner;

public class ProductImp {
    public static void main(String[] args) {
        Product[] products = new Product[100];
        int productCount = 0;
        Scanner scanner = new Scanner(System.in);
        boolean isExit = false;

        do {
            System.out.println("***********************MENU**************************");
            System.out.println("1. Nhập thông tin n sản phẩm (n nhập từ bàn phím)");
            System.out.println("2. Hiển thị thông tin các sản phẩm");
            System.out.println("3. Tính lợi nhuận các sản phẩm");
            System.out.println("4. Sắp xếp các sản phẩm theo lợi nhuận giảm dần");
            System.out.println("5. Thống kê các sản phẩm theo giá");
            System.out.println("6. Tìm các sản phẩm theo tên sản phẩm");
            System.out.println("7. Nhập sản phẩm");
            System.out.println("8. Bán sản phẩm");
            System.out.println("9. Cập nhật trạng thái sản phẩm");
            System.out.println("10. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Nhập số lượng sản phẩm cần thêm: ");
                    int n;
                    try {
                        n = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Số lượng không hợp lệ");
                        continue;
                    }

                    if (productCount + n > products.length) {
                        System.out.println("Không đủ không gian để thêm " + n + " sản phẩm. Còn " + (products.length - productCount) + " vị trí trống.");
                        continue;
                    }

                    for (int i = 0; i < n; i++) {
                        System.out.println("Nhập thông tin sản phẩm thứ " + (i + 1) + ":");
                        products[productCount] = new Product();
                        products[productCount].inputData(scanner, products);
                        productCount++;
                    }
                    break;

                case 2:
                    if (productCount == 0) {
                        System.out.println("Chưa có sản phẩm nào trong danh sách");
                    } else {
                        System.out.println("DANH SÁCH SẢN PHẨM:");
                        for (int i = 0; i < productCount; i++) {
                            System.out.println("Sản phẩm " + (i + 1) + ":");
                            products[i].displayData();
                            System.out.println("--------------------------");
                        }
                    }
                    break;

                case 3:
                    if (productCount == 0) {
                        System.out.println("Chưa có sản phẩm nào trong danh sách");
                    } else {
                        System.out.println("TÍNH LỢI NHUẬN CHO TẤT CẢ SẢN PHẨM:");
                        for (int i = 0; i < productCount; i++) {
                            products[i].calProfit();
                            System.out.println("Sản phẩm " + products[i].getProductName() + " có lợi nhuận: " + products[i].getProfit());
                        }
                    }
                    break;

                case 4:
                    if (productCount == 0) {
                        System.out.println("Chưa có sản phẩm nào trong danh sách!");
                    } else {
                        for (int i = 0; i < productCount; i++) {
                            products[i].calProfit();
                        }

                        for (int i = 0; i < productCount - 1; i++) {
                            for (int j = 0; j < productCount - i - 1; j++) {
                                if (products[j].getProfit() < products[j + 1].getProfit()) {
                                    // Swap products
                                    Product temp = products[j];
                                    products[j] = products[j + 1];
                                    products[j + 1] = temp;
                                }
                            }
                        }

                        System.out.println("Sản phẩm đã được sắp xếp theo lợi nhuận giảm dần");
                        System.out.println("DANH SÁCH SẢN PHẨM SAU KHI SẮP XẾP:");
                        for (int i = 0; i < productCount; i++) {
                            System.out.println("Sản phẩm " + (i + 1) + ": " + products[i].getProductName() +
                                    " - Lợi nhuận: " + products[i].getProfit());
                        }
                    }
                    break;

                case 5:
                    if (productCount == 0) {
                        System.out.println("Chưa có sản phẩm nào trong danh sách");
                    } else {
                        System.out.println("THỐNG KÊ SẢN PHẨM THEO GIÁ:");

                        float fromPrice, toPrice;
                        try {
                            System.out.print("Nhập giá bắt đầu (fromPrice): ");
                            fromPrice = Float.parseFloat(scanner.nextLine());
                            System.out.print("Nhập giá kết thúc (toPrice): ");
                            toPrice = Float.parseFloat(scanner.nextLine());

                            if (fromPrice > toPrice) {
                                System.out.println("Giá bắt đầu phải nhỏ hơn hoặc bằng giá kết thúc!");
                                continue;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Giá không hợp lệ!");
                            continue;
                        }

                        int count = 0;
                        System.out.println("Các sản phẩm có giá từ " + fromPrice + " đến " + toPrice + ":");
                        for (int i = 0; i < productCount; i++) {
                            if (products[i].getExportPrice() >= fromPrice && products[i].getExportPrice() <= toPrice) {
                                System.out.println("- " + products[i].getProductName() + " (Giá: " + products[i].getExportPrice() + ")");
                                count++;
                            }
                        }

                        System.out.println("Tổng số sản phẩm trong khoảng giá: " + count);
                    }
                    break;

                case 6:
                    if (productCount == 0) {
                        System.out.println("Chưa có sản phẩm nào trong danh sách!");
                    } else {
                        System.out.print("Nhập tên sản phẩm cần tìm: ");
                        String searchName = scanner.nextLine().trim().toLowerCase();

                        boolean found = false;
                        System.out.println("KẾT QUẢ TÌM KIẾM:");
                        for (int i = 0; i < productCount; i++) {
                            if (products[i].getProductName().toLowerCase().contains(searchName)) {
                                products[i].displayData();
                                System.out.println("--------------------------");
                                found = true;
                            }
                        }

                        if (!found) {
                            System.out.println("Không tìm thấy sản phẩm nào có tên chứa '" + searchName + "'");
                        }
                    }
                    break;

                case 7:
                    if (productCount == 0) {
                        System.out.println("Chưa có sản phẩm nào trong danh sách!");
                    } else {
                        System.out.print("Nhập mã sản phẩm cần nhập thêm số lượng: ");
                        String importId = scanner.nextLine().trim();

                        int productIndex = -1;
                        for (int i = 0; i < productCount; i++) {
                            if (products[i].getProductId().equals(importId)) {
                                productIndex = i;
                                break;
                            }
                        }

                        if (productIndex == -1) {
                            System.out.println("Không tìm thấy sản phẩm có mã " + importId);
                        } else {
                            System.out.print("Nhập số lượng cần nhập thêm: ");
                            try {
                                int additionalQuantity = Integer.parseInt(scanner.nextLine());
                                if (additionalQuantity <= 0) {
                                    System.out.println("Số lượng nhập thêm phải lớn hơn 0");
                                } else {
                                    int currentQuantity = products[productIndex].getQuantity();
                                    products[productIndex].setQuantity(currentQuantity + additionalQuantity);
                                    System.out.println("Đã cập nhật số lượng sản phẩm " + products[productIndex].getProductName() +
                                            " từ " + currentQuantity + " thành " + products[productIndex].getQuantity());
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Số lượng không hợp lệ");
                            }
                        }
                    }
                    break;

                case 8:
                    if (productCount == 0) {
                        System.out.println("Chưa có sản phẩm nào trong danh sách");
                    } else {
                        System.out.print("Nhập tên sản phẩm cần bán: ");
                        String sellName = scanner.nextLine().trim();

                        int productIndex = -1;
                        for (int i = 0; i < productCount; i++) {
                            if (products[i].getProductName().equals(sellName)) {
                                productIndex = i;
                                break;
                            }
                        }

                        if (productIndex == -1) {
                            System.out.println("Không tìm thấy sản phẩm có tên " + sellName);
                        } else {
                            System.out.print("Nhập số lượng cần bán: ");
                            try {
                                int sellQuantity = Integer.parseInt(scanner.nextLine());
                                int currentQuantity = products[productIndex].getQuantity();

                                if (sellQuantity <= 0) {
                                    System.out.println("Số lượng bán phải lớn hơn 0");
                                } else if (sellQuantity > currentQuantity) {
                                    System.out.println("Số lượng bán vượt quá số lượng hiện có (" + currentQuantity + ")!");
                                } else {
                                    products[productIndex].setQuantity(currentQuantity - sellQuantity);
                                    System.out.println("Đã bán " + sellQuantity + " sản phẩm " + products[productIndex].getProductName() +
                                            ". Số lượng còn lại: " + products[productIndex].getQuantity());
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Số lượng không hợp lệ");
                            }
                        }
                    }
                    break;

                case 9:
                    if (productCount == 0) {
                        System.out.println("Chưa có sản phẩm nào trong danh sách!");
                    } else {
                        System.out.print("Nhập mã sản phẩm cần cập nhật trạng thái: ");
                        String updateId = scanner.nextLine().trim();

                        int productIndex = -1;
                        for (int i = 0; i < productCount; i++) {
                            if (products[i].getProductId().equals(updateId)) {
                                productIndex = i;
                                break;
                            }
                        }

                        if (productIndex == -1) {
                            System.out.println("Không tìm thấy sản phẩm có mã " + updateId);
                        } else {
                            boolean currentStatus = products[productIndex].isStatus();
                            products[productIndex].setStatus(!currentStatus);

                            System.out.println("Đã cập nhật trạng thái sản phẩm " + products[productIndex].getProductName() +
                                    " từ " + (currentStatus ? "Đang bán" : "Không bán") +
                                    " thành " + (products[productIndex].isStatus() ? "Đang bán" : "Không bán"));
                        }
                    }
                    break;

                case 10:
                    System.out.println("Thoát chương trình");
                    isExit = true;
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ");
                    break;
            }

        } while (!isExit);

        scanner.close();
    }
}