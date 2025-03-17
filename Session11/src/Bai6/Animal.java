package Bai6;
import java.util.ArrayList;
import java.util.List;
public abstract class Animal {
    protected String name;
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public abstract void sound();
    public abstract void move();
}
class Lion extends Animal {
    public Lion(String name, int age) {
        super(name, age);
    }

    @Override
    public void sound() {
        System.out.println("Roar!");
    }

    @Override
    public void move() {
        System.out.println("The lion is running.");
    }
}
class Elephant extends Animal {
    public Elephant(String name, int age) {
        super(name, age);
    }

    @Override
    public void sound() {
        System.out.println("Trumpet!");
    }

    @Override
    public void move() {
        System.out.println("The elephant is walking.");
    }
}

class Zoo {
    private List<Animal> animals;

    public Zoo() {
        animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void makeAllSounds() {
        System.out.println("Animal Sound");
        for (Animal animal : animals) {
            System.out.print(animal.getName() + " makes sound: ");
            animal.sound();
        }
    }

    public void moveAllAnimals() {
        System.out.println("Animal Movement");
        for (Animal animal : animals) {
            System.out.print(animal.getName() + " moves: ");
            animal.move();
        }
    }

    public void displayAllAnimals() {
        System.out.println("Zoo Animal");
        for (Animal animal : animals) {
            System.out.println("Name: " + animal.getName() + ", Age: " + animal.getAge() + ", Type: " + animal.getClass().getSimpleName());
        }
    }
}
// File: Main.java
class Main {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();

        Lion lion = new Lion("Simba", 5);
        Elephant elephant = new Elephant("Dumbo", 8);

        zoo.addAnimal(lion);
        zoo.addAnimal(elephant);

        zoo.displayAllAnimals();

        zoo.makeAllSounds();

        zoo.moveAllAnimals();
    }
}