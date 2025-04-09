package Bai9.model;

public class User {
    private int userId;
    private String username;
    private double balance;

    public User(int userId, String username, double balance) {
        this.userId = userId;
        this.username = username;
        this.balance = balance;
    }

    // Getters and Setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", balance=" + balance +
                '}';
    }
}
