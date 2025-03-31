package Bai10;

import java.util.ArrayList;
import java.util.List;

class ShoppingCart {
    private List<CartItem> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }


    public void addToCart(Product product, int quantity) throws InvalidQuantityException {
        if (quantity <= 0) {
            throw new InvalidQuantityException("Lỗi: Số lượng không hợp lệ");
        }


        for (CartItem item : items) {
            if (item.getProduct().getId().equals(product.getId())) {
                // Cập nhật số lượng nếu sản phẩm đã tồn tại
                item.setQuantity(item.getQuantity() + quantity);
                System.out.println("Đã cập nhật số lượng sản phẩm trong giỏ hàng.");
                return;
            }
        }


        items.add(new CartItem(product, quantity));
        System.out.println("Đã thêm sản phẩm vào giỏ hàng.");
    }

    public void removeFromCart(String productId) throws ProductNotFoundException {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getProduct().getId().equals(productId)) {
                items.remove(i);
                System.out.println("Đã xóa sản phẩm khỏi giỏ hàng.");
                return;
            }
        }

        throw new ProductNotFoundException("Lỗi: Không tìm thấy sản phẩm trong giỏ hàng!");
    }

    public void displayCart() {
        if (items.isEmpty()) {
            System.out.println("Giỏ hàng trống.");
            return;
        }

        System.out.println("======== GIỎ HÀNG CỦA BẠN ========");
        System.out.println(String.format("%-5s %-30s %10s %10s %15s", "ID", "Tên sản phẩm", "Đơn giá", "Số lượng", "Thành tiền"));
        System.out.println("-----------------------------------------------------------------------------------");

        for (CartItem item : items) {
            Product product = item.getProduct();
            System.out.println(String.format("%-5s %-30s %,10.0f %10d %,15.0f",
                    product.getId(), product.getName(), product.getPrice(),
                    item.getQuantity(), item.getSubtotal()));
        }

        System.out.println("-----------------------------------------------------------------------------------");
    }

    public void checkout() {
        if (items.isEmpty()) {
            System.out.println("Giỏ hàng trống. Không thể thanh toán.");
            return;
        }

        double total = 0;
        for (CartItem item : items) {
            total += item.getSubtotal();
        }

        System.out.println("====== THANH TOÁN ======");
        displayCart();
        System.out.println(String.format("Tổng tiền cần thanh toán: %,15.0f VNĐ", total));
        System.out.println("=======================");
    }
}
