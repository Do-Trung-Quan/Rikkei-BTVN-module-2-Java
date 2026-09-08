package vn.edu.rikkei.session09.ex02;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- THỬ NGHIỆM MỞ 4 KẾT NỐI SERVER ---");
        System.out.println("Mở Conn 1, Conn 2, Conn 3 (Hợp lệ)");
        System.out.println("Mở Conn 4 (Vượt giới hạn MAX_CONNECTIONS=3)");
        System.out.println();

        System.out.println("+-------------------------------------------------------+");
        System.out.println("|             GIÁM SÁT KẾT NỐI MÁY CHỦ RIKKEI           |");
        System.out.println("+-------------------------------------------------------+");

        ServerConnection conn1 = new ServerConnection("Conn 1");
        ServerConnection conn2 = new ServerConnection("Conn 2");
        ServerConnection conn3 = new ServerConnection("Conn 3");
        ServerConnection conn4 = new ServerConnection("Conn 4");

        System.out.println("+-------------------------------------------------------+");
    }
}