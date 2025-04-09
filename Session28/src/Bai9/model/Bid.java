package Bai9.model;

import java.time.LocalDateTime;

public class Bid {
    private int bidId;
    private int auctionId;
    private int userId;
    private double bidAmount;
    private LocalDateTime timestamp;

    public Bid(int bidId, int auctionId, int userId, double bidAmount, LocalDateTime timestamp) {
        this.bidId = bidId;
        this.auctionId = auctionId;
        this.userId = userId;
        this.bidAmount = bidAmount;
        this.timestamp = timestamp;
    }

    public Bid(int auctionId, int userId, double bidAmount) {
        this.auctionId = auctionId;
        this.userId = userId;
        this.bidAmount = bidAmount;
        this.timestamp = LocalDateTime.now();
    }

    // Getters and Setters
    public int getBidId() {
        return bidId;
    }

    public void setBidId(int bidId) {
        this.bidId = bidId;
    }

    public int getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(int auctionId) {
        this.auctionId = auctionId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(double bidAmount) {
        this.bidAmount = bidAmount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Bid{" +
                "bidId=" + bidId +
                ", auctionId=" + auctionId +
                ", userId=" + userId +
                ", bidAmount=" + bidAmount +
                ", timestamp=" + timestamp +
                '}';
    }
}
