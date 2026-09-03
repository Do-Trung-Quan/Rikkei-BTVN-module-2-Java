package vn.edu.rikkei.session08.ex02;

public class Main {
    public static void main(String[] args) {
        System.out.println("""
                --- ĐỌC CẤU HÌNH HỆ THỐNG TỪ CLASS STATIC FINAL ---
                Không cần khởi tạo đối tượng SystemConfig
                """);

        /*
        * Câu lệnh gán lại giá trị cho 1 hằng số sẽ báo lỗi vì biến có được khai báo final sẽ không thể bị ghi đè
        * SystemConfig.MAX_REQUESTS = 2000;
        *
        * ----
        * java: cannot assign a value to static final variable MAX_REQUESTS
        * */

        System.out.printf("""
                +-------------------------------------------------------+
                |             CẤU HÌNH HỆ THỐNG RIKKEI STORE            |
                +-------------------------------------------------------+
                | Tên hệ thống:       %s        |
                | Phiên bản lõi:      %s                            |
                | Giới hạn Request:   %,d req/connection              |
                +-------------------------------------------------------+
                """, SystemConfig.SYSTEM_NAME, SystemConfig.APP_VERSION, SystemConfig.MAX_REQUESTS);
    }
}
