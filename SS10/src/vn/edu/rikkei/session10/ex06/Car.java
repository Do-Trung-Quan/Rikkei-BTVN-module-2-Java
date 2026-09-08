package vn.edu.rikkei.session10.ex06;

public class Car extends Vehicle {
    private int numSeats;

    public Car(String vehicleId, String brand, int year, int numSeats) {
        super(vehicleId, brand, year);
        this.numSeats = numSeats;
    }

    @Override
    public void displayInfo() {
        // Tái sử dụng phương thức hiển thị của lớp cha
        super.displayInfo();

        // Chỉ in phần hiển thị bổ sung của con
        String specificInfo = String.format("-> Đặc tả riêng: Số chỗ ngồi: %d chỗ", numSeats);
        System.out.printf("| %-53s |\n", specificInfo);
    }
}