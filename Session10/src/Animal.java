
class Animals {
    private String name;
    private int age;

    public Animals(String name, int age) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên động vật không được để trống");
        }
        if (age < 0) {
            throw new IllegalArgumentException("Tuổi động vật không được âm");
        }

        this.name = name;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên động vật không được để trống");
        }
        this.name = name;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Tuổi động vật không được âm");
        }
        this.age = age;
    }

    // Phương thức hiển thị thông tin
    public void displayInfo() {
        System.out.println("Tên: " + name + ", Tuổi: " + age);
    }

    public String makeSound() {
        return "gu gu";
    }
}


class Dog extends Animals {

    private String breed;


    public Dog(String name, int age, String breed) {

        super(name, age);


        if (breed == null || breed.trim().isEmpty()) {
            throw new IllegalArgumentException("Giống chó không được để trống");
        }

        this.breed = breed;
    }


    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        if (breed == null || breed.trim().isEmpty()) {
            throw new IllegalArgumentException("Giống chó không được để trống");
        }
        this.breed = breed;
    }


    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Giống chó: " + breed);
    }

    @Override
    public String makeSound() {
        return "gau gau";
    }
}


class Cat extends Animals {
    private String furColor;


    public Cat(String name, int age, String furColor) {

        super(name, age);

        if (furColor == null || furColor.trim().isEmpty()) {
            throw new IllegalArgumentException("Màu lông không được để trống");
        }

        this.furColor = furColor;
    }

    public String getFurColor() {
        return furColor;
    }

    public void setFurColor(String furColor) {
        if (furColor == null || furColor.trim().isEmpty()) {
            throw new IllegalArgumentException("Màu lông không được để trống");
        }
        this.furColor = furColor;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Màu lông: " + furColor);
    }

    // Ghi đè phương thức makeSound()
    @Override
    public String makeSound() {
        return "meo meo";
    }
}


class AnimalManagement {
    public static void main(String[] args) {
        try {
            Animals[] animalsList = new Animals[5];

            animalsList[0] = new Dog("Mực", 3, "Chó cỏ");
            animalsList[1] = new Dog("Max", 5, "Chó ta");
            animalsList[2] = new Cat("Gâu", 2, "Trắng");
            animalsList[3] = new Cat("Luna", 4, "Đen");
            animalsList[4] = new Animals("Động vật chung", 1);

            System.out.println("DANH SÁCH ĐỘNG VẬT:");

            for (int i = 0; i < animalsList.length; i++) {
                System.out.println("\nĐộng vật #" + (i + 1) + ":");
                animalsList[i].displayInfo();
                System.out.println("Âm thanh: " + animalsList[i].makeSound());
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}