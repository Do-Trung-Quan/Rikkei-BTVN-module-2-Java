package vn.edu.rikkei.session08.ex03;

public class Main {
    public static void main(String[] args) {
        System.out.println("""
                --- THỬ NGHIỆM ĐỔI MẬT KHẨU TÀI KHOẢN ---
                Tài khoản: "admin_rikkei", mật khẩu đầu: "Secret123"
                Lần 1: Đổi từ "WrongPass" -> "NewPass999" (Sai mật khẩu cũ)
                Lần 2: Đổi từ "Secret123" -> "NewPass999" (Thành công)
                """);

        UserAccount userAccount = new UserAccount("admin_rikkei", "Secret123");

        System.out.print("""
                +-------------------------------------------------------+
                |             NHẬT KÝ BẢO MẬT TÀI KHOẢN                 |
                +-------------------------------------------------------+
                """);
        userAccount.displayProfile();
        System.out.println("|-------------------------------------------------------|");
        System.out.print("| [Lần 1]");
        userAccount.changePassword("WrongPass", "NewPass999");
        System.out.println("|");

        System.out.print("| [Lần 2]");
        userAccount.changePassword("Secret123", "NewPass999");
        System.out.println("|");
        System.out.println("+-------------------------------------------------------+");
    }
}
