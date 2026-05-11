package ex03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ex03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> plates = new ArrayList<>();

        while (true) {
            System.out.println("\n******************** QUẢN LÝ BIỂN SỐ XE ********************");
            System.out.println("1. Thêm các biển số xe");
            System.out.println("2. Hiển thị danh sách biển số xe");
            System.out.println("3. Tìm kiếm biển số xe");
            System.out.println("4. Tìm biển số xe theo mã tỉnh");
            System.out.println("5. Sắp xếp biển số xe tăng dần");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nhập số lượng biển số xe cần thêm: ");
                    int n = scanner.nextInt();
                    scanner.nextLine();
                    for (int i = 0; i < n; i++) {
                        System.out.print("Nhập biển số thứ " + (i + 1) + " (VD: 30F-123.45): ");
                        String plate = scanner.nextLine();
                        plates.add(plate.toUpperCase());
                    }
                    System.out.println("Đã thêm thành công!");
                    break;

                case 2:
                    if (plates.isEmpty()) {
                        System.out.println("Danh sách trống!");
                    } else {
                        System.out.println("Danh sách biển số xe: " + plates);
                    }
                    break;

                case 3:
                    System.out.print("Nhập biển số xe cần tìm: ");
                    String searchPlate = scanner.nextLine().toUpperCase();
                    if (plates.contains(searchPlate)) {
                        System.out.println("Tìm thấy biển số: " + searchPlate);
                    } else {
                        System.out.println("Không tìm thấy biển số này!");
                    }
                    break;

                case 4:
                    System.out.print("Nhập mã tỉnh (VD: 29, 30, 51...): ");
                    String provinceCode = scanner.nextLine();
                    boolean found = false;
                    System.out.println("Các biển số thuộc mã tỉnh " + provinceCode + ":");
                    for (String p : plates) {
                        if (p.startsWith(provinceCode)) {
                            System.out.println(p);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Không có biển số nào thuộc mã tỉnh này!");
                    }
                    break;

                case 5:
                    if (plates.isEmpty()) {
                        System.out.println("Danh sách trống!");
                    } else {
                        Collections.sort(plates);
                        System.out.println("Danh sách sau khi sắp xếp tăng dần: " + plates);
                    }
                    break;

                case 6:
                    System.exit(0);

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}
