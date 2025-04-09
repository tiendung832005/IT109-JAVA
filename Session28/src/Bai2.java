import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Bai2 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASS = "12345678";

    public static void main(String[] args) {
        Connection conn = null;

        try {
            System.out.println("Đang kết nối đến cơ sở dữ liệu...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Kết nối thành công!");

            boolean initialAutoCommit = conn.getAutoCommit();
            conn.setAutoCommit(false);
            System.out.println("Đã tắt chế độ auto-commit: " + conn.getAutoCommit());

            try {
                String insertSQL1 = "INSERT INTO users (id, name, email) VALUES (?, ?, ?)";
                PreparedStatement pstmt1 = conn.prepareStatement(insertSQL1);

                int userId1 = 100;
                pstmt1.setInt(1, userId1);
                pstmt1.setString(2, "Nguyen Van A");
                pstmt1.setString(3, "nguyenvana@example.com");

                int rowsAffected1 = pstmt1.executeUpdate();
                System.out.println("Câu lệnh INSERT đầu tiên - Số dòng đã thêm: " + rowsAffected1);

                String insertSQL2 = "INSERT INTO users (id, name, email) VALUES (?, ?, ?)";
                PreparedStatement pstmt2 = conn.prepareStatement(insertSQL2);

                pstmt2.setInt(1, userId1);
                pstmt2.setString(2, "Tran Van B");
                pstmt2.setString(3, "tranvanb@example.com");

                int rowsAffected2 = pstmt2.executeUpdate();
                System.out.println("Câu lệnh INSERT thứ hai - Số dòng đã thêm: " + rowsAffected2);

                conn.commit();
                System.out.println("Đã commit thay đổi (điều này không nên xảy ra)!");

            } catch (SQLException e) {
                System.out.println("Lỗi đã xảy ra như mong đợi: " + e.getMessage());
                System.out.println("Đang rollback transaction...");
                conn.rollback();
                System.out.println("Đã rollback transaction thành công!");

                verifyNoDataInserted(conn, 100);

            } finally {
                conn.setAutoCommit(initialAutoCommit);
                System.out.println("Đã khôi phục auto-commit về trạng thái ban đầu: " + conn.getAutoCommit());
            }

        } catch (SQLException e) {
            System.out.println("Lỗi kết nối cơ sở dữ liệu!");
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

    private static void verifyNoDataInserted(Connection conn, int userId) throws SQLException {
        String selectSQL = "SELECT COUNT(*) AS count FROM users WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(selectSQL);
        pstmt.setInt(1, userId);

        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            int count = rs.getInt("count");
            if (count == 0) {
                System.out.println("Xác minh thành công: Không có dữ liệu nào được thêm vào (count = " + count + ")");
            } else {
                System.out.println("Xác minh thất bại: Dữ liệu vẫn được thêm vào (count = " + count + ")");
            }
        }

        rs.close();
        pstmt.close();
    }
}