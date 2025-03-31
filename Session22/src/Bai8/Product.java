package Bai8;

import java.io.Serializable;

class Product implements Serializable {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("ID: %-5d | Tên: %-20s | Giá: %,.2f VND", id, name, price);
    }
}
