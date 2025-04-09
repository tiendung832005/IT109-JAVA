import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Bai4 {

    private static final String DB_URL_BANK_A = "jdbc:mysql://localhost:3306/bank_a_db";
    private static final String USER_BANK_A = "root";
    private static final String PASS_BANK_A = "12345678";

    private static final String DB_URL_BANK_B = "jdbc:mysql://localhost:3306/bank_b_db";
    private static final String USER_BANK_B = "root";
    private static final String PASS_BANK_B = "12345678";

    public static void main(String[] args) {
        Connection connBankA = null;
        Connection connBankB = null;

        try {
            System.out.println("Đang kết nối đến cơ sở dữ liệu ngân hàng A...");
            connBankA = DriverManager.getConnection(DB_URL_BANK_A, USER_BANK_A, PASS_BANK_A);
            System.out.println("Kết nối đến ngân hàng A thành công!");

            System.out.println("Đang kết nối đến cơ sở dữ liệu ngân hàng B...");
            connBankB = DriverManager.getConnection(DB_URL_BANK_B, USER_BANK_B, PASS_BANK_B);
            System.out.println("Kết nối đến ngân hàng B thành công!");


            System.out.println("\n--- Số dư tài khoản trước khi chuyển tiền ---");
            displayAccountBalance(connBankA, 1001, "A");
            displayAccountBalance(connBankB, 2001, "B");

            String sourceBank = "A";
            int sourceAccountId = 1001;
            String destBank = "B";
            int destAccountId = 2001;
            double transferAmount = 500.0;

            boolean success = transferMoneyBetweenBanks(
                    connBankA, connBankB, sourceAccountId, destAccountId, transferAmount
            );

            if (success) {
                System.out.println("\nChuyển khoản liên ngân hàng thành công!");
            } else {
                System.out.println("\nChuyển khoản liên ngân hàng thất bại!");
            }

            System.out.println("\n--- Số dư tài khoản sau khi chuyển tiền ---");
            displayAccountBalance(connBankA, sourceAccountId, sourceBank);
            displayAccountBalance(connBankB, destAccountId, destBank);

            System.out.println("\nThử chuyển tiền với số tiền vượt quá số dư...");
            double excessiveAmount = 10000.0;

            success = transferMoneyBetweenBanks(
                    connBankA, connBankB, sourceAccountId, destAccountId, excessiveAmount
            );

            if (success) {
                System.out.println("\nChuyển khoản liên ngân hàng thành công (không mong đợi)!");
            } else {
                System.out.println("\nChuyển khoản liên ngân hàng thất bại như mong đợi!");
            }

            System.out.println("\n--- Số dư tài khoản sau khi chuyển tiền thất bại ---");
            displayAccountBalance(connBankA, sourceAccountId, sourceBank);
            displayAccountBalance(connBankB, destAccountId, destBank);

        } catch (SQLException e) {
            System.out.println("Lỗi cơ sở dữ liệu!");
            e.printStackTrace();
        } finally {
            // Đóng kết nối
            closeConnection(connBankA, "A");
            closeConnection(connBankB, "B");
        }
    }


    private static void displayAccountBalance(Connection conn, int accountId, String bankName) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(
                "SELECT account_id, account_name, balance, bank_name FROM bank_accounts WHERE account_id = ?"
        );
        stmt.setInt(1, accountId);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            int id = rs.getInt("account_id");
            String name = rs.getString("account_name");
            double balance = rs.getDouble("balance");
            String bank = rs.getString("bank_name");

            System.out.printf("Tài khoản %d | %s | Ngân hàng %s | Số dư: %.2f VND\n",
                    id, name, bank, balance);
        } else {
            System.out.println("Không tìm thấy tài khoản " + accountId + " tại ngân hàng " + bankName);
        }

        rs.close();
        stmt.close();
    }

    private static boolean transferMoneyBetweenBanks(Connection connSourceBank, Connection connDestBank,
                                                     int sourceAccountId, int destAccountId,
                                                     double amount) throws SQLException {
        boolean initialAutoCommitSource = connSourceBank.getAutoCommit();
        boolean initialAutoCommitDest = connDestBank.getAutoCommit();

        connSourceBank.setAutoCommit(false);
        connDestBank.setAutoCommit(false);

        try {
            PreparedStatement checkBalanceStmt = connSourceBank.prepareStatement(
                    "SELECT balance FROM bank_accounts WHERE account_id = ?"
            );
            checkBalanceStmt.setInt(1, sourceAccountId);
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

            PreparedStatement checkDestAccountStmt = connDestBank.prepareStatement(
                    "SELECT account_id FROM bank_accounts WHERE account_id = ?"
            );
            checkDestAccountStmt.setInt(1, destAccountId);
            rs = checkDestAccountStmt.executeQuery();

            if (!rs.next()) {
                throw new SQLException("Tài khoản đích không tồn tại!");
            }

            rs.close();
            checkDestAccountStmt.close();

            PreparedStatement withdrawStmt = connSourceBank.prepareStatement(
                    "UPDATE bank_accounts SET balance = balance - ? WHERE account_id = ?"
            );
            withdrawStmt.setDouble(1, amount);
            withdrawStmt.setInt(2, sourceAccountId);
            int withdrawRows = withdrawStmt.executeUpdate();
            withdrawStmt.close();

            if (withdrawRows != 1) {
                throw new SQLException("Không thể trừ tiền từ tài khoản nguồn!");
            }

            System.out.println("Đã trừ " + amount + " VND từ tài khoản " + sourceAccountId);

            PreparedStatement depositStmt = connDestBank.prepareStatement(
                    "UPDATE bank_accounts SET balance = balance + ? WHERE account_id = ?"
            );
            depositStmt.setDouble(1, amount);
            depositStmt.setInt(2, destAccountId);
            int depositRows = depositStmt.executeUpdate();
            depositStmt.close();

            if (depositRows != 1) {
                throw new SQLException("Không thể cộng tiền vào tài khoản đích!");
            }

            System.out.println("Đã cộng " + amount + " VND vào tài khoản " + destAccountId);

            connSourceBank.commit();
            System.out.println("Đã commit transaction tại ngân hàng nguồn!");

            connDestBank.commit();
            System.out.println("Đã commit transaction tại ngân hàng đích!");

            return true;

        } catch (SQLException e) {
            System.out.println("Lỗi trong quá trình chuyển tiền: " + e.getMessage());

            try {
                System.out.println("Đang rollback transaction tại ngân hàng nguồn...");
                connSourceBank.rollback();

                System.out.println("Đang rollback transaction tại ngân hàng đích...");
                connDestBank.rollback();
            } catch (SQLException rollbackEx) {
                System.out.println("Lỗi khi rollback: " + rollbackEx.getMessage());
                rollbackEx.printStackTrace();
            }

            return false;
        } finally {
            try {
                connSourceBank.setAutoCommit(initialAutoCommitSource);
                connDestBank.setAutoCommit(initialAutoCommitDest);
            } catch (SQLException e) {
                System.out.println("Lỗi khi khôi phục trạng thái auto-commit: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    private static void closeConnection(Connection conn, String bankName) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Đã đóng kết nối đến ngân hàng " + bankName + "!");
            }
        } catch (SQLException e) {
            System.out.println("Lỗi khi đóng kết nối đến ngân hàng " + bankName + ": " + e.getMessage());
            e.printStackTrace();
        }
    }
}