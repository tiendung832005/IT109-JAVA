package Bai8;
import java.util.ArrayList;
import java.util.List;
public abstract class Car {
    protected String model;
    protected int year;
    protected double price;

    public Car(String model, int year, double price) {
        this.model = model;
        this.year = year;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public abstract String start();
    public abstract String stop();

    @Override
    public String toString() {
        return model + " (Năm SX: " + year + ", Giá: $" + price + ")";
    }
}
interface Refuelable {
    String refuel();
}
class ElectricCar extends Car implements Refuelable {
    public ElectricCar(String model, int year, double price) {
        super(model, year, price);
    }

    @Override
    public String start() {
        return "Xe điện " + toString() + " đã khởi động không tiếng ồn";
    }

    @Override
    public String stop() {
        return "Xe điện " + toString() + " đã dừng và ngắt kết nối động cơ";
    }

    @Override
    public String refuel() {
        return "Xe điện " + toString() + " đang sạc điện";
    }
}
class GasCar extends Car implements Refuelable {
    public GasCar(String model, int year, double price) {
        super(model, year, price);
    }

    @Override
    public String start() {
        return "Xe chạy xăng " + toString() + " đã khởi động với tiếng động cơ";
    }

    @Override
    public String stop() {
        return "Xe chạy xăng " + toString() + " đã dừng và động cơ tắt";
    }

    @Override
    public String refuel() {
        return "Xe chạy xăng " + toString() + " đang được đổ xăng";
    }
}



class Garage {
    private List<Car> cars;

    public Garage() {
        cars = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void startAllCars() {
        System.out.println("Khởi động tất cả xe");
        for (Car car : cars) {
            System.out.println(car.start());
        }
    }

    public void stopAllCars() {
        System.out.println("Dừng tất cả xe");
        for (Car car : cars) {
            System.out.println(car.stop());
        }
    }

    public void refuelAllCars() {
        System.out.println("Nạp nhiên liệu tất cả xe");
        for (Car car : cars) {
            if (car instanceof Refuelable) {
                Refuelable refuelableCar = (Refuelable) car;
                System.out.println(refuelableCar.refuel());
            }
        }
    }

    public void displayAllCars() {
        System.out.println("Danh sách xe trong garage");
        for (Car car : cars) {
            String carType = (car instanceof ElectricCar) ? "Điện" : "Xăng";
            System.out.println("- " + carType + ": " + car.toString());
        }
    }
}
class Main {
    public static void main(String[] args) {
        Car tesla = new ElectricCar("Tesla Model 3", 2023, 50000);
        Car toyota = new GasCar("Toyota Camry", 2022, 35000);

        System.out.println("Kiểm tra xe Tesla");
        System.out.println(tesla.start());
        System.out.println(tesla.stop());
        System.out.println(((Refuelable)tesla).refuel());

        System.out.println("\nKiểm tra xe Toyota");
        System.out.println(toyota.start());
        System.out.println(toyota.stop());
        System.out.println(((Refuelable)toyota).refuel());

        System.out.println("\nQuản lý xe trong garage");
        Garage garage = new Garage();
        garage.addCar(tesla);
        garage.addCar(toyota);

        garage.displayAllCars();
        garage.startAllCars();
        garage.refuelAllCars();
        garage.stopAllCars();
    }
}
