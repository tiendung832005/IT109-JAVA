package Bai8.model;


import java.time.LocalDateTime;

public class FailedBooking {
    private int id;
    private int customerId;
    private int roomId;
    private LocalDateTime attemptTime;
    private String reason;

    public FailedBooking() {
    }

    public FailedBooking(int id, int customerId, int roomId, LocalDateTime attemptTime, String reason) {
        this.id = id;
        this.customerId = customerId;
        this.roomId = roomId;
        this.attemptTime = attemptTime;
        this.reason = reason;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public LocalDateTime getAttemptTime() {
        return attemptTime;
    }

    public void setAttemptTime(LocalDateTime attemptTime) {
        this.attemptTime = attemptTime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "FailedBooking{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", roomId=" + roomId +
                ", attemptTime=" + attemptTime +
                ", reason='" + reason + '\'' +
                '}';
    }
}
