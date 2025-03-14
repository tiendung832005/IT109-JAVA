package inhertance;

import java.util.Scanner;

public class person {
    private String name;
    private int age;
    private String address;
    private boolean sex;
    public person(String address, int age, String name) {
        this.address = address;
        this.age = age;
        this.name = name;
        this.sex = false;
    }

    public void inputData(Scanner scanner) {
        System.out.println("Enter name: ");
        this.name = scanner.nextLine();
        System.out.println("Enter age: ");
        this.age = scanner.nextInt();
        System.out.println("Enter address: ");
        scanner.nextLine(); // Consume newline character
        this.address = scanner.nextLine();
        System.out.println("Enter sex (Male/Female): ");
        this.sex = scanner.next().equalsIgnoreCase("Male");
    }

    public void displayData() {

    }
}
