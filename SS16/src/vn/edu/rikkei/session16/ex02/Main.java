package vn.edu.rikkei.session16.ex02;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- CHUYỂN ĐỔI CHUỖI VỚI FUNCTION ---");
        System.out.println("Danh sách gốc: [\"Java\", \"Spring\", \"Docker\", \"AWS\"]");
        System.out.println("Biến đổi 1: Lấy độ dài chuỗi (s -> s.length())");
        System.out.println("Biến đổi 2: Chuyển chữ hoa (s -> s.toUpperCase())\n");

        List<String> words = Arrays.asList("Java", "Spring", "Docker", "AWS");

        System.out.println("+-------------------------------------------------------+");
        System.out.println("|             BỘ BIẾN ĐỔI CHUỖI FUNCTION<T, R>          |");
        System.out.println("+-------------------------------------------------------+");

        // Biến đổi 1: Lấy độ dài chuỗi
        List<Integer> lengths = StringTransformer.transform(words, s -> s.length());

        System.out.printf("| %-53s |\n", "[Biến đổi 1 - Độ dài chuỗi]:");
        System.out.printf("| %-53s |\n", "-> " + lengths.toString());

        System.out.println("|-------------------------------------------------------|");

        // Biến đổi 2: Chuẩn hóa chữ hoa
        List<String> upperCases = StringTransformer.transform(words, s -> s.toUpperCase());

        // Format lại kết quả để chuỗi có chứa dấu ngoặc kép giống hệt output mẫu
        String formattedUpperCases = "[" + upperCases.stream()
                .map(s -> "\"" + s + "\"")
                .collect(Collectors.joining(", ")) + "]";

        System.out.printf("| %-53s |\n", "[Biến đổi 2 - Chuẩn hóa chữ hoa]:");
        System.out.printf("| %-53s |\n", "-> " + formattedUpperCases);

        System.out.println("+-------------------------------------------------------+");
    }
}