package Bai8.dao;

import Bai7.util.DatabaseUtil;
import Bai8.model.Booking;
import Bai8.model.FailedBooking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BookingDAO {

    public void createBookingsTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS bookings (" +
                "booking_id INT AUTO_INCREMENT PRIMARY KEY, " +
                "customer_id INT NOT NULL, " +
                "room_id INT NOT NULL, " +
                "booking_date DATE NOT NULL, " +
                "status VARCHAR(20) NOT NULL, " +
                "FOREIGN KEY (customer_id) REFERENCES customers(customer_id), " +
                "FOREIGN KEY (room_id) REFERENCES rooms(room_id))";

        try (Connection connection = DatabaseUtil.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            System.out.println("Bảng 'bookings' đã được tạo hoặc đã tồn tại.");
        }
    }

    public void createFailedBookingsTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS failed_bookings (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "customer_id INT NOT NULL, " +
                "room_id INT NOT NULL, " +
                "attempt_time TIMESTAMP NOT NULL, " +
                "reason VARCHAR(255) NOT NULL)";

        try (Connection connection = DatabaseUtil.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            System.out.println("Bảng 'failed_bookings' đã được tạo hoặc đã tồn tại.");
        }
    }

    public int addBooking(Connection connection, Booking booking) throws SQLException {
        String sql = "INSERT INTO bookings (customer_id, room_id, booking_date, status) VALUES (?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, booking.getCustomerId());
            pstmt.setInt(2, booking.getRoomId());
            pstmt.setDate(3, Date.valueOf(booking.getBookingDate()));
            pstmt.setString(4, booking.getStatus());

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        return generatedKeys.getInt(1);
                    }
                }
            }
        }

        return -1;
    }

    public void logFailedBooking(Connection connection, int customerId, int roomId, String reason) throws SQLException {
        String sql = "INSERT INTO failed_bookings (customer_id, room_id, attempt_time, reason) VALUES (?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, customerId);
            pstmt.setInt(2, roomId);
            pstmt.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            pstmt.setString(4, reason);

            pstmt.executeUpdate();
        }
    }

    public List<Booking> getAllBookings() throws SQLException {
        String sql = "SELECT * FROM bookings";
        List<Booking> bookings = new ArrayList<>();

        try (Connection connection = DatabaseUtil.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {

            while (rs.next()) {
                Booking booking = new Booking();
                booking.setBookingId(rs.getInt("booking_id"));
                booking.setCustomerId(rs.getInt("customer_id"));
                booking.setRoomId(rs.getInt("room_id"));
                booking.setBookingDate(rs.getDate("booking_date").toLocalDate());
                booking.setStatus(rs.getString("status"));

                bookings.add(booking);
            }
        }

        return bookings;
    }

    public List<FailedBooking> getAllFailedBookings() throws SQLException {
        String sql = "SELECT * FROM failed_bookings";
        List<FailedBooking> failedBookings = new ArrayList<>();

        try (Connection connection = DatabaseUtil.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {

            while (rs.next()) {
                FailedBooking failedBooking = new FailedBooking();
                failedBooking.setId(rs.getInt("id"));
                failedBooking.setCustomerId(rs.getInt("customer_id"));
                failedBooking.setRoomId(rs.getInt("room_id"));
                failedBooking.setAttemptTime(rs.getTimestamp("attempt_time").toLocalDateTime());
                failedBooking.setReason(rs.getString("reason"));

                failedBookings.add(failedBooking);
            }
        }

        return failedBookings;
    }
}
