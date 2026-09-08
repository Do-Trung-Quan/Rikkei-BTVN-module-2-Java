package vn.edu.rikkei.session10.ex06;

import java.util.Locale;

public class Truck extends Vehicle {
    private double payloadTons;

    public Truck(String vehicleId, String brand, int year, double payloadTons) {
        super(vehicleId, brand, year);
        this.payloadTons = payloadTons;
    }

    @Override
    public void displayInfo() {
        // Tái sử dụng phương thức hiển thị của lớp cha
        super.displayInfo();

        // Chỉ in phần hiển thị bổ sung của con
        String specificInfo = String.format(Locale.US, "-> Đặc tả riêng: Tải trọng:   %.1f tấn", payloadTons);
        System.out.printf("| %-53s |\n", specificInfo);
    }
}