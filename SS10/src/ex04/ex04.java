package ex04;

class Car {
    private int currentSpeed = 0;

    // 1. Tăng tốc mặc định
    public void accelerate() {
        currentSpeed += 10;
        System.out.println("Car accelerates by default: +10 km/h");
    }

    // 2. Tăng tốc theo tốc độ truyền vào
    public void accelerate(int speed) {
        currentSpeed += speed;
        System.out.println("Car accelerates by " + speed + " km/h");
    }

    // 3. Tăng tốc theo công thức: tốc độ x thời gian
    public void accelerate(int speed, int seconds) {
        int increase = speed * seconds;
        currentSpeed += increase;
        System.out.println("Car accelerates " + increase + " km/h (speed x time)");
    }

    // In trạng thái hiện tại
    public void printStatus() {
        System.out.println("Current speed: " + currentSpeed + " km/h");
    }
}

public class ex04 {
    public static void main(String[] args) {
        Car car = new Car();

        // Test trường hợp 1: Tăng tốc mặc định
        car.accelerate();
        car.printStatus();

        System.out.println(); // In dòng trống để giống với format kết quả

        // Test trường hợp 2: Truyền vào 1 tham số speed
        car.accelerate(20);
        car.printStatus();

        System.out.println();

        // Test trường hợp 3: Truyền vào 2 tham số (ví dụ: speed = 10, seconds = 2 => tăng 20 km/h)
        car.accelerate(10, 2);
        car.printStatus();
    }
}
