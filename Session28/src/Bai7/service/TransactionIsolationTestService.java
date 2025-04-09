package Bai7.service;

import Bai7.dao.OrderDAO;
import Bai7.model.Order;
import Bai7.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TransactionIsolationTestService {
    private final OrderDAO orderDAO;

    public TransactionIsolationTestService() {
        this.orderDAO = new OrderDAO();
    }

    public void createOrdersTable() throws SQLException {
        try (Connection connection = DatabaseUtil.getConnection()) {
            orderDAO.dropOrdersTable(connection);
            orderDAO.createOrdersTable(connection);
        }
    }

    public void testIsolationLevel(int isolationLevel) throws SQLException {
        try (Connection connection = DatabaseUtil.getConnection()) {
            orderDAO.clearOrdersTable(connection);
            orderDAO.insertOrder(connection, new Order(1, "Customer A", "Pending"));
            connection.commit();
        }

        Connection conn1 = null;
        Connection conn2 = null;
        try {
            conn1 = DatabaseUtil.getConnection();
            conn2 = DatabaseUtil.getConnection();

            conn1.setAutoCommit(false);
            conn2.setAutoCommit(false);

            conn1.setTransactionIsolation(isolationLevel);
            System.out.println("Mức cách ly kết nối 1 được đặt thành: " +
                    DatabaseUtil.getIsolationLevelName(conn1.getTransactionIsolation()));

            System.out.println("\nDữ liệu ban đầu từ Kết nối 1:");
            printAllOrders(conn1);

            System.out.println("\nKết nối 2: Chèn lệnh mới (chưa cam kết)");
            orderDAO.insertOrder(conn2, new Order(2, "Customer B", "Processing"));

            System.out.println("\nKết nối 1: Đọc dữ liệu sau khi Kết nối 2 được chèn nhưng không được cam kết:");
            printAllOrders(conn1);

            System.out.println("\nKết nối 2: Cập nhật đơn hàng hiện có (chưa cam kết)");
            orderDAO.updateOrderStatus(conn2, 1, "Shipped");

            System.out.println("\nKết nối 1: Đọc dữ liệu sau khi Kết nối 2 được cập nhật nhưng không được cam kết:");
            printAllOrders(conn1);

            System.out.println("\nKết nối 2: Cam kết thay đổi");
            conn2.commit();

            System.out.println("\nKết nối 1: Đọc dữ liệu sau khi kết nối 2 được xác nhận:");
            printAllOrders(conn1);


            System.out.println("\nKết nối 2: Chèn lệnh khác và thực hiện ngay");
            orderDAO.insertOrder(conn2, new Order(3, "Customer C", "New"));
            conn2.commit();

            System.out.println("\nKết nối 1: Đọc lại dữ liệu để kiểm tra các lần đọc ảo:");
            printAllOrders(conn1);

            conn1.commit();

        } catch (SQLException e) {
            System.err.println("Lỗi trong quá trình kiểm tra mức cách ly: " + e.getMessage());
            e.printStackTrace();

            if (conn1 != null) conn1.rollback();
            if (conn2 != null) conn2.rollback();
        } finally {
            if (conn1 != null) conn1.close();
            if (conn2 != null) conn2.close();
        }
    }

    private void printAllOrders(Connection connection) throws SQLException {
        List<Order> orders = orderDAO.getAllOrders(connection);
        if (orders.isEmpty()) {
            System.out.println(" Không tìm thấy đơn hàng nào");
        } else {
            for (Order order : orders) {
                System.out.println("  " + order);
            }
        }
    }

    public void cleanup() {
        try (Connection connection = DatabaseUtil.getConnection()) {
            orderDAO.dropOrdersTable(connection);
            System.out.println("\nCleanup completed: Orders table dropped");
        } catch (SQLException e) {
            System.err.println("Error during cleanup: " + e.getMessage());
        }
    }
}
