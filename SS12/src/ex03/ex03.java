package ex03;

import java.util.ArrayList;
import java.util.Scanner;

interface IPromotion {
    void applyDiscount(double percentage);
}

abstract class Drink implements IPromotion {
    private int id;
    private String name;
    private double price;

    public Drink(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public abstract void prepare();

    @Override
    public void applyDiscount(double percentage) {
        this.price -= this.price * (percentage / 100.0);
    }
}

class Coffee extends Drink {
    public Coffee(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public void prepare() {
        System.out.println("Pha bằng máy");
    }
}

class FruitTea extends Drink {
    public FruitTea(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public void prepare() {
        System.out.println("Lắc với đá và trái cây tươi");
    }
}

public class ex03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Drink> menu = new ArrayList<>();
        int choice = -1;

        while (true) {
            System.out.println("\n===== QUẢN LÝ QUÁN CÀ PHÊ =====");
            System.out.println("1. Thêm món vào Menu");
            System.out.println("2. Hiển thị Menu");
            System.out.println("3. Áp dụng mã giảm giá");
            System.out.println("4. Xóa món");
            System.out.println("5. Thống kê");
            System.out.println("0. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ!");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("1. Cà phê | 2. Trà trái cây");
                    System.out.print("Chọn loại đồ uống: ");
                    String type = scanner.nextLine();

                    try {
                        System.out.print("Nhập ID: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        System.out.print("Nhập Tên: ");
                        String name = scanner.nextLine();
                        System.out.print("Nhập Giá: ");
                        double price = Double.parseDouble(scanner.nextLine());

                        if (type.equals("1")) {
                            menu.add(new Coffee(id, name, price));
                        } else if (type.equals("2")) {
                            menu.add(new FruitTea(id, name, price));
                        } else {
                            System.out.println("Loại đồ uống không hợp lệ!");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Dữ liệu không hợp lệ!");
                    }
                    break;

                case 2:
                    if (menu.isEmpty()) {
                        System.out.println("Menu trống.");
                    } else {
                        for (Drink d : menu) {
                            System.out.printf("ID: %d | Tên: %s | Giá: %,.0f | Cách pha chế: ", d.getId(), d.getName(), d.getPrice());
                            d.prepare();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Nhập % giảm giá: ");
                    try {
                        double percent = Double.parseDouble(scanner.nextLine());
                        for (Drink d : menu) {
                            d.applyDiscount(percent);
                        }
                        System.out.println("Áp dụng giảm giá thành công.");
                    } catch (NumberFormatException e) {
                        System.out.println("Dữ liệu không hợp lệ!");
                    }
                    break;

                case 4:
                    System.out.print("Nhập ID món cần xóa: ");
                    try {
                        int delId = Integer.parseInt(scanner.nextLine());
                        boolean removed = menu.removeIf(d -> d.getId() == delId);
                        if (removed) {
                            System.out.println("Đã xóa món thành công.");
                        } else {
                            System.out.println("Không tìm thấy ID.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Dữ liệu không hợp lệ!");
                    }
                    break;

                case 5:
                    if (menu.isEmpty()) {
                        System.out.println("Giá trị trung bình: 0");
                    } else {
                        double total = 0;
                        for (Drink d : menu) {
                            total += d.getPrice();
                        }
                        System.out.printf("Giá trung bình của các món trong menu: %,.0f\n", total / menu.size());
                    }
                    break;

                case 0:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}
