package vn.edu.rikkei.session02.ex03;

import java.util.Locale;
import java.util.Scanner;

public class LogisticsRevenueAccumulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double totalRevenue = 0;
        int validMonthsCount = 0;

        System.out.println("--- THỐNG KÊ DOANH THU LOGISTICS 12 THÁNG (Đơn vị: Triệu VNĐ) ---");

        for (int i = 1; i <= 12; i++) {
            System.out.print("Nhập doanh thu Tháng " + i + ": ");
            double revenue;

            try {
                revenue = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(" => Lỗi: Vui lòng nhập số hợp lệ!");
                i--; // Lùi lại để nhập lại tháng bị lỗi
                continue;
            }

            if (revenue < 100) {
                System.out.println(" Nhắc nhở: Tháng " + i + " có doanh thu < 100M -> Bỏ qua thống kê bình quân.");
                continue;
            }

            totalRevenue += revenue;
            validMonthsCount++;
        }

        System.out.println();
        System.out.println("+-------------------------------------------------------+");
        System.out.println("|           BÁO CÁO DOANH THU ĐẠT CHUẨN NĂM             |");
        System.out.println("+-------------------------------------------------------+");

        if (validMonthsCount > 0) {
            double averageRevenue = totalRevenue / validMonthsCount;

            String monthStr = validMonthsCount + " tháng";
            String totalStr = String.format(Locale.US, "%,.2f Triệu VNĐ", totalRevenue);
            String avgStr = String.format(Locale.US, "%,.2f Triệu VNĐ", averageRevenue);

            System.out.printf("| %-34s %-18s |\n", "Số tháng đạt tiêu chuẩn (>= 100M):", monthStr);
            System.out.printf("| %-34s %-18s |\n", "Tổng doanh thu hợp lệ:", totalStr);
            System.out.printf("| %-34s %-18s |\n", "Doanh thu bình quân tháng:", avgStr);
        } else {
            System.out.println("| Số tháng đạt tiêu chuẩn (>= 100M): 0 tháng            |");
            System.out.println("| Tổng doanh thu hợp lệ:             0.00 Triệu VNĐ     |");
            System.out.println("| Doanh thu bình quân tháng:         0.00 Triệu VNĐ     |");
        }
        System.out.println("+-------------------------------------------------------+");

        scanner.close();
    }
}