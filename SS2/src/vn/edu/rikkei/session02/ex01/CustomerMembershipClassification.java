package vn.edu.rikkei.session02.ex01;

import java.util.Locale;
import java.util.Scanner;

public class CustomerMembershipClassification {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- HỆ THỐNG PHÂN HẠNG THÀNH VIÊN CRM ---");
        System.out.print("Nhập tổng chi tiêu tích lũy (VNĐ): ");
        double totalSpending = Double.parseDouble(scanner.nextLine());

        String membershipTier;
        double discountRate;

        // Xử lý phân hạng bằng if - else if - else
        if (totalSpending < 2000000) {
            membershipTier = "Đồng (Bronze)";
            discountRate = 2.0;
        } else if (totalSpending < 5000000) {
            membershipTier = "Bạc (Silver)";
            discountRate = 5.0;
        } else if (totalSpending < 15000000) {
            membershipTier = "Vàng (Gold)";
            discountRate = 10.0;
        } else {
            membershipTier = "Kim Cương (Diamond)";
            discountRate = 15.0;
        }

        boolean isVip;
        String customerGroup;

        // Xác định nhóm khách hàng bằng if - else
        if (discountRate >= 10.0) {
            isVip = true;
            customerGroup = "Khách hàng VIP";
        } else {
            isVip = false;
            customerGroup = "Khách hàng Tiêu chuẩn";
        }

        // In kết quả
        System.out.println();
        System.out.println("+-------------------------------------------------------+");
        System.out.println("|              KẾT QUẢ PHÂN HẠNG THÀNH VIÊN             |");
        System.out.println("+-------------------------------------------------------+");

        String spendingStr = String.format(Locale.US, "%,.2f VNĐ", totalSpending);
        String discountStr = String.format(Locale.US, "%.1f%%", discountRate);

        System.out.printf("| %-28s %-24s |\n", "Tổng chi tiêu:", spendingStr);
        System.out.printf("| %-28s %-24s |\n", "Hạng thẻ thành viên:", membershipTier);
        System.out.printf("| %-28s %-24s |\n", "Tỷ lệ chiết khấu ưu đãi:", discountStr);
        System.out.printf("| %-28s %-24s |\n", "Nhóm khách hàng:", customerGroup);
        System.out.println("+-------------------------------------------------------+");

        scanner.close();
    }
}