package ex01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ex01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> scores = new ArrayList<>();

        while (true) {
            System.out.println("\n******************QUẢN LÝ ĐIỂM SV******************");
            System.out.println("1. Nhập danh sách điểm sinh viên");
            System.out.println("2. In danh sách điểm");
            System.out.println("3. Tính điểm trung bình của các sinh viên");
            System.out.println("4. Tìm điểm cao nhất và thấp nhất");
            System.out.println("5. Đếm số lượng sinh viên đạt và trượt");
            System.out.println("6. Sắp xếp điểm tăng dần");
            System.out.println("7. Thống kê số lượng sinh viên giỏi và xuất sắc");
            System.out.println("8. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Nhập số lượng sinh viên: ");
                    int n = scanner.nextInt();
                    scores.clear();
                    for (int i = 0; i < n; i++) {
                        System.out.print("Nhập điểm sinh viên thứ " + (i + 1) + ": ");
                        double score = scanner.nextDouble();
                        if (score >= 0 && score <= 10) {
                            scores.add(score);
                        } else {
                            System.out.println("Điểm không hợp lệ! Vui lòng nhập từ 0-10.");
                            i--;
                        }
                    }
                    break;
                case 2:
                    if (scores.isEmpty()) {
                        System.out.println("Chưa có dữ liệu!");
                    } else {
                        System.out.println("Danh sách điểm: " + scores);
                    }
                    break;
                case 3:
                    if (scores.isEmpty()) {
                        System.out.println("Chưa có dữ liệu!");
                    } else {
                        double sum = 0;
                        for (double s : scores) sum += s;
                        System.out.printf("Điểm trung bình: %.2f\n", (sum / scores.size()));
                    }
                    break;
                case 4:
                    if (scores.isEmpty()) {
                        System.out.println("Chưa có dữ liệu!");
                    } else {
                        System.out.println("Điểm cao nhất: " + Collections.max(scores));
                        System.out.println("Điểm thấp nhất: " + Collections.min(scores));
                    }
                    break;
                case 5:
                    int passed = 0, failed = 0;
                    for (double s : scores) {
                        if (s >= 5) passed++;
                        else failed++;
                    }
                    System.out.println("Số lượng sinh viên đạt: " + passed);
                    System.out.println("Số lượng sinh viên trượt: " + failed);
                    break;
                case 6:
                    if (scores.isEmpty()) {
                        System.out.println("Chưa có dữ liệu!");
                    } else {
                        Collections.sort(scores);
                        System.out.println("Danh sách điểm tăng dần: " + scores);
                    }
                    break;
                case 7:
                    int excellent = 0;
                    for (double s : scores) {
                        if (s >= 8) excellent++;
                    }
                    System.out.println("Số lượng sinh viên giỏi và xuất sắc: " + excellent);
                    break;
                case 8:
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}
