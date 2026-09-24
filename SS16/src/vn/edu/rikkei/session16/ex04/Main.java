package vn.edu.rikkei.session16.ex04;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- LỌC HỌC VIÊN XUẤT SẮC STREAM API ---");
        System.out.println("SV1: \"SV01\", \"An\", GPA 3.8 ");
        System.out.println("SV2: \"SV02\", \"Bình\", GPA 2.5");
        System.out.println("SV3: \"SV03\", \"Cường\", GPA 3.5  ");
        System.out.println("SV4: \"SV04\", \"Dung\", GPA 3.2");
        System.out.println("SV5: \"SV05\", \"Hoa\", GPA 2.9   ");
        System.out.println("SV6: \"SV06\", \"Hùng\", GPA 3.9");
        System.out.println();

        // Khởi tạo danh sách 6 sinh viên
        List<Student> students = Arrays.asList(
                new Student("SV01", "An", 3.8),
                new Student("SV02", "Bình", 2.5),
                new Student("SV03", "Cường", 3.5),
                new Student("SV04", "Dung", 3.2),
                new Student("SV05", "Hoa", 2.9),
                new Student("SV06", "Hùng", 3.9)
        );

        // Gọi hàm lọc qua Stream API
        List<Student> honorStudents = StudentStreamService.getHonorStudents(students);

        // In bảng danh sách khen thưởng
        System.out.println("+-------------------------------------------------------+");
        System.out.println("|             DANH SÁCH KHEN THƯỞNG (GPA >= 3.2)        |");
        System.out.println("+-------------------------------------------------------+");

        int rank = 1;
        for (Student s : honorStudents) {
            String gpaFormatted = String.format(Locale.US, "%.2f", s.getGpa());
            // Căn chỉnh khoảng trắng để giao diện giống hệt Output mẫu
            String row = String.format("Hạng %d | %-4s | %-15s | GPA: %-13s", rank++, s.getId(), s.getName(), gpaFormatted);
            System.out.printf("| %-53s |\n", row);
        }

        System.out.println("+-------------------------------------------------------+");
    }
}