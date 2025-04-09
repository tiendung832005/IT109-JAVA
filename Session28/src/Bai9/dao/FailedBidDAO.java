package Bai9.dao;


import Bai9.model.FailedBid;

import java.sql.*;
import java.time.LocalDateTime;

public class FailedBidDAO {

    public boolean saveFailedBid(Connection connection, FailedBid failedBid) throws SQLException {
        String sql = "INSERT INTO failed_bids (auction_id, user_id, bid_amount, timestamp, reason) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, failedBid.getAuctionId());
            statement.setInt(2, failedBid.getUserId());
            statement.setDouble(3, failedBid.getBidAmount());
            statement.setTimestamp(4, Timestamp.valueOf(failedBid.getTimestamp()));
            statement.setString(5, failedBid.getReason());

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    failedBid.setFailedBidId(generatedKeys.getInt(1));
                }
                return true;
            }
            return false;
        }
    }
}
