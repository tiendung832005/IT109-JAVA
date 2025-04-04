package Bai3;

public class Bai3 {
    public static void main(String[] args) {
        Car sedan = new Car.CarBuilder("1.6L", 5, "Đỏ")
                .brand("Toyota")
                .gps(true)
                .sunroof(false)
                .build();

        Car suv = new Car.CarBuilder("2.5L Turbo", 7, "Đen")
                .brand("BMW")
                .gps(true)
                .sunroof(true)
                .build();

        Car sportsCar = new Car.CarBuilder("3.0L V8", 2, "Vàng")
                .brand("Ferrari")
                .gps(true)
                .sunroof(true)
                .build();

        System.out.println("Thông tin xe Sedan:");
        System.out.println(sedan);

        System.out.println("\nThông tin xe SUV:");
        System.out.println(suv);

        System.out.println("\nThông tin xe thể thao:");
        System.out.println(sportsCar);

        System.out.println("\nKiểm tra thuộc tính của xe Sedan:");
        System.out.println("- Động cơ: " + sedan.getEngine());
        System.out.println("- Số ghế: " + sedan.getSeats());
        System.out.println("- Màu sắc: " + sedan.getColor());
        System.out.println("- Thương hiệu: " + sedan.getBrand());
        System.out.println("- Có GPS: " + (sedan.hasGPS() ? "Có" : "Không"));
        System.out.println("- Có cửa sổ trời: " + (sedan.hasSunroof() ? "Có" : "Không"));
    }
}
