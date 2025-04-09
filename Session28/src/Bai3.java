import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Bai3 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASS = "12345678";


    public static void main(String[] args) {
        Connection conn = null;

        try {
            System.out.println("Đang kết nối đến cơ sở dữ liệu...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Kết nối thành công!");

            displayAccountBalances(conn);

            int fromAccountId = 1;
            int toAccountId = 2;
            double transferAmount = 500.0;

            boolean success = transferMoney(conn, fromAccountId, toAccountId, transferAmount);

            if (success) {
                System.out.println("Chuyển tiền thành công!");
            } else {
                System.out.println("Chuyển tiền thất bại!");
            }

            displayAccountBalances(conn);

            System.out.println("\nThử chuyển tiền với số tiền vượt quá số dư...");
            double excessiveAmount = 10000.0;
            success = transferMoney(conn, fromAccountId, toAccountId, excessiveAmount);

            if (success) {
                System.out.println("Chuyển tiền thành công!");
            } else {
                System.out.println("Chuyển tiền thất bại như mong đợi!");
            }

            displayAccountBalances(conn);

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


    private static void displayAccountBalances(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT id, name, balance FROM accounts");

        System.out.println("\n--- Số dư tài khoản ---");
        System.out.println("ID\tTên\t\tSố dư");
        System.out.println("-------------------------------");

        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            double balance = rs.getDouble("balance");

            System.out.printf("%d\t%s\t%.2f VND\n", id, name, balance);
        }

        System.out.println("-------------------------------\n");

        rs.close();
        stmt.close();
    }

    private static boolean transferMoney(Connection conn, int fromAccountId, int toAccountId,
                                         double amount) throws SQLException {
        boolean initialAutoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);

        try {
            PreparedStatement checkBalanceStmt = conn.prepareStatement(
                    "SELECT balance FROM accounts WHERE id = ?"
            );
            checkBalanceStmt.setInt(1, fromAccountId);
            ResultSet rs = checkBalanceStmt.executeQuery();

            if (!rs.next()) {
                throw new SQLException("Tài khoản nguồn không tồn tại!");
            }

            double currentBalance = rs.getDouble("balance");
            rs.close();
            checkBalanceStmt.close();

            if (currentBalance < amount) {
                throw new SQLException("Số dư không đủ! Cần " + amount + " VND, hiện có "
                        + currentBalance + " VND");
            }

            PreparedStatement checkToAccountStmt = conn.prepareStatement(
                    "SELECT id FROM accounts WHERE id = ?"
            );
            checkToAccountStmt.setInt(1, toAccountId);
            rs = checkToAccountStmt.executeQuery();

            if (!rs.next()) {
                throw new SQLException("Tài khoản đích không tồn tại!");
            }

            rs.close();
            checkToAccountStmt.close();

            PreparedStatement withdrawStmt = conn.prepareStatement(
                    "UPDATE accounts SET balance = balance - ? WHERE id = ?"
            );
            withdrawStmt.setDouble(1, amount);
            withdrawStmt.setInt(2, fromAccountId);
            int withdrawRows = withdrawStmt.executeUpdate();
            withdrawStmt.close();

            if (withdrawRows != 1) {
                throw new SQLException("Không thể trừ tiền từ tài khoản nguồn!");
            }

            System.out.println("Đã trừ " + amount + " VND từ tài khoản " + fromAccountId);

            PreparedStatement depositStmt = conn.prepareStatement(
                    "UPDATE accounts SET balance = balance + ? WHERE id = ?"
            );
            depositStmt.setDouble(1, amount);
            depositStmt.setInt(2, toAccountId);
            int depositRows = depositStmt.executeUpdate();
            depositStmt.close();

            if (depositRows != 1) {
                throw new SQLException("Không thể cộng tiền vào tài khoản đích!");
            }

            System.out.println("Đã cộng " + amount + " VND vào tài khoản " + toAccountId);

            conn.commit();
            return true;

        } catch (SQLException e) {
            System.out.println("Lỗi trong quá trình chuyển tiền: " + e.getMessage());
            System.out.println("Đang rollback transaction...");
            conn.rollback();
            return false;
        } finally {
            conn.setAutoCommit(initialAutoCommit);
        }
    }
}