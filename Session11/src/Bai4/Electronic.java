package Bai4;
public interface Electronic {
    void turnOn();
    void turnOff();
}

class TV implements Electronic {
    @Override
    public void turnOn() {
        System.out.println("TV đang bật");
    }

    @Override
    public void turnOff() {
        System.out.println("TV đang tắt");
    }
}

class Radio implements Electronic {
    @Override
    public void turnOn() {
        System.out.println("Radio đang bật");
    }

    @Override
    public void turnOff() {
        System.out.println("Radio đang tắt");
    }
}

class Main {
    public static void main(String[] args) {
        // Khai báo mảng Electronic
        Electronic[] devices = new Electronic[2];
        devices[0] = new TV();
        devices[1] = new Radio();

        System.out.println("Các thiết bị đang bật: ");
        for (int i = 0; i < devices.length; i++) {
            devices[i].turnOn();
        }

        System.out.println("\nCác thiết bị đang tắt: ");
        for (int i = 0; i < devices.length; i++) {
            devices[i].turnOff();
        }
    }
}
