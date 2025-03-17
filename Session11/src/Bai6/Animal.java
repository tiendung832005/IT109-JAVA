package Bai6;

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
        System.out.println("Trumpet");
    }

    @Override
    public void move() {
        System.out.println("The elephant is walking");
    }
}

class Zoo {
    private Animal[] animals;
    private int size;

    public Zoo() {
        animals = new Animal[0];
        size = 0;
    }

    public void addAnimal(Animal animal) {
        Animal[] newAnimals = new Animal[size + 1];
        for (int i = 0; i < size; i++) {
            newAnimals[i] = animals[i];
        }
        newAnimals[size] = animal; // Thêm phần tử mới
        animals = newAnimals;
        size++;
    }

    public void makeAllSounds() {
        System.out.println("Animal Sound");
        for (int i = 0; i < size; i++) {
            System.out.print(animals[i].getName() + " makes sound: ");
            animals[i].sound();
        }
    }

    public void moveAllAnimals() {
        System.out.println("Animal Movement");
        for (int i = 0; i < size; i++) {
            System.out.print(animals[i].getName() + " moves: ");
            animals[i].move();
        }
    }

    public void displayAllAnimals() {
        System.out.println("Zoo Animal");
        for (int i = 0; i < size; i++) {
            System.out.println("Name: " + animals[i].getName() + ", Age: " + animals[i].getAge() + ", Type: " + animals[i].getClass().getSimpleName());
        }
    }
}

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
