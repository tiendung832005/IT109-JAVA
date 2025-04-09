import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Bai5 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/order_management";
    private static final String USER = "root";
    private static final String PASS = "12345678";

    public static void main(String[] args) {
        Connection conn = null;

        try {
            System.out.println("Đang kết nối đến cơ sở dữ liệu...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Kết nối thành công!");

            List<OrderDetail> orderDetails1 = new ArrayList<>();
            orderDetails1.add(new OrderDetail("Laptop", 2));
            orderDetails1.add(new OrderDetail("Chuột", 5));
            orderDetails1.add(new OrderDetail("Bàn phím", 3));

            createOrderWithDetails(conn, "Nguyễn Văn A", LocalDate.now(), orderDetails1);

            List<OrderDetail> orderDetails2 = new ArrayList<>();
            orderDetails2.add(new OrderDetail("Màn hình", 1));
            orderDetails2.add(new OrderDetail("Tai nghe", -2)); // Số lượng âm, sẽ gây lỗi
            orderDetails2.add(new OrderDetail("Webcam", 4));

            createOrderWithDetails(conn, "Trần Thị B", LocalDate.now(), orderDetails2);

            displayAllOrders(conn);

        } catch (SQLException e) {
            System.out.println("Lỗi cơ sở dữ liệu!");
            e.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                    System.out.println("Đã đóng kết nối!");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    private static void createOrderWithDetails(Connection conn, String customerName,
                                               LocalDate orderDate, List<OrderDetail> details) {
        boolean initialAutoCommit = false;

        try {
            initialAutoCommit = conn.getAutoCommit();

            conn.setAutoCommit(false);
            System.out.println("\n--- Bắt đầu giao dịch tạo đơn hàng mới ---");

            int orderId = createOrder(conn, customerName, orderDate);
            System.out.println("Đã tạo đơn hàng cho khách hàng: " + customerName);

            for (OrderDetail detail : details) {
                addOrderDetail(conn, orderId, detail.productName, detail.quantity);
                System.out.println("Đã thêm chi tiết: " + detail.productName + " - SL: " + detail.quantity);
            }

            conn.commit();
            System.out.println("Giao dịch thành công, đã commit!");

        } catch (SQLException e) {
            try {
                System.out.println("Lỗi trong quá trình tạo đơn hàng: " + e.getMessage());
                System.out.println("Đang rollback giao dịch...");
                conn.rollback();
                System.out.println("Đã rollback giao dịch thành công!");
            } catch (SQLException rollbackEx) {
                System.out.println("Lỗi khi rollback: " + rollbackEx.getMessage());
                rollbackEx.printStackTrace();
            }
        } finally {
            try {
                conn.setAutoCommit(initialAutoCommit);
            } catch (SQLException e) {
                System.out.println("Lỗi khi khôi phục trạng thái auto-commit: " + e.getMessage());
                e.printStackTrace();
            }
            System.out.println("--- Kết thúc giao dịch ---\n");
        }
    }


    private static int createOrder(Connection conn, String customerName, LocalDate orderDate)
            throws SQLException {
        String sql = "INSERT INTO Orders (customer_name, order_date) VALUES (?, ?)";

        PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pstmt.setString(1, customerName);
        pstmt.setDate(2, Date.valueOf(orderDate));

        int rowsAffected = pstmt.executeUpdate();

        if (rowsAffected == 0) {
            throw new SQLException("Tạo đơn hàng thất bại, không có dòng nào được thêm vào!");
        }

        ResultSet generatedKeys = pstmt.getGeneratedKeys();
        int orderId;

        if (generatedKeys.next()) {
            orderId = generatedKeys.getInt(1);
        } else {
            throw new SQLException("Tạo đơn hàng thất bại, không lấy được ID!");
        }

        generatedKeys.close();
        pstmt.close();

        return orderId;
    }

    private static void addOrderDetail(Connection conn, int orderId, String productName, int quantity)
            throws SQLException {
        if (quantity <= 0) {
            throw new SQLException("Số lượng sản phẩm phải lớn hơn 0: " + productName + ", SL: " + quantity);
        }

        String sql = "INSERT INTO OrderDetails (order_id, product_name, quantity) VALUES (?, ?, ?)";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, orderId);
        pstmt.setString(2, productName);
        pstmt.setInt(3, quantity);

        int rowsAffected = pstmt.executeUpdate();

        if (rowsAffected == 0) {
            throw new SQLException("Thêm chi tiết đơn hàng thất bại cho sản phẩm: " + productName);
        }

        pstmt.close();
    }

    private static void displayAllOrders(Connection conn) throws SQLException {
        String sql = "SELECT o.order_id, o.customer_name, o.order_date, " +
                "d.detail_id, d.product_name, d.quantity " +
                "FROM Orders o LEFT JOIN OrderDetails d ON o.order_id = d.order_id " +
                "ORDER BY o.order_id, d.detail_id";

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        int currentOrderId = -1;
        System.out.println("\n========== DANH SÁCH ĐƠN HÀNG ==========");

        while (rs.next()) {
            int orderId = rs.getInt("order_id");

            if (orderId != currentOrderId) {
                currentOrderId = orderId;
                String customerName = rs.getString("customer_name");
                Date orderDate = rs.getDate("order_date");

                System.out.println("\nĐơn hàng #" + orderId);
                System.out.println("Khách hàng: " + customerName);
                System.out.println("Ngày đặt: " + orderDate);
                System.out.println("Chi tiết đơn hàng:");
                System.out.println("-------------------------------");
                System.out.printf("%-5s %-20s %-10s\n", "ID", "Sản phẩm", "Số lượng");
                System.out.println("-------------------------------");
            }

            Integer detailId = rs.getInt("detail_id");
            if (!rs.wasNull()) {  // Kiểm tra nếu có chi tiết đơn hàng
                String productName = rs.getString("product_name");
                int quantity = rs.getInt("quantity");

                System.out.printf("%-5d %-20s %-10d\n", detailId, productName, quantity);
            } else {
                System.out.println("(Không có chi tiết đơn hàng)");
            }
        }

        System.out.println("\n========================================");

        rs.close();
        stmt.close();
    }

    private static class OrderDetail {
        private String productName;
        private int quantity;

        public OrderDetail(String productName, int quantity) {
            this.productName = productName;
            this.quantity = quantity;
        }
    }
}