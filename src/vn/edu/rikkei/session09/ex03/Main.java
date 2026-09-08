package vn.edu.rikkei.session09.ex03;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- THỬ NGHIỆM MƯỢN TRẢ SÁCH THƯ VIỆN ---");
        System.out.println("Sách 1: \"BK-01\", \"Lập trình Java Core\"");
        System.out.println("Sách 2: \"BK-02\", \"Cấu trúc dữ liệu\"");
        System.out.println("Mượn Sách 1, Mượn Sách 2, Trả Sách 1");
        System.out.println();

        System.out.println("+-------------------------------------------------------+");
        System.out.println("|             QUẢN LÝ MƯỢN TRẢ SÁCH THƯ VIỆN            |");
        System.out.println("+-------------------------------------------------------+");

        LibraryBook book1 = new LibraryBook("BK-01", "Lập trình Java Core", "Tác giả A");
        LibraryBook book2 = new LibraryBook("BK-02", "Cấu trúc dữ liệu", "Tác giả B");

        if (book1.borrowBook()) {
            String msg = String.format("[Mượn %s] Thành công! -> Tổng sách đang mượn: %d", book1.getBookId(), LibraryBook.getTotalBorrowed());
            System.out.printf("| %-53s |\n", msg);
        }

        if (book2.borrowBook()) {
            String msg = String.format("[Mượn %s] Thành công! -> Tổng sách đang mượn: %d", book2.getBookId(), LibraryBook.getTotalBorrowed());
            System.out.printf("| %-53s |\n", msg);
        }

        if (book1.returnBook()) {
            String msg = String.format("[Trả  %s] Thành công! -> Tổng sách đang mượn: %d", book1.getBookId(), LibraryBook.getTotalBorrowed());
            System.out.printf("| %-53s |\n", msg);
        }

        System.out.println("|-------------------------------------------------------|");

        String stat = String.format("Thống kê: Còn lại %d sách đang được độc giả mượn", LibraryBook.getTotalBorrowed());
        System.out.printf("| %-53s |\n", stat);

        System.out.println("+-------------------------------------------------------+");
    }
}