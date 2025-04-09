package Bai8;

import Bai7.util.DatabaseUtil;
import Bai8.model.Customer;
import Bai8.model.Room;
import Bai8.service.BookingService;
import Bai8.service.CustomerService;
import Bai8.service.RoomService;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Bai8 {
    public static void main(String[] args) {
        try {
            initializeDatabase();

            createSampleData();


            testSuccessfulBooking();


            testBookingWithNonExistentCustomer();

            testConcurrentBooking();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void initializeDatabase() throws SQLException {
        try (Connection connection = DatabaseUtil.getConnection()) {
            RoomService roomService = new RoomService();
            CustomerService customerService = new CustomerService();
            BookingService bookingService = new BookingService();

            // Tạo các bảng
            roomService.createRoomsTable();
            customerService.createCustomersTable();
            bookingService.createBookingsTable();
            bookingService.createFailedBookingsTable();

            System.out.println("Đã khởi tạo cơ sở dữ liệu thành công.");
        }
    }

    private static void createSampleData() throws SQLException {
        RoomService roomService = new RoomService();
        CustomerService customerService = new CustomerService();

        // Thêm phòng
        roomService.addRoom(new Room(101, "Standard", true, new BigDecimal("500000")));
        roomService.addRoom(new Room(102, "Standard", true, new BigDecimal("500000")));
        roomService.addRoom(new Room(201, "Deluxe", true, new BigDecimal("800000")));
        roomService.addRoom(new Room(202, "Deluxe", true, new BigDecimal("800000")));
        roomService.addRoom(new Room(301, "Suite", true, new BigDecimal("1200000")));

        // Thêm khách hàng
        customerService.addCustomer(new Customer(1, "Nguyễn Văn A", "0901234567"));
        customerService.addCustomer(new Customer(2, "Trần Thị B", "0912345678"));
        customerService.addCustomer(new Customer(3, "Lê Văn C", "0923456789"));

        System.out.println("Đã tạo dữ liệu mẫu thành công.");

        // Hiển thị danh sách phòng
        System.out.println("\nDanh sách phòng:");
        roomService.getAllRooms().forEach(System.out::println);

        // Hiển thị danh sách khách hàng
        System.out.println("\nDanh sách khách hàng:");
        customerService.getAllCustomers().forEach(System.out::println);
    }

    private static void testSuccessfulBooking() {
        System.out.println("\n===== KIỂM TRA ĐẶT PHÒNG THÀNH CÔNG =====");
        BookingService bookingService = new BookingService();

        try {
            boolean result = bookingService.bookRoom(1, 101, LocalDate.now());
            if (result) {
                System.out.println("Đặt phòng thành công cho khách hàng 1, phòng 101");
            } else {
                System.out.println("Đặt phòng thất bại cho khách hàng 1, phòng 101");
            }

            // Hiển thị danh sách đặt phòng
            System.out.println("\nDanh sách đặt phòng:");
            bookingService.getAllBookings().forEach(System.out::println);

            // Hiển thị trạng thái phòng sau khi đặt
            RoomService roomService = new RoomService();
            System.out.println("\nTrạng thái phòng sau khi đặt:");
            roomService.getAllRooms().forEach(System.out::println);

        } catch (Exception e) {
            System.err.println("Lỗi khi thử nghiệm đặt phòng thành công: " + e.getMessage());
        }
    }

    private static void testBookingWithNonExistentCustomer() {
        System.out.println("\n===== KIỂM TRA ĐẶT PHÒNG VỚI KHÁCH HÀNG KHÔNG TỒN TẠI =====");
        BookingService bookingService = new BookingService();

        try {
            boolean result = bookingService.bookRoom(99, 102, LocalDate.now());
            if (result) {
                System.out.println("Đặt phòng thành công cho khách hàng 99, phòng 102");
            } else {
                System.out.println("Đặt phòng thất bại cho khách hàng 99, phòng 102");
            }

            // Hiển thị danh sách đặt phòng thất bại
            System.out.println("\nDanh sách đặt phòng thất bại:");
            bookingService.getAllFailedBookings().forEach(System.out::println);

        } catch (Exception e) {
            System.err.println("Lỗi khi thử nghiệm đặt phòng với khách hàng không tồn tại: " + e.getMessage());
        }
    }

    private static void testConcurrentBooking() {
        System.out.println("\n===== KIỂM TRA ĐẶT PHÒNG ĐỒNG THỜI =====");

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Runnable booking1 = () -> {
            try {
                BookingService bookingService = new BookingService();
                boolean result = bookingService.bookRoom(2, 201, LocalDate.now());
                System.out.println(Thread.currentThread().getName() + ": Đặt phòng " +
                        (result ? "thành công" : "thất bại") + " cho khách hàng 2, phòng 201");
            } catch (Exception e) {
                System.err.println(Thread.currentThread().getName() + ": Lỗi - " + e.getMessage());
            }
        };

        Runnable booking2 = () -> {
            try {
                Thread.sleep(10);
                BookingService bookingService = new BookingService();
                boolean result = bookingService.bookRoom(3, 201, LocalDate.now());
                System.out.println(Thread.currentThread().getName() + ": Đặt phòng " +
                        (result ? "thành công" : "thất bại") + " cho khách hàng 3, phòng 201");
            } catch (Exception e) {
                System.err.println(Thread.currentThread().getName() + ": Lỗi - " + e.getMessage());
            }
        };

        executorService.submit(booking1);
        executorService.submit(booking2);

        executorService.shutdown();
        try {
            executorService.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("Lỗi khi đợi các thread hoàn thành: " + e.getMessage());
        }

        try {
            BookingService bookingService = new BookingService();
            System.out.println("\nDanh sách đặt phòng sau khi thử nghiệm đồng thời:");
            bookingService.getAllBookings().forEach(System.out::println);

            System.out.println("\nDanh sách đặt phòng thất bại:");
            bookingService.getAllFailedBookings().forEach(System.out::println);

            RoomService roomService = new RoomService();
            System.out.println("\nTrạng thái phòng sau khi thử nghiệm đồng thời:");
            roomService.getAllRooms().forEach(System.out::println);
        } catch (Exception e) {
            System.err.println("Lỗi khi hiển thị kết quả: " + e.getMessage());
        }
    }
}

