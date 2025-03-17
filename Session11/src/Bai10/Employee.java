package Bai10;

public abstract class Employee {
    protected String name;
    protected double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    public abstract void work();
    public abstract void takeVacation();
}

interface AttendMeeting {
    void attendMeeting();
}

class Manager extends Employee implements AttendMeeting {

    public Manager(String name, double salary) {
        super(name, salary);
    }

    @Override
    public void work() {
        System.out.println("Quản lý " + name + " (Lương: $" + salary + ") đang giám sát dự án");
    }

    @Override
    public void takeVacation() {
        System.out.println("Quản lý " + name + " (Lương: $" + salary + ") đang đi nghỉ phép tại Pháp");
    }

    @Override
    public void attendMeeting() {
        System.out.println("Quản lý " + name + " (Lương: $" + salary + ") đang tham gia cuộc họp");
    }
}

class Developer extends Employee {

    public Developer(String name, double salary) {
        super(name, salary);
    }

    @Override
    public void work() {
        System.out.println("Lập trình viên " + name + " (Lương $" + salary + ") đang viết code cho hệ thống mới");
    }

    @Override
    public void takeVacation() {
        System.out.println("Lập trình viên " + name + " (Lương $" + salary + ") đang đi nghỉ phép ở Bali");
    }
}

class Company {
    private Employee[] employees;
    private int size;
    private final int MAX_EMPLOYEES = 100;

    public Company() {
        employees = new Employee[MAX_EMPLOYEES];
        size = 0; // Ban đầu chưa có nhân viên nào
    }

    public void addEmployee(Employee employee) {
        if (size < MAX_EMPLOYEES) {
            employees[size] = employee;
            size++;
            System.out.println("Đã thêm nhân viên: " + employee.name);
        } else {
            System.out.println("Không thể thêm nhân viên, công ty đã đủ nhân sự.");
        }
    }

    public void showAllEmployeesWork() {
        System.out.println("\nCông việc của các nhân viên");
        for (int i = 0; i < size; i++) {
            employees[i].work();
        }
    }

    public void showAllEmployeesVacation() {
        System.out.println("\nKỳ nghỉ của các nhân viên");
        for (int i = 0; i < size; i++) {
            employees[i].takeVacation();
        }
    }

    public void organizeMeeting() {
        System.out.println("\nTổ chức cuộc họp cho các quản lý");
        for (int i = 0; i < size; i++) {
            if (employees[i] instanceof AttendMeeting) {
                ((AttendMeeting) employees[i]).attendMeeting();
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        Company company = new Company();

        Manager manager = new Manager("Alice", 8000);
        Developer developer = new Developer("Bob", 5000);

        company.addEmployee(manager);
        company.addEmployee(developer);

        company.showAllEmployeesWork();
        company.showAllEmployeesVacation();
        company.organizeMeeting();
    }
}
