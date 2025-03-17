package Bai3;

public class Animal {
    public void makeSound() {
        System.out.println("Some sound");
    }
}
class Dog extends Animal {
    // Ghi đè phương thức makeSound
    @Override
    public void makeSound() {
        System.out.println("Woof Woof");
    }
}
class Cat extends Animal {
    // Ghi đè phương thức makeSound
    @Override
    public void makeSound() {
        System.out.println("Meow Meow");
    }
}
class Main {
    public static void main(String[] args) {
        Animal myAnimal = new Animal();
        Animal myDog = new Dog();
        Animal myCat = new Cat();


        myAnimal.makeSound();
        myDog.makeSound();
        myCat.makeSound();
    }
}

