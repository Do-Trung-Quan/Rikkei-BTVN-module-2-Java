package vn.edu.rikkei.session15.ex02;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        SubjectManager<Subject> manager = new SubjectManager<>();

        while (true) {
            System.out.println("\n--- HỆ THỐNG QUẢN LÝ MÔN HỌC ---");
            System.out.println("1. Hiển thị danh sách môn học");
            System.out.println("2. Thêm môn học");
            System.out.println("3. Xóa môn học");
            System.out.println("4. Tìm kiếm môn học theo tên");
            System.out.println("5. Lọc môn học theo tín chỉ (> 3)");
            System.out.println("6. Thoát");
            System.out.print("Chọn chức năng: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    manager.displaySubjects();
                    break;
                case "2":
                    addSubject(manager);
                    break;
                case "3":
                    removeSubject(manager);
                    break;
                case "4":
                    searchSubject(manager);
                    break;
                case "5":
                    filterSubjects(manager);
                    break;
                case "6":
                    System.out.println("Thoát chương trình.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private static void addSubject(SubjectManager<Subject> manager) {
        System.out.print("Nhập mã môn học: ");
        String code = scanner.nextLine().trim();

        System.out.print("Nhập tên môn học: ");
        String name = scanner.nextLine().trim();

        int credits = 0;
        while (true) {
            try {
                System.out.print("Nhập số tín chỉ: ");
                credits = Integer.parseInt(scanner.nextLine().trim());

                // Ném ngoại lệ nếu dữ liệu không thỏa mãn yêu cầu
                if (credits < 0 || credits > 10) {
                    throw new IllegalArgumentException("Số tín chỉ không hợp lệ (phải từ 0 đến 10).");
                }
                break; // Thoát vòng lặp nếu nhập đúng

            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập một số nguyên!");
            } catch (IllegalArgumentException e) {
                System.out.println("Lỗi: " + e.getMessage() + " Yêu cầu nhập lại.");
            }
        }

        System.out.print("Nhập ngày bắt đầu (VD: dd/MM/yyyy): ");
        String startDate = scanner.nextLine().trim();

        Subject newSubject = new Subject(code, name, credits, startDate);
        manager.addSubject(newSubject);
        System.out.println("Thêm môn học thành công.");
    }

    private static void removeSubject(SubjectManager<Subject> manager) {
        System.out.print("Nhập mã môn học cần xóa: ");
        String code = scanner.nextLine().trim();

        boolean isRemoved = manager.removeSubject(code);
        if (isRemoved) {
            System.out.println("Xóa môn học thành công.");
        } else {
            System.out.println("Lỗi: Không tìm thấy môn học có mã '" + code + "'.");
        }
    }

    private static void searchSubject(SubjectManager<Subject> manager) {
        System.out.print("Nhập tên môn học cần tìm kiếm: ");
        String keyword = scanner.nextLine().trim();

        List<Subject> foundSubjects = manager.searchByName(keyword);

        if (foundSubjects.isEmpty()) {
            System.out.println("Không có môn học phù hợp");
        } else {
            System.out.println("Kết quả tìm kiếm:");
            for (Subject subject : foundSubjects) {
                System.out.println(subject);
            }
        }
    }

    private static void filterSubjects(SubjectManager<Subject> manager) {
        List<Subject> filteredSubjects = manager.filterByCredits();

        if (filteredSubjects.isEmpty()) {
            System.out.println("Không có môn học nào có số tín chỉ > 3.");
        } else {
            System.out.println("Danh sách các môn học có số tín chỉ > 3:");
            for (Subject subject : filteredSubjects) {
                System.out.println(subject);
            }
        }
    }
}