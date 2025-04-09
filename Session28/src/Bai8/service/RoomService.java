package Bai8.service;


import Bai7.util.DatabaseUtil;
import Bai8.dao.RoomDAO;
import Bai8.model.Room;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class RoomService {
    private final RoomDAO roomDAO;

    public RoomService() {
        this.roomDAO = new RoomDAO();
    }

    public void createRoomsTable() throws SQLException {
        roomDAO.createRoomsTable();
    }

    public void addRoom(Room room) throws SQLException {
        roomDAO.addRoom(room);
    }

    public Room getRoomById(int roomId) throws SQLException {
        try (Connection connection = DatabaseUtil.getConnection()) {
            return roomDAO.getRoomById(connection, roomId);
        }
    }

    public List<Room> getAllRooms() throws SQLException {
        return roomDAO.getAllRooms();
    }
}
