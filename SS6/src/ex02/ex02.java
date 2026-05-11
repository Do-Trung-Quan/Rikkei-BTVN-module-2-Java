package ex02;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ex02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fullName = "";
        String email = "";
        String phone = "";
        String password = "";

        while (true) {
            System.out.println("\n**************** QUẢN LÝ NGƯỜI DÙNG ****************");
            System.out.println("1. Nhập thông tin người dùng");
            System.out.println("2. Chuẩn hóa họ tên");
            System.out.println("3. Kiểm tra email hợp lệ");
            System.out.println("4. Kiểm tra số điện thoại hợp lệ");
            System.out.println("5. Kiểm tra mật khẩu hợp lệ");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Xóa bộ nhớ đệm sau khi nhập số

            switch (choice) {
                case 1:
                    System.out.print("Nhập họ và tên: ");
                    fullName = scanner.nextLine();
                    System.out.print("Nhập email: ");
                    email = scanner.nextLine();
                    System.out.print("Nhập số điện thoại: ");
                    phone = scanner.nextLine();
                    System.out.print("Nhập mật khẩu: ");
                    password = scanner.nextLine();
                    System.out.println("Đã nhập thông tin thành công!");
                    break;

                case 2:
                    if (fullName.isEmpty()) {
                        System.out.println("Chưa có thông tin họ tên!");
                    } else {
                        String[] words = fullName.trim().replaceAll("\\s+", " ").split(" ");
                        StringBuilder normalized = new StringBuilder();
                        for (String word : words) {
                            if (!word.isEmpty()) {
                                normalized.append(Character.toUpperCase(word.charAt(0)))
                                        .append(word.substring(1).toLowerCase())
                                        .append(" ");
                            }
                        }
                        fullName = normalized.toString().trim();
                        System.out.println("Họ tên sau khi chuẩn hóa: " + fullName);
                    }
                    break;

                case 3:
                    if (email.isEmpty()) {
                        System.out.println("Chưa có thông tin email!");
                    } else {
                        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[a-z]{2,}$";
                        if (Pattern.matches(emailRegex, email)) {
                            System.out.println("Email hợp lệ.");
                        } else {
                            System.out.println("Email KHÔNG hợp lệ.");
                        }
                    }
                    break;

                case 4:
                    if (phone.isEmpty()) {
                        System.out.println("Chưa có thông tin số điện thoại!");
                    } else {
                        String phoneRegex = "^(03|05|07|08|09)\\d{8}$";
                        if (Pattern.matches(phoneRegex, phone)) {
                            System.out.println("Số điện thoại hợp lệ.");
                        } else {
                            System.out.println("Số điện thoại KHÔNG hợp lệ.");
                        }
                    }
                    break;

                case 5:
                    if (password.isEmpty()) {
                        System.out.println("Chưa có thông tin mật khẩu!");
                    } else {
                        String passRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!_\\-]).{8,}$";
                        if (Pattern.matches(passRegex, password)) {
                            System.out.println("Mật khẩu hợp lệ.");
                        } else {
                            System.out.println("Mật khẩu KHÔNG hợp lệ.");
                        }
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
