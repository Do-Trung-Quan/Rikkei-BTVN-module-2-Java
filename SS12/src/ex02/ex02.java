package ex02;

import java.util.ArrayList;
import java.util.Scanner;

abstract class Asset {
    protected String assetCode;
    protected String name;
    protected double purchasePrice;
    protected int yearsUsed;

    public Asset(String assetCode, String name, double purchasePrice, int yearsUsed) {
        this.assetCode = assetCode;
        this.name = name;
        this.purchasePrice = purchasePrice;
        this.yearsUsed = yearsUsed;
    }

    public abstract double getMarketValue();

    public String getAssetCode() {
        return assetCode;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public void showInfo() {
        System.out.printf("Mã: %s | Tên: %s | Giá gốc: %,.0f | Năm SD: %d\n", assetCode, name, purchasePrice, yearsUsed);
    }
}

class Computer extends Asset {
    private String ram;
    private String cpu;

    public Computer(String assetCode, String name, double purchasePrice, int yearsUsed, String ram, String cpu) {
        super(assetCode, name, purchasePrice, yearsUsed);
        this.ram = ram;
        this.cpu = cpu;
    }

    @Override
    public double getMarketValue() {
        return purchasePrice * Math.pow(0.80, yearsUsed);
    }

    @Override
    public void showInfo() {
        System.out.print("[Máy tính] ");
        super.showInfo();
        System.out.printf("           -> RAM: %s | CPU: %s\n", ram, cpu);
    }
}

class NetworkDevice extends Asset {
    private int numberOfPorts;

    public NetworkDevice(String assetCode, String name, double purchasePrice, int yearsUsed, int numberOfPorts) {
        super(assetCode, name, purchasePrice, yearsUsed);
        this.numberOfPorts = numberOfPorts;
    }

    @Override
    public double getMarketValue() {
        return purchasePrice * Math.pow(0.90, yearsUsed);
    }

    @Override
    public void showInfo() {
        System.out.print("[Thiết bị mạng] ");
        super.showInfo();
        System.out.printf("                -> Số cổng: %d\n", numberOfPorts);
    }
}

public class ex02 {
    private static ArrayList<Asset> assets = new ArrayList<>();

    public static void showValue(Asset a) {
        a.showInfo();
        System.out.printf("           -> Giá trị hiện tại (sau khấu hao): %,.0f VNĐ\n", a.getMarketValue());
        System.out.println("--------------------------------------------------");
    }

    public static void search(String assetCode) {
        boolean found = false;
        System.out.println("--- KẾT QUẢ TÌM KIẾM THEO MÀ ---");
        for (Asset a : assets) {
            if (a.getAssetCode().equalsIgnoreCase(assetCode)) {
                showValue(a);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy tài sản với mã: " + assetCode);
        }
    }

    public static void search(double minPrice) {
        boolean found = false;
        System.out.println("--- KẾT QUẢ TÌM KIẾM THEO GIÁ LỚN HƠN %,.0f ---".formatted(minPrice));
        for (Asset a : assets) {
            if (a.getPurchasePrice() > minPrice) {
                showValue(a);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không có tài sản nào thỏa mãn điều kiện.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        while (true) {
            System.out.println("\n===== HỆ THỐNG QUẢN LÝ TÀI SẢN =====");
            System.out.println("1. Nhập tài sản");
            System.out.println("2. Xuất báo cáo");
            System.out.println("3. Tìm kiếm tài sản");
            System.out.println("4. Sửa giá mua");
            System.out.println("0. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập số!");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("--- THÊM TÀI SẢN ---");
                    System.out.println("1. Máy tính | 2. Thiết bị mạng");
                    System.out.print("Chọn loại: ");
                    String type = scanner.nextLine();

                    try {
                        System.out.print("Nhập mã tài sản: ");
                        String code = scanner.nextLine();
                        System.out.print("Nhập tên tài sản: ");
                        String name = scanner.nextLine();
                        System.out.print("Nhập giá mua ban đầu: ");
                        double price = Double.parseDouble(scanner.nextLine());
                        System.out.print("Nhập số năm đã sử dụng: ");
                        int years = Integer.parseInt(scanner.nextLine());

                        if (type.equals("1")) {
                            System.out.print("Nhập dung lượng RAM: ");
                            String ram = scanner.nextLine();
                            System.out.print("Nhập dòng CPU: ");
                            String cpu = scanner.nextLine();
                            assets.add(new Computer(code, name, price, years, ram, cpu));
                            System.out.println("Đã thêm Máy tính thành công!");
                        } else if (type.equals("2")) {
                            System.out.print("Nhập số cổng: ");
                            int ports = Integer.parseInt(scanner.nextLine());
                            assets.add(new NetworkDevice(code, name, price, years, ports));
                            System.out.println("Đã thêm Thiết bị mạng thành công!");
                        } else {
                            System.out.println("Loại tài sản không hợp lệ!");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Lỗi định dạng số. Hủy thêm tài sản.");
                    }
                    break;

                case 2:
                    System.out.println("--- BÁO CÁO TÀI SẢN ---");
                    if (assets.isEmpty()) {
                        System.out.println("Hệ thống chưa có dữ liệu.");
                    } else {
                        for (Asset a : assets) {
                            showValue(a);
                        }
                    }
                    break;

                case 3:
                    System.out.println("--- TÌM KIẾM TÀI SẢN ---");
                    System.out.println("1. Tìm theo mã | 2. Tìm theo mức giá tối thiểu");
                    System.out.print("Chọn cách tìm kiếm: ");
                    String searchOption = scanner.nextLine();

                    if (searchOption.equals("1")) {
                        System.out.print("Nhập mã tài sản cần tìm: ");
                        String searchCode = scanner.nextLine();
                        search(searchCode);
                    } else if (searchOption.equals("2")) {
                        System.out.print("Nhập mức giá tối thiểu: ");
                        try {
                            double minPrice = Double.parseDouble(scanner.nextLine());
                            search(minPrice);
                        } catch (NumberFormatException e) {
                            System.out.println("Lỗi: Mức giá không hợp lệ.");
                        }
                    } else {
                        System.out.println("Lựa chọn không hợp lệ.");
                    }
                    break;

                case 4:
                    System.out.println("--- CẬP NHẬT GIÁ MUA ---");
                    System.out.print("Nhập mã tài sản cần sửa: ");
                    String editCode = scanner.nextLine();
                    boolean isEdited = false;

                    for (Asset a : assets) {
                        if (a.getAssetCode().equalsIgnoreCase(editCode)) {
                            System.out.print("Nhập giá mua mới: ");
                            try {
                                double newPrice = Double.parseDouble(scanner.nextLine());
                                a.setPurchasePrice(newPrice);
                                System.out.println("Cập nhật giá thành công!");
                                isEdited = true;
                            } catch (NumberFormatException e) {
                                System.out.println("Lỗi: Mức giá không hợp lệ.");
                            }
                            break;
                        }
                    }
                    if (!isEdited) {
                        System.out.println("Không tìm thấy tài sản mang mã: " + editCode);
                    }
                    break;

                case 0:
                    System.out.println("Thoát chương trình.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn từ 0 đến 4.");
            }
        }
    }
}
