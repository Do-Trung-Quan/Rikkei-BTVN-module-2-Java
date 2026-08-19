package vn.edu.rikkei.session04.ex04;

import java.util.Arrays;
import java.util.Scanner;

public class LibraryIsbnBinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] isbnList = {101, 105, 110, 125, 140, 155, 170, 188, 195, 200};

        System.out.println("--- HỆ THỐNG TRA CỨU SÁCH ISBN THƯ VIỆN QUỐC GIA ---");
        System.out.println("Danh mục ISBN: " + Arrays.toString(isbnList));
        System.out.print("Nhập mã ISBN cần tra cứu: ");

        int targetIsbn = -1;
        try {
            targetIsbn = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Mã ISBN phải là một số nguyên hợp lệ.");
            System.exit(1);
        }

        // Khởi tạo các biến cho thuật toán Tìm kiếm Nhị phân
        int left = 0;
        int right = isbnList.length - 1;
        int mid = 0;
        int steps = 0;
        int foundIndex = -1;

        // Thuật toán Binary Search (Vòng lặp)
        while (left <= right) {
            steps++;
            mid = left + (right - left) / 2;

            if (isbnList[mid] == targetIsbn) {
                foundIndex = mid;
                break;
            }

            if (isbnList[mid] < targetIsbn) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // Hiển thị kết quả
        System.out.println();
        System.out.println("+-------------------------------------------------------+");
        System.out.println("|             KẾT QUẢ TRA CỨU NHỊ PHẦN ISBN             |");
        System.out.println("+-------------------------------------------------------+");

        System.out.printf("| %-20s %-32d |\n", "Mã ISBN tra cứu:", targetIsbn);

        if (foundIndex != -1) {
            System.out.printf("| %-20s %-32s |\n", "Trạng thái:", "TÌM THẤY TRÊN KỆ SÁCH");
            String position = "Kệ số #" + foundIndex + " (Index " + foundIndex + ")";
            System.out.printf("| %-20s %-32s |\n", "Vị trí lưu trữ:", position);
        } else {
            System.out.printf("| %-20s %-32s |\n", "Trạng thái:", "KHÔNG TÌM THẤY");
            System.out.printf("| %-20s %-32s |\n", "Vị trí lưu trữ:", "Không tồn tại trong danh mục");
        }

        String performance = "Hoàn thành sau " + steps + " bước chia đôi";
        System.out.printf("| %-20s %-32s |\n", "Hiệu năng tìm kiếm:", performance);
        System.out.println("+-------------------------------------------------------+");

        scanner.close();
    }
}