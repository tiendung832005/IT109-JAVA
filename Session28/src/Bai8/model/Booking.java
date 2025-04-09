package Bai8.model;

import java.time.LocalDate;

public class Booking {
    private int bookingId;
    private int customerId;
    private int roomId;
    private LocalDate bookingDate;
    private String status;

    public Booking() {
    }

    public Booking(int bookingId, int customerId, int roomId, LocalDate bookingDate, String status) {
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.roomId = roomId;
        this.bookingDate = bookingDate;
        this.status = status;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", customerId=" + customerId +
                ", roomId=" + roomId +
                ", bookingDate=" + bookingDate +
                ", status='" + status + '\'' +
                '}';
    }
}