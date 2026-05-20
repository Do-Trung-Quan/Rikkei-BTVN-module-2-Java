package ex06;

import java.util.ArrayList;
import java.util.Scanner;

public class ex06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

        while (true) {
            System.out.println("========= VEHICLE MANAGEMENT MENU =========");
            System.out.println("1. Hiển thị thông tin tất cả phương tiện");
            System.out.println("2. Kiểm tra Overriding: startEngine()");
            System.out.println("3. Kiểm tra Overloading: move()");
            System.out.println("4. Kiểm tra đa hình runtime (Vehicle array/list)");
            System.out.println("5. Gọi hành vi đặc trưng của từng loại");
            System.out.println("6. Thêm phương tiện mới");
            System.out.println("0. Thoát");
            System.out.println("===========================================");
            System.out.print("Chọn chức năng: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập số!");
                System.out.println();
                continue;
            }

            System.out.println(); // In 1 dòng trống cho giống format trong ảnh

            switch (choice) {
                case 1:
                    System.out.println("--- THÔNG TIN PHƯƠNG TIỆN ---");

                    for (Vehicle vehicle : vehicles) {
                        vehicle.showInfo();
                        System.out.println("--------------------");
                    }
                    break;

                case 2:
                    System.out.println("--- OVERRIDING: startEngine() ---");

                    for (Vehicle vehicle : vehicles) {
                        vehicle.startEngine();
                    }
                    break;

                case 3:
                    System.out.println("--- OVERLOADING: move() ---");

                    for (Vehicle vehicle : vehicles) {
                        vehicle.move();
                        vehicle.move(80);
                        System.out.println("-------------------");
                    }
                    break;

                case 4:
                    System.out.println("--- POLYMORPHISM RUNTIME ---");

                    for (Vehicle vehicle : vehicles) {
                        vehicle.startEngine();
                    }
                    break;

                case 5:
                    System.out.println("--- HÀNH VI ĐẶC TRƯNG CỦA TỪNG LOẠI ---");

                    for (Vehicle vehicle : vehicles) {
                        if (vehicle instanceof Car) ((Car)vehicle).openTrunk();
                        else if (vehicle instanceof Motorcycle) ((Motorcycle)vehicle).doWheelie();
                        else if (vehicle instanceof Truck) ((Truck)vehicle).loadCargo();
                    }
                    break;

                case 6:
                    System.out.println("--- THÊM PHƯƠNG TIỆN MỚI ---");

                    System.out.print("Loại (car/motorcycle/truck): ");
                    String type = scanner.nextLine();
                    System.out.print("Brand: ");
                    String brand = scanner.nextLine();
                    System.out.print("Year: ");
                    int year = Integer.parseInt(scanner.nextLine());
                    System.out.print("Fuel Type: ");
                    String fuelType = scanner.nextLine();

                    switch (type) {
                        case "car":
                            vehicles.add(new Car(brand, year, fuelType));
                            break;
                        case "motorcycle":
                            vehicles.add(new Motorcycle(brand, year, fuelType));
                            break;
                        case "truck":
                            vehicles.add(new Truck(brand, year, fuelType));
                            break;
                        default:
                            System.out.println("Loại xe không phù hợp!");
                    }

                    break;

                case 0:
                    System.out.println("Thoát chương trình...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn từ 0 đến 6!");
            }
            System.out.println(); // Dòng trống cách biệt giữa các lần lặp
        }
    }
}
