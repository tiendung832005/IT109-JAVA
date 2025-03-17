package Bai7;

public interface IEmployee {
    int calculateSalary();
    String getName();
}
abstract class Employee implements IEmployee {
    protected String name;
    protected int paymentPerHour;

    public Employee(String name, int paymentPerHour) {
        this.name = name;
        this.paymentPerHour = paymentPerHour;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setPaymentPerHour(int paymentPerHour) {
        this.paymentPerHour = paymentPerHour;
    }

    public int getPaymentPerHour() {
        return paymentPerHour;
    }

    @Override
    public abstract int calculateSalary();
}
class PartTimeEmployee extends Employee {
    private int workingHours;

    public PartTimeEmployee(String name, int paymentPerHour, int workingHours) {
        super(name, paymentPerHour);
        this.workingHours = workingHours;
    }

    public int getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(int workingHours) {
        this.workingHours = workingHours;
    }

    @Override
    public int calculateSalary() {
        return workingHours * paymentPerHour;
    }
}
// File: FullTimeEmployee.java
class FullTimeEmployee extends Employee {
    public FullTimeEmployee(String name, int paymentPerHour) {
        super(name, paymentPerHour);
    }

    @Override
    public int calculateSalary() {
        return 8 * paymentPerHour;
    }
}

class Main {
    public static void main(String[] args) {
        PartTimeEmployee partTimeEmployee = new PartTimeEmployee("Nguyễn Văn A", 100000, 4);

        FullTimeEmployee fullTimeEmployee = new FullTimeEmployee("Trần Thị B", 120000);

        System.out.println("Thông tin lương nhân viên");

        System.out.println("Nhân viên part time:");
        System.out.println("Tên: " + partTimeEmployee.getName());
        System.out.println("Lương theo giờ: " + partTimeEmployee.getPaymentPerHour() + " VND");
        System.out.println("Số giờ làm việc: " + partTimeEmployee.getWorkingHours() + " giờ");
        System.out.println("Lương hàng ngày: " + partTimeEmployee.calculateSalary() + " VND");

        System.out.println("\nNhân viên full time:");
        System.out.println("Tên: " + fullTimeEmployee.getName());
        System.out.println("Lương theo giờ: " + fullTimeEmployee.getPaymentPerHour() + " VND");
        System.out.println("Lương hàng ngày: " + fullTimeEmployee.calculateSalary() + " VND");
    }
}