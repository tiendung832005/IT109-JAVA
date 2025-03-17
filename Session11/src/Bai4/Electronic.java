package Bai4;
import java.util.ArrayList;
import java.util.List;
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
        List<Electronic> devices = new ArrayList<>();
        devices.add(new TV());
        devices.add(new Radio());

        System.out.println("Các thiết bị đang bật: ");
        for (Electronic device : devices) {
            device.turnOn();
        }

        System.out.println("\nCác thiết bị đang tắt: ");
        for (Electronic device : devices) {
            device.turnOff();
        }
    }
}
