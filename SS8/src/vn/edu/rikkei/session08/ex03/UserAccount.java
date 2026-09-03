package vn.edu.rikkei.session08.ex03;

public class UserAccount {
    private String username;
    private String password;

    public UserAccount(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean changePassword(String oldPass, String newPass) {
        if(this.password.equals(oldPass)) {
            this.password = newPass;
            System.out.print("CẬP NHẬT THÀNH CÔNG! Mật khẩu đã được thay đổi");
            return true;
        }else {
            System.out.print("Cập nhật thất bại: Mật khẩu cũ không chính xác");
            return false;
        }
    }

    public void displayProfile() {
        System.out.printf("| Tài khoản: %s | Mật khẩu: %s          |\n", this.username, "*".repeat(this.password.length()));
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
