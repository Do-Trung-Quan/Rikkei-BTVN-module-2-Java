package vn.edu.rikkei.session02.ex04;

import java.util.Scanner;

public class SecurityPinAuthentication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final String SECRET_PIN = "889900";
        int maxAttempts = 3;
        int currentAttempt = 1;
        boolean isAuthenticated = false;

        System.out.println("--- CỔNG XÁC THỰC AN TOÀN HỆ THỐNG ---");

        while (currentAttempt <= maxAttempts) {
            System.out.printf("[Lần %d/%d] Nhập mã PIN bảo mật: ", currentAttempt, maxAttempts);
            String inputPin = scanner.nextLine();

            if (inputPin.equals(SECRET_PIN)) {
                isAuthenticated = true;
                break;
            } else {
                int remainingAttempts = maxAttempts - currentAttempt;
                if (remainingAttempts > 0) {
                    System.out.printf(" => Mật khẩu không chính xác! Bạn còn %d lần thử.\n", remainingAttempts);
                }
            }
            currentAttempt++;
        }

        if (isAuthenticated) {
            System.out.println("+-------------------------------------------------------+");
            System.out.println("|  XÁC THỰC THÀNH CÔNG — CHÀO MỪNG QUẢN TRỊ VIÊN!       |");
            System.out.println("+-------------------------------------------------------+");
        } else {
            System.out.println("+-------------------------------------------------------+");
            System.out.println("|  CẢNH BÁO: TÀI KHOẢN ĐÃ BỊ TẠM KHÓA BẢO MẬT!          |");
            System.out.println("+-------------------------------------------------------+");
        }

        scanner.close();
    }
}