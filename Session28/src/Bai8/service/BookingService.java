package Bai8.service;

import Bai7.util.DatabaseUtil;
import Bai8.dao.BookingDAO;
import Bai8.dao.CustomerDAO;
import Bai8.dao.RoomDAO;
import Bai8.model.Booking;
import Bai8.model.Customer;
import Bai8.model.FailedBooking;
import Bai8.model.Room;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class BookingService {
    private final BookingDAO bookingDAO;
    private final RoomDAO roomDAO;
    private final CustomerDAO customerDAO;

    public BookingService() {
        this.bookingDAO = new BookingDAO();
        this.roomDAO = new RoomDAO();
        this.customerDAO = new CustomerDAO();
    }

    public void createBookingsTable() throws SQLException {
        bookingDAO.createBookingsTable();
    }

    public void createFailedBookingsTable() throws SQLException {
        bookingDAO.createFailedBookingsTable();
    }

    public boolean bookRoom(int customerId, int roomId, LocalDate bookingDate) throws SQLException {
        Connection connection = null;
        boolean success = false;

        try {
            connection = DatabaseUtil.getConnection();
            connection.setAutoCommit(false);

            // Kiểm tra khách hàng có tồn tại không
            Customer customer = customerDAO.getCustomerById(connection, customerId);
            if (customer == null) {
                // Khách hàng không tồn tại, ghi nhận lỗi
                bookingDAO.logFailedBooking(connection, customerId, roomId, "Khách hàng không tồn tại");
                connection.commit();
                return false;
            }

            // Kiểm tra phòng có tồn tại không
            Room room = roomDAO.getRoomById(connection, roomId);
            if (room == null) {
                // Phòng không tồn tại, ghi nhận lỗi
                bookingDAO.logFailedBooking(connection, customerId, roomId, "Phòng không tồn tại");
                connection.commit();
                return false;
            }

            // Kiểm tra phòng có còn trống không
            if (!room.isAvailability()) {
                // Phòng đã được đặt, ghi nhận lỗi
                bookingDAO.logFailedBooking(connection, customerId, roomId, "Phòng đã được đặt");
                connection.commit();
                return false;
            }

            // Cập nhật trạng thái phòng thành đã đặt (không khả dụng)
            boolean updateSuccess = roomDAO.updateRoomAvailability(connection, roomId, false);
            if (!updateSuccess) {
                // Không thể cập nhật trạng thái phòng, thực hiện rollback
                throw new SQLException("Không thể cập nhật trạng thái phòng");
            }

            // Thêm thông tin đặt phòng mới
            Booking booking = new Booking();
            booking.setCustomerId(customerId);
            booking.setRoomId(roomId);
            booking.setBookingDate(bookingDate);
            booking.setStatus("Confirmed");

            int bookingId = bookingDAO.addBooking(connection, booking);
            if (bookingId == -1) {
                // Không thể thêm thông tin đặt phòng, thực hiện rollback
                throw new SQLException("Không thể thêm thông tin đặt phòng");
            }

            // Commit transaction nếu tất cả đều thành công
            connection.commit();
            success = true;
            return true;

        } catch (SQLException e) {
            // Xảy ra lỗi, thực hiện rollback
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            throw e;
        } finally {
            // Đóng kết nối
            if (connection != null) {
                try {
                    connection.setAutoCommit(true);
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public List<Booking> getAllBookings() throws SQLException {
        return bookingDAO.getAllBookings();
    }

    public List<FailedBooking> getAllFailedBookings() throws SQLException {
        return bookingDAO.getAllFailedBookings();
    }
}
