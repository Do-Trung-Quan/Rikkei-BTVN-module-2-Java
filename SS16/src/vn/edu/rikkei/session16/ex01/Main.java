package vn.edu.rikkei.session16.ex01;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(15, 22, 8, 91, 44, 3, 60);

        System.out.println("--- LỌC SỐ VỚI FUNCTIONAL INTERFACE PREDICATE ---");
        System.out.println("Danh sách gốc: [15, 22, 8, 91, 44, 3, 60]");
        System.out.println("Lọc 1: Số chẵn (n -> n % 2 == 0)");
        System.out.println("Lọc 2: Số lớn hơn 30 (n -> n > 30)");
        System.out.println();

        System.out.println("+-------------------------------------------------------+");
        System.out.println("|             BỘ LỌC SỐ LIỆU LAMBDA PREDICATE           |");
        System.out.println("+-------------------------------------------------------+");

        System.out.printf("| %-53s |\n", "[Điều kiện: Số chẵn]");
        // Gọi hàm với điều kiện là số chẵn
        NumberFilter.filterNumbers(numbers, n -> n % 2 == 0);

        System.out.println("|-------------------------------------------------------|");

        System.out.printf("| %-53s |\n", "[Điều kiện: Số lớn hơn 30]");
        // Gọi hàm với điều kiện là số lớn hơn 30
        NumberFilter.filterNumbers(numbers, n -> n > 30);

        System.out.println("+-------------------------------------------------------+");
    }
}