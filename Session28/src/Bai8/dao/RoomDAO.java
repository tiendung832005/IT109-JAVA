package Bai8.dao;

import Bai7.util.DatabaseUtil;
import Bai8.model.Room;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoomDAO {

    public void createRoomsTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS rooms (" +
                "room_id INT PRIMARY KEY, " +
                "room_type VARCHAR(50) NOT NULL, " +
                "availability BOOLEAN NOT NULL, " +
                "price DECIMAL(10, 2) NOT NULL)";

        try (Connection connection = DatabaseUtil.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            System.out.println("Bảng 'rooms' đã được tạo hoặc đã tồn tại.");
        }
    }

    public void addRoom(Room room) throws SQLException {
        String sql = "INSERT INTO rooms (room_id, room_type, availability, price) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, room.getRoomId());
            pstmt.setString(2, room.getRoomType());
            pstmt.setBoolean(3, room.isAvailability());
            pstmt.setBigDecimal(4, room.getPrice());

            pstmt.executeUpdate();
        }
    }

    public Room getRoomById(Connection connection, int roomId) throws SQLException {
        String sql = "SELECT * FROM rooms WHERE room_id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, roomId);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Room room = new Room();
                    room.setRoomId(rs.getInt("room_id"));
                    room.setRoomType(rs.getString("room_type"));
                    room.setAvailability(rs.getBoolean("availability"));
                    room.setPrice(rs.getBigDecimal("price"));
                    return room;
                }
            }
        }

        return null;
    }

    public boolean updateRoomAvailability(Connection connection, int roomId, boolean availability) throws SQLException {
        String sql = "UPDATE rooms SET availability = ? WHERE room_id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setBoolean(1, availability);
            pstmt.setInt(2, roomId);

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        }
    }

    public List<Room> getAllRooms() throws SQLException {
        String sql = "SELECT * FROM rooms";
        List<Room> rooms = new ArrayList<>();

        try (Connection connection = DatabaseUtil.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {

            while (rs.next()) {
                Room room = new Room();
                room.setRoomId(rs.getInt("room_id"));
                room.setRoomType(rs.getString("room_type"));
                room.setAvailability(rs.getBoolean("availability"));
                room.setPrice(rs.getBigDecimal("price"));

                rooms.add(room);
            }
        }

        return rooms;
    }
}
