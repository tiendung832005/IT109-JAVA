package Bai10;

import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private final int id;
    private final String name;
    private double balance;
    private final ReentrantLock lock;

    public Account(int id, String name, double initialBalance) {
        this.id = id;
        this.name = name;
        this.balance = initialBalance;
        this.lock = new ReentrantLock();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public ReentrantLock getLock() {
        return lock;
    }

    @Override
    public String toString() {
        return name + " (ID: " + id + "): $" + balance;
    }
}
