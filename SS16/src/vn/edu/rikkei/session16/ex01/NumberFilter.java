package vn.edu.rikkei.session16.ex01;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class NumberFilter {

    public static void filterNumbers(List<Integer> list, Predicate<Integer> predicate) {
        List<String> results = new ArrayList<>();

        // Duyệt qua từng số và kiểm tra bằng biểu thức Lambda (predicate.test)
        for (Integer num : list) {
            if (predicate.test(num)) {
                results.add(String.valueOf(num));
            }
        }

        // Định dạng chuỗi kết quả để khớp với khung hiển thị
        String output = "-> Kết quả lọc: " + String.join(", ", results);
        System.out.printf("| %-53s |\n", output);
    }
}