import java.sql.SQLOutput;

public class Car {
    private String make;
    private String model;
    private int year;

    public Car(int year, String model, String make) {
        setYear(year);
        this.model = model;
        this.make = make;
    }

    public String getMake() {
        return make;
    }

    public String setMake(String make) {
        this.make = make;
        return make;
    }

    public String getModel() {
        return model;
    }

    public String setModel(String model) {
        this.model = model;
        return model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int Year) {
        int currentYear = java.time.Year.now().getValue();
        if (year <= currentYear) {
            this.year = year;
        }
        else {
            System.out.println("Lỗi: Năm sản xuất k thể lớn hơn năm hiện tại");
        }
    }

    public void displayInfo() {
        System.out.println("Info xe: " + make + " " + model + " (" + year + ")");
    }

    public class TestCar {
        public static void main(String[] args) {
            Car myCar = new Car(2025, "Camry", "Toyota" );

            System.out.println("Thông tin ban đầu: ");
            myCar.displayInfo();

            System.out.println("\nSử dụng getter: ");
            System.out.println("Thương hiệu: " +myCar.getMake());
            System.out.println("Mẫu xe: " +myCar.getModel());
            System.out.println("Năm sản xuất: " +myCar.getYear());


            System.out.println("\n Thay thông tin bằng setter: ");
            myCar.setMake("Honda");
            myCar.setModel("Civic");
            myCar.setYear(2024);
            myCar.displayInfo();

            myCar.setYear(2026);
            System.out.println("Năm sx sau khi thay đổi: " +myCar.getYear());

            System.out.println("\nTạo xe mới với năm sản xuất không hợp lệ:");
            Car invalidCar = new Car(2026, "CX-5", "Mazda");
            System.out.println("Năm sản xuất của xe mới: " + invalidCar.getYear());

        }
    }
}
