package vn.edu.rikkei.session09.ex06;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- GIAO DỊCH THẺ TÍN DỤNG RIKKEI BANK ---");
        System.out.println("Thẻ: CREDIT-1001, Chủ thẻ: \"Nguyễn Văn An\"");
        System.out.println("Giao dịch 1: Chi tiêu 30,000,000 VNĐ (Hợp lệ)");
        System.out.println("Giao dịch 2: Chi tiêu 25,000,000 VNĐ (Vượt hạn mức 50tr)");
        System.out.println();

        System.out.println("+-------------------------------------------------------+");
        System.out.println("|             SAO KÊ THẺ TÍN DỤNG RIKKEI BANK           |");
        System.out.println("+-------------------------------------------------------+");

        CreditAccount account = new CreditAccount("Nguyễn Văn An");
        account.displayAccount();

        account.spend(30000000);
        account.spend(25000000);

        System.out.println("+-------------------------------------------------------+");
    }
}