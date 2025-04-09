package Bai9;

import Bai9.model.Auction;
import Bai9.model.User;
import Bai9.service.AuctionService;

import java.sql.SQLException;

public class Bai9 {
    public static void main(String[] args) {
        AuctionService auctionService = new AuctionService();

        try {
            Auction auction = auctionService.getAuctionDetails(1);
            User user1 = auctionService.getUserDetails(1);
            User user2 = auctionService.getUserDetails(2);

            System.out.println("Initial State:");
            System.out.println("Auction: " + auction);
            System.out.println("User 1: " + user1);
            System.out.println("User 2: " + user2);
            System.out.println("-----------------------------");

            System.out.println("Trường hợp thử nghiệm 1: Người dùng đặt giá thầu thấp hơn giá thầu cao nhất hiện tại");
            boolean result1 = auctionService.placeBid(1, 1, auction.getHighestBid() - 10);
            System.out.println("Result: " + (result1 ? "Success" : "Failed (Expected)"));

            auction = auctionService.getAuctionDetails(1);
            System.out.println("Đấu giá sau đợt thử nghiệm 1: " + auction);
            System.out.println("-----------------------------");

            System.out.println("Trường hợp thử nghiệm 2: Người dùng đặt giá thầu khi số dư không đủ");

            boolean result2 = auctionService.placeBid(1, 2, 10000.0); // Giá trị lớn hơn số dư
            System.out.println("Result: " + (result2 ? "Success" : "Failed (Expected)"));

            auction = auctionService.getAuctionDetails(1);
            System.out.println("Đấu giá sau đợt thử nghiệm 2: " + auction);
            System.out.println("-----------------------------");


            System.out.println("Trường hợp thử nghiệm 3: Vị trí đặt giá thầu hợp lệ");
            double newBidAmount = auction.getHighestBid() + 50;
            boolean result3 = auctionService.placeBid(1, 1, newBidAmount);
            System.out.println("Result: " + (result3 ? "Success (Expected)" : "Failed"));

            auction = auctionService.getAuctionDetails(1);
            System.out.println("Đấu giá sau đợt thử nghiệm 3: " + auction);
            System.out.println("-----------------------------");

        } catch (SQLException e) {
            System.err.println("Lỗi trong quá trình thử nghiệm: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
