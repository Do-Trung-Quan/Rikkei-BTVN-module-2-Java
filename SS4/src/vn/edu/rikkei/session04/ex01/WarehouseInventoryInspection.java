package vn.edu.rikkei.session04.ex01;

import java.util.Locale;
import java.util.Scanner;

public class WarehouseInventoryInspection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;

        System.out.println("--- HỆ THỐNG KIỂM KÊ TỒN KHO TRUNG CHUYỂN ---");

        // Nhập và kiểm tra N (3 đến 50)
        while (true) {
            System.out.print("Nhập số mặt hàng cần kiểm kê (N): ");
            try {
                n = Integer.parseInt(scanner.nextLine());
                if (n >= 3 && n <= 50) {
                    break;
                } else {
                    System.out.println("Vui lòng nhập số mặt hàng từ 3 đến 50!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Định dạng không hợp lệ, vui lòng nhập số nguyên.");
            }
        }

        // Khai báo mảng và nhập số lượng tồn kho
        int[] stock = new int[n];
        for (int i = 0; i < n; i++) {
            while (true) {
                System.out.print("Nhập số lượng tồn Mã hàng #" + i + ": ");
                try {
                    int amount = Integer.parseInt(scanner.nextLine());
                    if (amount >= 0) {
                        stock[i] = amount;
                        break;
                    } else {
                        System.out.println("Lỗi: Số lượng tồn kho không được âm!");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Lỗi: Định dạng không hợp lệ, vui lòng nhập số nguyên.");
                }
            }
        }

        // Khởi tạo các biến tính toán
        int totalStock = 0;
        int minStock = stock[0];
        int minIndex = 0;
        StringBuilder stockListStr = new StringBuilder("[");

        // Duyệt mảng để xử lý logic
        for (int i = 0; i < n; i++) {
            totalStock += stock[i];

            if (stock[i] < minStock) {
                minStock = stock[i];
                minIndex = i;
            }

            stockListStr.append(stock[i]);
            if (i < n - 1) {
                stockListStr.append(", ");
            }
        }
        stockListStr.append("]");

        double averageStock = (double) totalStock / n;

        // In kết quả
        System.out.println();
        System.out.println("+-------------------------------------------------------+");
        System.out.println("|              BÁO CÁO KIỂM KÊ TỒN KHO HÀNG             |");
        System.out.println("+-------------------------------------------------------+");
        System.out.printf("| Danh sách tồn kho:           %-25s|\n", stockListStr.toString());
        System.out.printf("| Tổng sản phẩm tồn kho:       %-25s|\n", totalStock + " sản phẩm");
        System.out.printf("| Tồn kho bình quân:           %-25s|\n", String.format(Locale.US, "%.2f sản phẩm/mã", averageStock));
        System.out.println("|-------------------------------------------------------|");
        System.out.println("| CẢNH BÁO NHẬP HÀNG KHẨN CẤP:                          |");
        System.out.printf("|  -> Mã hàng #%-2d có tồn kho thấp nhất: %-14s|\n", minIndex, minStock + " sản phẩm");
        System.out.println("+-------------------------------------------------------+");

        scanner.close();
    }
}