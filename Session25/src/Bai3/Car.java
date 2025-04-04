package Bai3;

public class Car {
    private String engine;
    private int seats;
    private String color;
    private String brand;
    private boolean hasGPS;
    private boolean hasSunroof;


    private Car(CarBuilder builder) {
        this.engine = builder.engine;
        this.seats = builder.seats;
        this.color = builder.color;
        this.brand = builder.brand;
        this.hasGPS = builder.hasGPS;
        this.hasSunroof = builder.hasSunroof;
    }

    public String getEngine() {
        return engine;
    }

    public int getSeats() {
        return seats;
    }

    public String getColor() {
        return color;
    }

    public String getBrand() {
        return brand;
    }

    public boolean hasGPS() {
        return hasGPS;
    }

    public boolean hasSunroof() {
        return hasSunroof;
    }

    @Override
    public String toString() {
        return "Car{" +
                "engine='" + engine + '\'' +
                ", seats=" + seats +
                ", color='" + color + '\'' +
                ", brand='" + brand + '\'' +
                ", hasGPS=" + hasGPS +
                ", hasSunroof=" + hasSunroof +
                '}';
    }
    public static class CarBuilder {
        private String engine;
        private int seats;
        private String color;

        private String brand = "";
        private boolean hasGPS = false;
        private boolean hasSunroof = false;

        public CarBuilder(String engine, int seats, String color) {
            this.engine = engine;
            this.seats = seats;
            this.color = color;
        }

        public CarBuilder brand(String brand) {
            this.brand = brand;
            return this;
        }

        public CarBuilder gps(boolean hasGPS) {
            this.hasGPS = hasGPS;
            return this;
        }

        public CarBuilder sunroof(boolean hasSunroof) {
            this.hasSunroof = hasSunroof;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}
