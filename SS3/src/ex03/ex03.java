package ex03;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class ex03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Long> salaries = new ArrayList<>();
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        DecimalFormat df = new DecimalFormat("#,###", symbols);

        while (true) {
            System.out.println("========== MENU ==========");
            System.out.println("1. Nhập lương nhân viên");
            System.out.println("2. Hiển thị thống kê");
            System.out.println("3. Tính tổng tiền thưởng nhân viên");
            System.out.println("4. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("--- Nhập lương nhân viên (nhập -1 để kết thúc) ---");
                while (true) {
                    System.out.print("Nhập lương: ");
                    long salary = scanner.nextLong();
                    if (salary == -1) {
                        break;
                    }
                    if (salary < 0 || salary > 500000000) {
                        System.out.println("Lương không hợp lệ. Nhập lại.");
                    } else {
                        salaries.add(salary);
                        String loai = "";
                        if (salary < 5000000) {
                            loai = "Thấp";
                        } else if (salary < 15000000) {
                            loai = "Trung bình";
                        } else if (salary < 50000000) {
                            loai = "Khá";
                        } else {
                            loai = "Cao";
                        }
                        System.out.println("-> Phân loại: " + loai);
                    }
                }
            } else if (choice == 2) {
                System.out.println("--- Thống kê ---");
                if (salaries.isEmpty()) {
                    System.out.println("Chưa có dữ liệu");
                } else {
                    long total = 0;
                    long max = Long.MIN_VALUE;
                    long min = Long.MAX_VALUE;
                    for (long s : salaries) {
                        total += s;
                        if (s > max) max = s;
                        if (s < min) min = s;
                    }
                    long avg = Math.round((double) total / salaries.size());

                    System.out.println("Số nhân viên: " + salaries.size());
                    System.out.println("Tổng lương: " + df.format(total) + " VND");
                    System.out.println("Lương trung bình: " + df.format(avg) + " VND");
                    System.out.println("Lương cao nhất: " + df.format(max) + " VND");
                    System.out.println("Lương thấp nhất: " + df.format(min) + " VND");
                }
            } else if (choice == 3) {
                System.out.println("--- Tính tổng số tiền thưởng nhân viên ---");
                long totalBonus = 0;
                for (long s : salaries) {
                    if (s < 5000000) {
                        totalBonus += Math.round(s * 0.05);
                    } else if (s < 15000000) {
                        totalBonus += Math.round(s * 0.10);
                    } else if (s < 50000000) {
                        totalBonus += Math.round(s * 0.15);
                    } else if (s < 100000000) {
                        totalBonus += Math.round(s * 0.20);
                    } else {
                        totalBonus += Math.round(s * 0.25);
                    }
                }
                System.out.println("Tổng tiền thưởng nhân viên: " + df.format(totalBonus) + " VND");
            } else if (choice == 4) {
                System.out.println("Kết thúc chương trình.");
                System.exit(0);
            }
        }
    }
}
