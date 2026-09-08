package vn.edu.rikkei.session09.ex04;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        double r = 5.0;
        double h = 10.0;

        System.out.println("--- TIỆN ÍCH TÍNH TOÁN HÌNH HỌC GEOMETRY UTILS ---");
        System.out.println("Bán kính r = 5.0, Chiều cao h = 10.0");
        System.out.println();

        System.out.println("+-------------------------------------------------------+");
        System.out.println("|           BÁO CÁO THỐNG KÊ HÌNH HỌC ĐƯỜNG TRÒN        |");
        System.out.println("+-------------------------------------------------------+");

        System.out.printf(Locale.US, "| %-27s %-25s |\n", "Bán kính (r):", String.format(Locale.US, "%.2f cm", r));
        System.out.printf(Locale.US, "| %-27s %-25s |\n", "Chiều cao trụ (h):", String.format(Locale.US, "%.2f cm", h));

        System.out.println("|-------------------------------------------------------|");

        System.out.printf(Locale.US, "| %-27s %-25s |\n", "CHU VI HÌNH TRÒN:", String.format(Locale.US, "%.2f cm", GeometryUtils.circlePerimeter(r)));
        System.out.printf(Locale.US, "| %-27s %-25s |\n", "DIỆN TÍCH HÌNH TRÒN:", String.format(Locale.US, "%.2f cm2", GeometryUtils.circleArea(r)));
        System.out.printf(Locale.US, "| %-27s %-25s |\n", "THỂ TÍCH HÌNH TRỤ:", String.format(Locale.US, "%.2f cm3", GeometryUtils.cylinderVolume(r, h)));

        System.out.println("+-------------------------------------------------------+");
    }
}