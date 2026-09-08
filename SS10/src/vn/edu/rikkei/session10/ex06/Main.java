package vn.edu.rikkei.session10.ex06;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- KHỞI TẠO XE CAR VÀ TRUCK ---");
        System.out.println("Car: \"CAR-01\", \"Toyota\", 2024, 5 chỗ");
        System.out.println("Truck: \"TRK-01\", \"Hyundai\", 2023, 15.5 tấn");
        System.out.println();

        System.out.println("+-------------------------------------------------------+");
        System.out.println("|             HỒ SƠ PHƯƠNG TIỆN VẬN TẢI RIKKEI          |");
        System.out.println("+-------------------------------------------------------+");

        Car car = new Car("CAR-01", "Toyota", 2024, 5);
        car.displayInfo();

        System.out.println("|-------------------------------------------------------|");

        Truck truck = new Truck("TRK-01", "Hyundai", 2023, 15.5);
        truck.displayInfo();

        System.out.println("+-------------------------------------------------------+");
    }
}