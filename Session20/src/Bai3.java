import java.util.List;
import java.util.Optional;

public class Bai3 {
    static class User {
        private String name;
        private Optional<String> phoneNumber;

        public User(String name, String phoneNumber) {
            this.name = name;
            this.phoneNumber = Optional.ofNullable(phoneNumber);
        }

        public void printInfo() {
            String phone = phoneNumber.orElse("Không có");
            System.out.println("Tên: " + name + ", SĐT: " + phone);
        }
    }

    public static void main(String[] args) {
        List<User> users = List.of(
                new User("Quý", "0987654321"),
                new User("Lan", null),
                new User("Minh", "0933222111"),
                new User("Huyền", null)
        );

        System.out.println("Thông tin người dùng:");
        users.forEach(User::printInfo);
    }
}