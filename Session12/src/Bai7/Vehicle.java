package Bai7;

public class Vehicle {
    // Phương thức di chuyển mặc định
    public String move() {
        return "Vehicle moving";
    }

    // Phương thức âm thanh mặc định
    public String sound() {
        return "Vehicle sound";
    }
}
class Car extends Vehicle {
    @Override
    public String move() {
        return "Ôtô đang chạy trên đường";
    }

    @Override
    public String sound() {
        return "Vroom";
    }
}class Bike extends Vehicle {
    @Override
    public String move() {
        return "\n" +
                "Xe đạp đang di chuyển trên đường phố";
    }

    @Override
    public String sound() {
        return "Ring Ring";
    }
}
class Bus extends Vehicle {
    @Override
    public String move() {
        return "\n" +
                "Xe buýt đang chở hành khách";
    }

    @Override
    public String sound() {
        return "Honk Honk";
    }
}
class Main {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[3];
        vehicles[0] = new Car();
        vehicles[1] = new Bike();
        vehicles[2] = new Bus();

        for (Vehicle v : vehicles) {
            System.out.println(v.move());
            System.out.println(v.sound());
            System.out.println("---------------------------");
        }
    }
}

