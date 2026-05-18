package ex05;

import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private int id;
    private String name;
    private double gpa;

    private static int countStudent = 0;
    public final double SCORE_FACTOR = 0.25;

    public Student() {
        countStudent++;
    }

    public Student(int id, String name, double gpa) {
        this();
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập ID: ");
        this.id = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập tên: ");
        this.name = sc.nextLine();
        System.out.print("Nhập GPA: ");
        this.gpa = Double.parseDouble(sc.nextLine());
    }

    public void print() {
        System.out.println("ID: " + id + ", Tên: " + name + ", GPA: " + gpa);
    }

    public double getGpa() {
        return gpa;
    }

    public static int getTotalStudent() {
        return countStudent;
    }
}

public class ex05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("\n===== MENU SINH VIÊN =====");
            System.out.println("1. Nhập danh sách sinh viên");
            System.out.println("2. In danh sách sinh viên");
            System.out.println("3. Tìm sinh viên GPA cao nhất");
            System.out.println("4. In tổng số sinh viên đã tạo");
            System.out.println("0. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Nhập số lượng sinh viên cần thêm: ");
                    int n = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < n; i++) {
                        System.out.println("--- Nhập thông tin sinh viên thứ " + (i + 1) + " ---");
                        Student st = new Student();
                        st.input();
                        students.add(st);
                    }
                    break;

                case 2:
                    if (students.isEmpty()) {
                        System.out.println("Danh sách trống!");
                    } else {
                        System.out.println("--- Danh sách sinh viên ---");
                        for (Student st : students) {
                            st.print();
                        }
                    }
                    break;

                case 3:
                    if (students.isEmpty()) {
                        System.out.println("Danh sách trống!");
                    } else {
                        Student maxStudent = students.get(0);
                        for (Student st : students) {
                            if (st.getGpa() > maxStudent.getGpa()) {
                                maxStudent = st;
                            }
                        }
                        System.out.println("--- Sinh viên có GPA cao nhất ---");
                        maxStudent.print();
                    }
                    break;

                case 4:
                    System.out.println("Tổng số sinh viên đã tạo: " + Student.getTotalStudent());
                    break;

                case 0:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}
