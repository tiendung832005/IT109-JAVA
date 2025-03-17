package Bai9;

abstract class Vehicle {
    protected String name;
    protected int speed;

    public Vehicle(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }


    public abstract void move();
    public abstract String sound();

    public double move(int time) {
        return speed * time;
    }

    public double move(int time, int speed) {
        return speed * time;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }
}

class Car extends Vehicle {
    private String brand;

    public Car(String name, int speed, String brand) {
        super(name, speed);
        this.brand = brand;
    }

    @Override
    public void move() {
        System.out.println(name + " đang di chuyển trên mặt đất với tốc độ " + speed + " km/h");
    }

    @Override
    public String sound() {
        return "Vroom";
    }

    public String getBrand() {
        return brand;
    }
}

class Bike extends Vehicle {
    private String type;

    public Bike(String name, int speed, String type) {
        super(name, speed);
        this.type = type;
    }

    @Override
    public void move() {
        System.out.println(name + " đang di chuyển chậm với tốc độ " + speed + " km/h");
    }

    @Override
    public String sound() {
        return "Ring Ring";
    }

    public String getType() {
        return type;
    }
}

class Bus extends Vehicle {
    private int seats;

    public Bus(String name, int speed, int seats) {
        super(name, speed);
        this.seats = seats;
    }

    @Override
    public void move() {
        System.out.println(name + " đang di chuyển trên mặt đất với tốc độ " + speed + " km/h");
    }

    @Override
    public String sound() {
        return "Honk";
    }

    public int getSeats() {
        return seats;
    }
}

class Airplane extends Vehicle {
    private int altitude;

    public Airplane(String name, int speed, int altitude) {
        super(name, speed);
        this.altitude = altitude;
    }

    @Override
    public void move() {
        System.out.println(name + " đang bay trên không với tốc độ " + speed + " km/h ở độ cao " + altitude + " mét");
    }

    @Override
    public String sound() {
        return "Whoosh";
    }

    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }
}

class Main {
    public static void main(String[] args) {
        Car car = new Car("Toyota Camry", 100, "Toyota");
        Bike bike = new Bike("Mountain Bike", 25, "Địa hình");
        Bus bus = new Bus("City Bus", 80, 45);
        Airplane airplane = new Airplane("Boeing 737", 800, 10000);

        Vehicle[] vehicles = {car, bike, bus, airplane};

        for (Vehicle vehicle : vehicles) {
            System.out.println("\n " + vehicle.getName() );
            vehicle.move();
            System.out.println("Âm thanh: " + vehicle.sound());

            double distance1 = vehicle.move(2);
            System.out.println("Khoảng cách di chuyển trong 2 giờ: " + distance1 + " km");

            double distance2 = vehicle.move(2, vehicle.getSpeed() + 20);
            System.out.println("Khoảng cách di chuyển trong 3 giờ với tốc độ tăng thêm 20 km/h: " + distance2 + " km");
        }


        System.out.println("\nThông tin");
        System.out.println("Nhãn hiệu của xe hơi: " + car.getBrand());
        System.out.println("Loại xe đạp: " + bike.getType());
        System.out.println("Số ghế ngồi của xe buýt: " + bus.getSeats());
        System.out.println("Độ cao bay của máy bay: " + airplane.getAltitude() + " mét");

        airplane.setAltitude(12000);
        System.out.println("Độ cao bay mới của máy bay: " + airplane.getAltitude() + " mét");
    }
}
