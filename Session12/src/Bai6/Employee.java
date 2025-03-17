package Bai6;

public class Employee {
    protected String name;
    protected int age;
    protected double basicSalary;

    public Employee(String name, int age, double basicSalary) {
        this.name = name;
        this.age = age;
        this.basicSalary = basicSalary;
    }

    public double calculateSalary() {
        return basicSalary;
    }

    public void showInfo() {
        System.out.println("Tên: " + name);
        System.out.println("Tuổi: " + age);
        System.out.println("Lương cơ bản: " + basicSalary);
    }
}
class FullTimeEmployee extends Employee {
    private double bonus;


    public FullTimeEmployee(String name, int age, double basicSalary, double bonus) {
        super(name, age, basicSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return basicSalary + bonus;
    }

    @Override
    public void showInfo() {
        System.out.println("Nhân viên Full-Time:");
        super.showInfo();
        System.out.println("Thưởng: " + bonus);
        System.out.println("Tổng lương: " + calculateSalary());
    }
}
class PartTimeEmployee extends Employee {
    private int workingHours;
    private double hourlyRate;

    public PartTimeEmployee(String name, int age, double hourlyRate, int workingHours) {
        super(name, age, 0);
        this.hourlyRate = hourlyRate;
        this.workingHours = workingHours;
    }

    @Override
    public double calculateSalary() {
        return workingHours * hourlyRate;
    }

    @Override
    public void showInfo() {
        System.out.println("Nhân viên Part-Time:");
        System.out.println("Tên: " + name);
        System.out.println("Tuổi: " + age);
        System.out.println("Số giờ làm: " + workingHours);
        System.out.println("Lương theo giờ: " + hourlyRate);
        System.out.println("Tổng lương: " + calculateSalary());
    }
}
class Intern extends Employee {

    public Intern(String name, int age, double basicSalary) {
        super(name, age, basicSalary);
    }


    @Override
    public double calculateSalary() {
        return basicSalary;
    }

    @Override
    public void showInfo() {
        System.out.println("Thực tập sinh:");
        super.showInfo();
        System.out.println("Tổng lương: " + calculateSalary());
    }
}
class Main {
    public static void main(String[] args) {

        Employee[] employees = new Employee[3];
        employees[0] = new FullTimeEmployee("Nguyễn Văn A", 20, 10000000, 3000000);
        employees[1] = new PartTimeEmployee("Trần Thị B", 30, 50000, 80);
        employees[2] = new Intern("Lê Văn C", 22, 2000000);


        for (Employee emp : employees) {
            emp.showInfo();
            System.out.println("---------------------------");
        }
    }
}

