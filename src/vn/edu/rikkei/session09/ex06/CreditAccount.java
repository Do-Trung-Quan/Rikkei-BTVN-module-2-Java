package vn.edu.rikkei.session09.ex06;

import java.util.Locale;

public class CreditAccount {
    public static final double CREDIT_LIMIT = 50000000.0;
    private static int autoId = 1001;

    private String accountId;
    private String holderName;
    private double currentDebt = 0;

    public CreditAccount(String holderName) {
        this.accountId = "CREDIT-" + autoId;
        autoId++;
        this.holderName = holderName;
    }

    public boolean spend(double amount) {
        System.out.println("|-------------------------------------------------------|");
        if (amount > 0 && (this.currentDebt + amount) <= CREDIT_LIMIT) {
            this.currentDebt += amount;
            String msg1 = String.format(Locale.US, "[Chi tiêu] %,.0f VNĐ => Thành công", amount);
            String msg2 = String.format(Locale.US, "-> Dư nợ hiện tại:     %,.0f VNĐ", this.currentDebt);
            System.out.printf("| %-53s |\n", msg1);
            System.out.printf("| %-53s |\n", msg2);
            return true;
        } else {
            String msg1 = String.format(Locale.US, "[Chi tiêu] %,.0f VNĐ => TỪ CHỐI! VƯỢT HẠN MỨC", amount);
            String msg2 = String.format(Locale.US, "-> Hạn mức khả dụng chỉ còn: %,.0f VNĐ", (CREDIT_LIMIT - this.currentDebt));
            System.out.printf("| %-53s |\n", msg1);
            System.out.printf("| %-53s |\n", msg2);
            return false;
        }
    }

    public void payDebt(double amount) {
        if (amount > 0) {
            this.currentDebt -= amount;
            if (this.currentDebt < 0) {
                this.currentDebt = 0;
            }
        }
    }

    public void displayAccount() {
        String line1 = String.format("Mã thẻ: %-15s | Chủ thẻ: %s", this.accountId, this.holderName);
        String line2 = String.format(Locale.US, "Hạn mức tín dụng:      %,.0f VNĐ", CREDIT_LIMIT);

        System.out.printf("| %-53s |\n", line1);
        System.out.printf("| %-53s |\n", line2);
    }
}