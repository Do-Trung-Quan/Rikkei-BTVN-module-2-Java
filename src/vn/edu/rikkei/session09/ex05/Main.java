package vn.edu.rikkei.session09.ex05;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- THỬ NGHIỆM TẠO LIÊN HỆ DANH BẠ ---");
        System.out.println("Liên hệ 1: \"CT-01\", \"Nguyễn Văn An\", SĐT: \"0987654321\" (Hợp lệ - 10 số)");
        System.out.println("Liên hệ 2: \"CT-02\", \"Trần Thị Hoa\", SĐT: \"987654321\" (Sai - 9 số không có 0)");

        Contact contact1 = new Contact("CT-01", "Nguyễn Văn An", "0987654321");
        Contact contact2 = new Contact("CT-02", "Trần Thị Hoa", "987654321");

        System.out.println("+-------------------------------------------------------+");
        System.out.println("|             DANH BẠ ĐIỆN THOẠI KHÁCH HÀNG             |");
        System.out.println("+-------------------------------------------------------+");

        contact1.displayContact();
        contact2.displayContact();

        System.out.println("+-------------------------------------------------------+");
    }
}