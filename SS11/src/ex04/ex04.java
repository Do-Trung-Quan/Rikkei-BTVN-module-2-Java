package ex04;

interface Connectable {
    void connectWifi();
}

interface Chargeable {
    void charge();
}

abstract class Device {
    protected int id;
    protected String name;

    public Device(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public abstract void turnOn();
    public abstract void turnOff();
}

class SmartPhone extends Device implements Connectable, Chargeable {
    public SmartPhone(int id, String name) {
        super(id, name);
    }

    @Override
    public void turnOn() {
        System.out.println(name + " is powering on.");
    }

    @Override
    public void turnOff() {
        System.out.println(name + " is powering off.");
    }

    @Override
    public void connectWifi() {
        System.out.println(name + " is connected to WiFi.");
    }

    @Override
    public void charge() {
        System.out.println(name + " is charging via Type-C.");
    }
}

class Laptop extends Device implements Connectable, Chargeable {
    public Laptop(int id, String name) {
        super(id, name);
    }

    @Override
    public void turnOn() {
        System.out.println(name + " is booting up Windows/macOS.");
    }

    @Override
    public void turnOff() {
        System.out.println(name + " is shutting down.");
    }

    @Override
    public void connectWifi() {
        System.out.println(name + " is connected to WiFi network.");
    }

    @Override
    public void charge() {
        System.out.println(name + " is charging via power adapter.");
    }
}

class Television extends Device implements Connectable {
    public Television(int id, String name) {
        super(id, name);
    }

    @Override
    public void turnOn() {
        System.out.println(name + " screen is turning on.");
    }

    @Override
    public void turnOff() {
        System.out.println(name + " screen is turning off.");
    }

    @Override
    public void connectWifi() {
        System.out.println(name + " is connected to home WiFi for Smart TV features.");
    }
}

public class ex04 {
    public static void main(String[] args) {
        // Khởi tạo danh sách thiết bị
        Device[] devices = new Device[]{
                new SmartPhone(1, "iPhone 15 Pro"),
                new Laptop(2, "ThinkPad T14"),
                new Television(3, "LG OLED TV")
        };

        // Duyệt qua danh sách và thực hiện các hành vi
        for (Device device : devices) {
            System.out.println("-------------------------");
            device.turnOn();

            // Kiểm tra và ép kiểu an toàn (Downcasting)
            if (device instanceof Connectable) {
                ((Connectable) device).connectWifi();
            }

            if (device instanceof Chargeable) {
                ((Chargeable) device).charge();
            }

            device.turnOff();
        }
    }
}
