package Bai9.dao;

import Bai9.model.Auction;

import java.sql.*;

public class AuctionDAO {

    public Auction getAuctionById(Connection connection, int auctionId) throws SQLException {
        String sql = "SELECT * FROM auctions WHERE auction_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, auctionId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Auction(
                        resultSet.getInt("auction_id"),
                        resultSet.getString("item_name"),
                        resultSet.getDouble("highest_bid"),
                        resultSet.getString("status")
                );
            }
            return null;
        }
    }

    public boolean updateHighestBid(Connection connection, int auctionId, double newBidAmount) throws SQLException {
        String sql = "UPDATE auctions SET highest_bid = ? WHERE auction_id = ? AND status = 'ACTIVE'";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDouble(1, newBidAmount);
            statement.setInt(2, auctionId);
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        }
    }

    public boolean isAuctionActive(Connection connection, int auctionId) throws SQLException {
        String sql = "SELECT status FROM auctions WHERE auction_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, auctionId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return "ACTIVE".equals(resultSet.getString("status"));
            }
            return false;
        }
    }
}
