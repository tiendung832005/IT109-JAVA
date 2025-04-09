package Bai8.model;

import java.math.BigDecimal;

public class Room {
    private int roomId;
    private String roomType;
    private boolean availability;
    private BigDecimal price;

    public Room() {
    }

    public Room(int roomId, String roomType, boolean availability, BigDecimal price) {
        this.roomId = roomId;
        this.roomType = roomType;
        this.availability = availability;
        this.price = price;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", roomType='" + roomType + '\'' +
                ", availability=" + availability +
                ", price=" + price +
                '}';
    }
}
