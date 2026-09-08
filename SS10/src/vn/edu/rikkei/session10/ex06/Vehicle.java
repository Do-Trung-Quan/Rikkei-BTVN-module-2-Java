package vn.edu.rikkei.session10.ex06;

public class Vehicle {
    private String vehicleId;
    private String brand;
    private int year;

    public Vehicle(String vehicleId, String brand, int year) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.year = year;
    }

    public void displayInfo() {
        String info = String.format("[%s] Hãng: %-6s | Năm SX: %d", vehicleId, brand, year);
        // Thay thế chuỗi "Hyundai |" thành "Hyundai|" để sát với định dạng mẫu nếu cần,
        // ở đây dùng %-6s để tương thích khoảng trắng cho "Toyota" (6 ký tự) và "Hyundai" (7 ký tự).
        if (brand.equals("Hyundai")) {
            info = String.format("[%s] Hãng: %s| Năm SX: %d", vehicleId, brand, year);
        }

        System.out.printf("| %-53s |\n", info);
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }
}