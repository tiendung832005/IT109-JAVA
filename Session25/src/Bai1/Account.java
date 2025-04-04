package Bai1;

public class Account {
    private int id;
    private String name;
    private int age;

    private static Account instance;

    private Account() {
        // Khởi tạo giá trị mặc định
        this.id = 1;
        this.name = "Default";
        this.age = 18;
    }

    public static Account getInstance() {
        // Tạo mới nếu chưa có thể hiện nào
        if (instance == null) {
            instance = new Account();
        }
        return instance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Account [id=" + id + ", name=" + name + ", age=" + age + "]";
    }
}
