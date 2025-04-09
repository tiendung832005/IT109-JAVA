package business.dao.account;

import business.config.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class AccountDaoImp implements AccountDao {
    @Override
    public int fundsTransfer(int accSenderId, String accSenderName, int accReceiverId, String accReceiverName, double amount) {
        /*
         * 1. Khởi tạo đối tượng Connection
         * 2. Khởi tạo đối tượng CallableStatement
         * 3. Set giá trị cho các tham số vào
         * 4. Đăng ký kiểu dữ liệu cho tham số ra
         * 5. Thực hiện gọi procedure: executeQuery(), executeUpdate(), execute()
         * 6. Xử lý các dữ liệu nhận được
         * */
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            //set autoComit là false
            conn.setAutoCommit(false);
            callSt = conn.prepareCall("{call funds_transfer_amount(?,?,?,?,?,?)}");
            callSt.setInt(1, accSenderId);
            callSt.setString(2, accSenderName);
            callSt.setInt(3, accReceiverId);
            callSt.setString(4, accReceiverName);
            callSt.setDouble(5, amount);
            callSt.registerOutParameter(6, Types.INTEGER);
            callSt.execute();
            conn.commit();
            return callSt.getInt(6);
        } catch (SQLException e) {
            System.err.println("Có lỗi xảy ra trong quá trình chuyển khoản, dữ liệu đã được rollback");
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } catch (Exception e) {
            System.err.println("Có lỗi không xác định khi làm việc với db: " + e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return 0;
    }
}