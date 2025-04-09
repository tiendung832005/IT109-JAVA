package Bai9.service;

import Bai9.config.DatabaseConfig;
import Bai9.dao.AuctionDAO;
import Bai9.dao.BidDAO;
import Bai9.dao.FailedBidDAO;
import Bai9.dao.UserDAO;
import Bai9.model.Auction;
import Bai9.model.Bid;
import Bai9.model.FailedBid;
import Bai9.model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class AuctionService {
    private AuctionDAO auctionDAO;
    private BidDAO bidDAO;
    private UserDAO userDAO;
    private FailedBidDAO failedBidDAO;

    public AuctionService() {
        this.auctionDAO = new AuctionDAO();
        this.bidDAO = new BidDAO();
        this.userDAO = new UserDAO();
        this.failedBidDAO = new FailedBidDAO();
    }

    /**
     * Xử lý lệnh đặt giá mới
     * @param auctionId ID của phiên đấu giá
     * @param userId ID của người dùng đặt giá
     * @param bidAmount Số tiền đặt giá
     * @return Kết quả đặt giá (true nếu thành công, false nếu thất bại)
     * @throws SQLException Nếu có lỗi xảy ra khi thao tác với cơ sở dữ liệu
     */
    public boolean placeBid(int auctionId, int userId, double bidAmount) throws SQLException {
        Connection connection = null;
        boolean success = false;
        String failureReason = null;

        try {
            connection = DatabaseConfig.getConnection();

            // Kiểm tra xem phiên đấu giá có tồn tại và còn hoạt động không
            if (!auctionDAO.isAuctionActive(connection, auctionId)) {
                failureReason = "Auction is not active or does not exist";
                return false;
            }

            // Lấy thông tin phiên đấu giá
            Auction auction = auctionDAO.getAuctionById(connection, auctionId);
            if (auction == null) {
                failureReason = "Auction not found";
                return false;
            }

            // Kiểm tra số tiền đặt giá có cao hơn giá cao nhất hiện tại không
            if (bidAmount <= auction.getHighestBid()) {
                failureReason = "Bid amount must be higher than current highest bid";
                return false;
            }

            // Kiểm tra số dư của người dùng
            if (!userDAO.checkUserBalance(connection, userId, bidAmount)) {
                failureReason = "Insufficient user balance";
                return false;
            }

            // Cập nhật giá cao nhất trong bảng auctions
            boolean updateSuccess = auctionDAO.updateHighestBid(connection, auctionId, bidAmount);
            if (!updateSuccess) {
                failureReason = "Failed to update highest bid";
                return false;
            }

            // Lưu thông tin đặt giá vào bảng bids
            Bid bid = new Bid(auctionId, userId, bidAmount);
            success = bidDAO.saveBid(connection, bid);

            if (success) {
                connection.commit();
                return true;
            } else {
                failureReason = "Failed to save bid";
                connection.rollback();
                return false;
            }

        } catch (SQLException e) {
            if (connection != null) {
                connection.rollback();
            }
            failureReason = "Database error: " + e.getMessage();
            throw e;
        } finally {
            if (!success && failureReason != null && connection != null) {
                // Lưu thông tin về đặt giá thất bại
                FailedBid failedBid = new FailedBid(auctionId, userId, bidAmount, failureReason);
                try {
                    failedBidDAO.saveFailedBid(connection, failedBid);
                    connection.commit();
                } catch (SQLException e) {
                    // Log lỗi khi không thể lưu thông tin đặt giá thất bại
                    System.err.println("Failed to save failed bid information: " + e.getMessage());
                    connection.rollback();
                }
            }

            if (connection != null) {
                connection.close();
            }
        }

    }

    /**
     * Lấy thông tin của một phiên đấu giá theo ID
     * @param auctionId ID của phiên đấu giá
     * @return Thông tin phiên đấu giá hoặc null nếu không tìm thấy
     * @throws SQLException Nếu có lỗi xảy ra khi thao tác với cơ sở dữ liệu
     */
    public Auction getAuctionDetails(int auctionId) throws SQLException {
        try (Connection connection = DatabaseConfig.getConnection()) {
            Auction auction = auctionDAO.getAuctionById(connection, auctionId);
            connection.commit();
            return auction;
        }
    }

    /**
     * Lấy thông tin người dùng theo ID
     * @param userId ID của người dùng
     * @return Thông tin người dùng hoặc null nếu không tìm thấy
     * @throws SQLException Nếu có lỗi xảy ra khi thao tác với cơ sở dữ liệu
     */
    public User getUserDetails(int userId) throws SQLException {
        try (Connection connection = DatabaseConfig.getConnection()) {
            User user = userDAO.getUserById(connection, userId);
            connection.commit();
            return user;
        }
    }
}
