package Bai2;

class AnimalFactory {
    public Animal createAnimal(String animalType) {
        if (animalType == null) {
            return null;
        }

        animalType = animalType.toLowerCase();

        switch (animalType) {
            case "dog":
                return new Dog();
            case "cat":
                return new Cat();
            case "bird":
                return new Bird();
            default:
                throw new IllegalArgumentException("Không hỗ trợ loại động vật: " + animalType);
        }
    }
}
