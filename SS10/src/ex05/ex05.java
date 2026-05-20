package ex05;

import java.util.Scanner;

public class ex05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Khởi tạo các đối tượng có sẵn data như trong hình
        Dog dog = new Dog("Buddy", 3, true);
        Cat cat = new Cat("Mimi", 2, true);
        Elephant elephant = new Elephant("Dumbo", 10, false);

        // Đưa vào mảng Animal để test đa hình
        Animal[] animals = {dog, cat, elephant};

        int choice = -1;
        while (true) {
            System.out.println("===== ZOO MANAGEMENT MENU =====");
            System.out.println("1. Tạo đối tượng và hiển thị thông tin");
            System.out.println("2. Kiểm tra Overriding: makeSound()");
            System.out.println("3. Kiểm tra Overloading: eat()");
            System.out.println("4. Kiểm tra đa hình runtime (Animal array)");
            System.out.println("5. Gọi phương thức đặc trưng từng loài");
            System.out.println("0. Thoát");
            System.out.println("===============================");
            System.out.print("Chọn chức năng: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ, vui lòng nhập số!");
                System.out.println();
                continue;
            }

            System.out.println();

            switch (choice) {
                case 1:
                    System.out.println("--- THÔNG TIN CÁC ĐỘNG VẬT ---");
                    for (Animal a : animals) {
                        a.showInfo();
                    }
                    break;

                case 2:
                    System.out.println("--- OVERRIDING: makeSound() ---");
                    dog.makeSound();
                    cat.makeSound();
                    elephant.makeSound();
                    break;

                case 3:
                    System.out.println("--- OVERLOADING: eat() ---");
                    dog.eat();
                    dog.eat("meat");
                    cat.eat("fish");
                    elephant.eat();
                    break;

                case 4:
                    System.out.println("--- POLYMORPHISM RUNTIME ---");
                    // Duyệt mảng Animal nhưng gọi trúng hàm makeSound() của từng lớp con
                    for (Animal a : animals) {
                        a.makeSound();
                    }
                    break;

                case 5:
                    System.out.println("--- PHƯƠNG THỨC RIÊNG CỦA TỪNG LOÀI ---");
                    // Ép kiểu (Downcasting) để gọi hàm đặc trưng
                    for (Animal a : animals) {
                        if (a instanceof Dog) {
                            ((Dog) a).fetchBall();
                        } else if (a instanceof Cat) {
                            ((Cat) a).climbTree();
                        } else if (a instanceof Elephant) {
                            ((Elephant) a).sprayWater();
                        }
                    }
                    break;

                case 0:
                    System.out.println("Thoát chương trình...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
            System.out.println();
        }
    }
}
