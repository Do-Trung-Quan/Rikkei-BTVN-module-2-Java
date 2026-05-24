package ex01;

import java.util.ArrayList;
import java.util.Scanner;

interface ICapability {
    void checkPerformance();
}

abstract class Staff implements ICapability {
    protected int id;
    protected String name;
    protected double baseSalary;

    public Staff(int id, String name, double baseSalary) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public abstract double calculateTotalSalary();

    public int getId() { return id; }

    public void setName(String name) { this.name = name; }
    public String getName() { return name; }

    public void setBaseSalary(double baseSalary) { this.baseSalary = baseSalary; }
    public double getBaseSalary() { return baseSalary; }

    public void showInfo() {
        System.out.printf("ID: %d | Tên: %s | Lương cứng: %,.0f VNĐ\n", id, name, baseSalary);
    }
}

class Lecturer extends Staff {
    private int teachingHours;

    public Lecturer(int id, String name, double baseSalary, int teachingHours) {
        super(id, name, baseSalary);
        this.teachingHours = teachingHours;
    }

    public int getTeachingHours() { return teachingHours; }
    public void setTeachingHours(int teachingHours) { this.teachingHours = teachingHours; }

    @Override
    public double calculateTotalSalary() {
        return baseSalary + (teachingHours * 200000.0);
    }

    @Override
    public void checkPerformance() {
        System.out.println("Đánh giá Giảng viên dựa trên số giờ dạy và phản hồi học viên.");
    }

    @Override
    public void showInfo() {
        System.out.print("[Giảng viên] ");
        super.showInfo();
        System.out.printf("   -> Giờ dạy: %d | Tổng lương thực nhận: %,.0f VNĐ\n", teachingHours, calculateTotalSalary());
    }
}

class AdminStaff extends Staff {
    private double bonus;

    public AdminStaff(int id, String name, double baseSalary, double bonus) {
        super(id, name, baseSalary);
        this.bonus = bonus;
    }

    public double getBonus() { return bonus; }
    public void setBonus(double bonus) { this.bonus = bonus; }

    @Override
    public double calculateTotalSalary() {
        return baseSalary + bonus;
    }

    @Override
    public void checkPerformance() {
        System.out.println("Đánh giá Nhân viên hành chính dựa trên mức độ hoàn thành task và KPIs.");
    }

    @Override
    public void showInfo() {
        System.out.print("[Nhân viên HC] ");
        super.showInfo();
        System.out.printf("   -> Thưởng thêm: %,.0f VNĐ | Tổng lương thực nhận: %,.0f VNĐ\n", bonus, calculateTotalSalary());
    }
}

public class ex01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Staff> staffList = new ArrayList<>();
        int choice = -1;

        while (true) {
            System.out.println("\n===== HỆ THỐNG QUẢN LÝ TRUNG TÂM GIÁO DỤC =====");
            System.out.println("1. Thêm mới nhân sự");
            System.out.println("2. Hiển thị danh sách và lương");
            System.out.println("3. Cập nhật thông tin theo ID");
            System.out.println("4. Xóa nhân sự theo ID");
            System.out.println("0. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập số hợp lệ!");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("--- THÊM NHÂN SỰ ---");
                    System.out.println("1. Thêm Giảng viên | 2. Thêm Nhân viên HC");
                    System.out.print("Chọn loại: ");
                    String type = scanner.nextLine();

                    try {
                        System.out.print("Nhập ID: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        System.out.print("Nhập Tên: ");
                        String name = scanner.nextLine();
                        System.out.print("Nhập Lương cứng: ");
                        double baseSalary = Double.parseDouble(scanner.nextLine());

                        if (type.equals("1")) {
                            System.out.print("Nhập số giờ dạy: ");
                            int hours = Integer.parseInt(scanner.nextLine());
                            staffList.add(new Lecturer(id, name, baseSalary, hours));
                            System.out.println("Đã thêm Giảng viên thành công!");
                        } else if (type.equals("2")) {
                            System.out.print("Nhập tiền thưởng: ");
                            double bonus = Double.parseDouble(scanner.nextLine());
                            staffList.add(new AdminStaff(id, name, baseSalary, bonus));
                            System.out.println("Đã thêm Nhân viên HC thành công!");
                        } else {
                            System.out.println("Loại nhân sự không hợp lệ!");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Lỗi định dạng: Dữ liệu số không hợp lệ. Hủy thêm mới.");
                    }
                    break;

                case 2:
                    System.out.println("--- DANH SÁCH NHÂN SỰ ---");
                    if (staffList.isEmpty()) {
                        System.out.println("Hệ thống chưa có dữ liệu.");
                    } else {
                        for (Staff s : staffList) {
                            s.showInfo();
                            System.out.println("---------------------------------");
                        }
                    }
                    break;

                case 3:
                    System.out.println("--- CẬP NHẬT THÔNG TIN ---");
                    System.out.print("Nhập ID nhân sự cần sửa: ");
                    try {
                        int editId = Integer.parseInt(scanner.nextLine());
                        Staff targetStaff = null;
                        for (Staff s : staffList) {
                            if (s.getId() == editId) {
                                targetStaff = s;
                                break;
                            }
                        }

                        if (targetStaff != null) {
                            System.out.print("Nhập Tên mới: ");
                            targetStaff.setName(scanner.nextLine());
                            System.out.print("Nhập Lương cứng mới: ");
                            targetStaff.setBaseSalary(Double.parseDouble(scanner.nextLine()));

                            if (targetStaff instanceof Lecturer) {
                                System.out.print("Nhập số giờ dạy mới: ");
                                ((Lecturer) targetStaff).setTeachingHours(Integer.parseInt(scanner.nextLine()));
                            } else if (targetStaff instanceof AdminStaff) {
                                System.out.print("Nhập tiền thưởng mới: ");
                                ((AdminStaff) targetStaff).setBonus(Double.parseDouble(scanner.nextLine()));
                            }
                            System.out.println("Cập nhật thành công!");
                        } else {
                            System.out.println("Không tìm thấy nhân sự có ID: " + editId);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Lỗi: ID hoặc dữ liệu số không hợp lệ.");
                    }
                    break;

                case 4:
                    System.out.println("--- XÓA NHÂN SỰ ---");
                    System.out.print("Nhập ID nhân sự cần xóa: ");
                    try {
                        int delId = Integer.parseInt(scanner.nextLine());
                        boolean isRemoved = staffList.removeIf(s -> s.getId() == delId);
                        if (isRemoved) {
                            System.out.println("Đã xóa nhân sự có ID " + delId + " khỏi hệ thống.");
                        } else {
                            System.out.println("Không tìm thấy nhân sự có ID: " + delId);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Lỗi: ID không hợp lệ.");
                    }
                    break;

                case 0:
                    System.out.println("Thoát chương trình. Hẹn gặp lại!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn từ 0 đến 4.");
            }
        }
    }
}
