package Bai2;

public class Bai2 {
    public static void main(String[] args) {
        AnimalFactory factory = new AnimalFactory();

        try {
            Animal dog = factory.createAnimal("dog");
            Animal cat = factory.createAnimal("cat");
            Animal bird = factory.createAnimal("bird");

            System.out.println("Con chó kêu: " + dog.speak());
            System.out.println("Con mèo kêu: " + cat.speak());
            System.out.println("Con chim kêu: " + bird.speak());

            System.out.println("Thử tạo loại động vật không tồn tại:");
            Animal unknown = factory.createAnimal("fish");
            System.out.println(unknown.speak());
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }

        try {
            Animal anotherDog = factory.createAnimal("DOG");
            System.out.println("Tạo con chó với chữ in hoa: " + anotherDog.speak());
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}
