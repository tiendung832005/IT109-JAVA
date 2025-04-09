package Bai9.model;

import java.time.LocalDateTime;

public class FailedBid {
    private int failedBidId;
    private int auctionId;
    private int userId;
    private double bidAmount;
    private LocalDateTime timestamp;
    private String reason;

    public FailedBid(int failedBidId, int auctionId, int userId, double bidAmount, LocalDateTime timestamp, String reason) {
        this.failedBidId = failedBidId;
        this.auctionId = auctionId;
        this.userId = userId;
        this.bidAmount = bidAmount;
        this.timestamp = timestamp;
        this.reason = reason;
    }

    public FailedBid(int auctionId, int userId, double bidAmount, String reason) {
        this.auctionId = auctionId;
        this.userId = userId;
        this.bidAmount = bidAmount;
        this.timestamp = LocalDateTime.now();
        this.reason = reason;
    }

    // Getters and Setters
    public int getFailedBidId() {
        return failedBidId;
    }

    public void setFailedBidId(int failedBidId) {
        this.failedBidId = failedBidId;
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "FailedBid{" +
                "failedBidId=" + failedBidId +
                ", auctionId=" + auctionId +
                ", userId=" + userId +
                ", bidAmount=" + bidAmount +
                ", timestamp=" + timestamp +
                ", reason='" + reason + '\'' +
                '}';
    }
}

