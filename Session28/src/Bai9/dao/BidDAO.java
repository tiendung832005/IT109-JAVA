package Bai9.dao;

import Bai9.model.Bid;

import java.sql.*;
import java.time.LocalDateTime;

public class BidDAO {

    public boolean saveBid(Connection connection, Bid bid) throws SQLException {
        String sql = "INSERT INTO bids (auction_id, user_id, bid_amount, timestamp) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, bid.getAuctionId());
            statement.setInt(2, bid.getUserId());
            statement.setDouble(3, bid.getBidAmount());
            statement.setTimestamp(4, Timestamp.valueOf(bid.getTimestamp()));

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    bid.setBidId(generatedKeys.getInt(1));
                }
                return true;
            }
            return false;
        }
    }

    public double getHighestBidForAuction(Connection connection, int auctionId) throws SQLException {
        String sql = "SELECT MAX(bid_amount) as highest_bid FROM bids WHERE auction_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, auctionId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getDouble("highest_bid");
            }
            return 0.0;
        }
    }
}
