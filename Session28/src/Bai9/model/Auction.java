package Bai9.model;

public class Auction {
    private int auctionId;
    private String itemName;
    private double highestBid;
    private String status; // "ACTIVE", "CLOSED"

    public Auction(int auctionId, String itemName, double highestBid, String status) {
        this.auctionId = auctionId;
        this.itemName = itemName;
        this.highestBid = highestBid;
        this.status = status;
    }

    // Getters and Setters
    public int getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(int auctionId) {
        this.auctionId = auctionId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getHighestBid() {
        return highestBid;
    }

    public void setHighestBid(double highestBid) {
        this.highestBid = highestBid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Auction{" +
                "auctionId=" + auctionId +
                ", itemName='" + itemName + '\'' +
                ", highestBid=" + highestBid +
                ", status='" + status + '\'' +
                '}';
    }
}
