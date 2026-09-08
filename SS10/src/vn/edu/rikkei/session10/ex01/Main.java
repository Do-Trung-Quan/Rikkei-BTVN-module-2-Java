package vn.edu.rikkei.session10.ex01;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- KHỞI TẠO FULL TIME EMPLOYEE ---");
        System.out.println("EMP-01: \"Nguyễn Văn An\", lương cơ bản 10,000,000, phụ cấp 2,500,000\n");

        FullTimeEmployee fte = new FullTimeEmployee("EMP-01", "Nguyễn Văn An", 10000000, 2500000);
        fte.displayInfo();
    }
}