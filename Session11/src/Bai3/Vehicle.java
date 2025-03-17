package Bai3;


public abstract class Vehicle {
    protected String name;
    protected int speed;

    public Vehicle(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public abstract void displayInfo();

    public void start() {
        System.out.println("Xe đang khơ động");
    }
}

class Car extends Vehicle {
    public Car(String name, int speed) {
        super(name, speed);
    }

    // Ghi đè phương thức displayInfo
    @Override
    public void displayInfo() {
        System.out.println("Thông tin xe :");
        System.out.println("Tên: " + name);
        System.out.println("Tốc độ: " + speed + " km/h");
        System.out.println("Kiểu: 6-vòng");
    }
}
class Bike extends Vehicle {
    public Bike(String name, int speed) {
        super(name, speed);
    }

    @Override
    public void displayInfo() {
        System.out.println("Thông tin bike:");
        System.out.println("Tên: " + name);
        System.out.println("Tốc độ: " + speed + " km/h");
        System.out.println("Kiểu: 2-vòng");
    }
}
class Main {
    public static void main(String[] args) {
        Car car = new Car("Mercedes", 180);

        Bike bike = new Bike("Honda Dream", 120);

        System.out.println("Car: ");
        car.start();
        car.displayInfo();

        System.out.println();

        System.out.println("Bike:");
        bike.start();
        bike.displayInfo();
    }
}