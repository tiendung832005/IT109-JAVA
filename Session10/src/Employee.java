
class Employee {
    private String name;
    private String id;
    private double salary;

    public Employee() {
        this.name = "";
        this.id = "";
        this.salary = 0.0;
    }

    public Employee(String name, String id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void increaseSalary(double amount) {
        if (amount > 0) {
            this.salary += amount;
        } else {
            System.out.println("Số tiền tăng lương phải lớn hơn 0");
        }
    }

    @Override
    public String toString() {
        return "Tên: " + name + ", Mã số: " + id + ", Lương: " + salary;
    }
}


class Manager extends Employee {
    private double bonus;

    public Manager() {
        super();
        this.bonus = 0.0;
    }

    public Manager(String name, String id, double salary, double bonus) {
        super(name, id, salary);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double getSalary() {
        return super.getSalary() + bonus;
    }

    @Override
    public String toString() {
        return super.toString() + ", Tiền thưởng: " + bonus + ", Tổng lương: " + getSalary();
    }
}

class Developer extends Employee {
    private String programmingLanguage;

    public Developer() {
        super();
        this.programmingLanguage = "";
    }

    public Developer(String name, String id, double salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public double getSalary() {
        return super.getSalary();
    }

    @Override
    public String toString() {
        return super.toString() + ", Ngôn ngữ lập trình: " + programmingLanguage;
    }
}


class EmployeeManagement {
    public static void main(String[] args) {
        // Tạo đối tượng Employee
        Employee employee = new Employee("Nguyễn Văn A", "EMP001", 500000);

        Manager manager = new Manager("Nguyễn Văn B", "MNG001", 1000000, 200000);

        Developer developer = new Developer("Nguyễn Văn C", "DEV001", 800000, "Java");


        System.out.println("1. Nhân viên thường:");
        System.out.println(employee);
        System.out.println("Lương: " + employee.getSalary());

        System.out.println("\n2. Quản lý:");
        System.out.println(manager);
        System.out.println("Lương: " + manager.getSalary());

        System.out.println("\n3. Lập trình viên:");
        System.out.println(developer);
        System.out.println("Lương: " + developer.getSalary());


        System.out.println("Tăng lương cho lập trình viên thêm 1.000.000 VND");
        developer.increaseSalary(1000000);
        System.out.println("Thông tin lập trình viên sau khi tăng lương:");
        System.out.println(developer);
        System.out.println("Lương mới: " + developer.getSalary());

        System.out.println("\nTăng lương cho quản lý thêm 1.500.000 VND");
        manager.increaseSalary(1500000);
        System.out.println("Thông tin quản lý sau khi tăng lương:");
        System.out.println(manager);
        System.out.println("Lương mới: " + manager.getSalary());
    }
}