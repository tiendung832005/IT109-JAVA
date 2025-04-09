import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Bai1 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASS = "12345678";

    public static void main(String[] args) {
        Connection conn = null;

        try {
            System.out.println("Đang kết nối đến cơ sở dữ liệu");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Kết nối thành công!");

            boolean initialAutoCommit = conn.getAutoCommit();
            System.out.println("Trạng thái auto-commit ban đầu: " + initialAutoCommit);

            conn.setAutoCommit(false);
            System.out.println("Đã tắt chế độ auto-commit: " + conn.getAutoCommit());

            try {
                String insertSQL = "INSERT INTO users (id, name, email) VALUES (?, ?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(insertSQL);

                int userId = 1;
                pstmt.setInt(1, userId);
                pstmt.setString(2, "Nguyen Van A");
                pstmt.setString(3, "nguyenvana@gmail.com");

                int rowsAffected = pstmt.executeUpdate();
                System.out.println("Số dòng đã thêm: " + rowsAffected);

                conn.commit();
                System.out.println("Đã commit thay đổi!");

                verifyDataInserted(conn, userId);

            } catch (SQLException e) {
                System.out.println("Lỗi trong quá trình thực hiện! Đang rollback...");
                conn.rollback();
                e.printStackTrace();
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

    // Phương thức để xác minh dữ liệu đã được thêm vào
    private static void verifyDataInserted(Connection conn, int userId) throws SQLException {
        String selectSQL = "SELECT * FROM users WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(selectSQL);
        pstmt.setInt(1, userId);

        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            System.out.println("Xác minh dữ liệu đã được thêm thành công!");
            System.out.println("Thông tin người dùng:");
            System.out.println("ID: " + rs.getInt("id"));
            System.out.println("Tên: " + rs.getString("name"));
            System.out.println("Email: " + rs.getString("email"));
        } else {
            System.out.println("Không tìm thấy dữ liệu đã thêm!");
        }

        rs.close();
        pstmt.close();
    }
}