package vn.edu.rikkei.session02.ex02;

import java.util.Locale;
import java.util.Scanner;

public class MiniAtmNavigationMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double balance = 5000000.0;
        int choice = -1;

        do {
            System.out.println("--- MENU GIAO DỊCH ATM MINI ---");
            System.out.println("1. Xem số dư | 2. Nộp tiền | 3. Rút tiền | 4. Thoát");
            System.out.print("Chọn chức năng (1-4): ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("=> Lựa chọn không hợp lệ!");
                continue;
            }

            switch (choice) {
                case 1:
                    String formattedBalance = String.format(Locale.US, "%,.2f VNĐ", balance);
                    System.out.println("+-------------------------------------------------------+");
                    System.out.printf("| SỐ DƯ HIỆN TẠI: %29s         |\n", formattedBalance);
                    System.out.println("+-------------------------------------------------------+");
                    break;

                case 2:
                    System.out.print("Nhập số tiền cần nộp: ");
                    try {
                        double deposit = Double.parseDouble(scanner.nextLine());
                        if (deposit > 0) {
                            balance += deposit;
                            System.out.printf(Locale.US, "=> Nộp thành công %,.2f VNĐ. Số dư mới: %,.2f VNĐ\n", deposit, balance);
                        } else {
                            System.out.println("=> Số tiền nộp phải lớn hơn 0!");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("=> Số tiền nhập vào không hợp lệ!");
                    }
                    break;

                case 3:
                    System.out.print("Nhập số tiền cần rút: ");
                    try {
                        double withdraw = Double.parseDouble(scanner.nextLine());
                        if (withdraw > 0 && withdraw <= balance) {
                            balance -= withdraw;
                            System.out.printf(Locale.US, "=> Rút thành công %,.2f VNĐ. Số dư mới: %,.2f VNĐ\n", withdraw, balance);
                        } else if (withdraw <= 0) {
                            System.out.println("=> Số tiền rút phải lớn hơn 0!");
                        } else {
                            System.out.println("=> Số dư không đủ để thực hiện giao dịch!");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("=> Số tiền nhập vào không hợp lệ!");
                    }
                    break;

                case 4:
                    System.out.println("=> Cảm ơn quý khách đã sử dụng dịch vụ ATM. Xin chào!");
                    break;

                default:
                    System.out.println("=> Lựa chọn không hợp lệ. Vui lòng chọn từ 1 đến 4!");
                    break;
            }
        } while (choice != 4);

        scanner.close();
    }
}