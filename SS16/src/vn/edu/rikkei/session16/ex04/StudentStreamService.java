package vn.edu.rikkei.session16.ex04;

import java.util.List;
import java.util.stream.Collectors;

public class StudentStreamService {

    public static List<Student> getHonorStudents(List<Student> students) {
        return students.stream()
                .filter(s -> s.getGpa() >= 3.2) // Lọc sinh viên có GPA >= 3.2
                .sorted((s1, s2) -> Double.compare(s2.getGpa(), s1.getGpa())) // Sắp xếp GPA giảm dần
                .collect(Collectors.toList()); // Thu thập kết quả trả về List mới
    }
}