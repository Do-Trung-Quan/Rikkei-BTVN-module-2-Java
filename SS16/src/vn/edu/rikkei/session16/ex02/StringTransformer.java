package vn.edu.rikkei.session16.ex02;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class StringTransformer {

    // Phương thức generic sử dụng Function<String, R>
    public static <R> List<R> transform(List<String> list, Function<String, R> func) {
        List<R> result = new ArrayList<>();

        // Duyệt qua danh sách và áp dụng logic biến đổi
        for (String str : list) {
            result.add(func.apply(str));
        }

        return result;
    }
}