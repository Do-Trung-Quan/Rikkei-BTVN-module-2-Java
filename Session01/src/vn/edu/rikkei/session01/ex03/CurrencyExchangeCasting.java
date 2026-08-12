package vn.edu.rikkei.session01.ex03;

import java.util.Scanner;

public class CurrencyExchangeCasting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Nhập dữ liệu
        System.out.println("--- MODULE QUY ĐỔI NGOẠI TỆ & KIỂM TOÁN HỐI ĐOÁI ---");
        System.out.print("Nhập tỷ giá USD -> VNĐ : ");
        double usdRate = Double.parseDouble(sc.nextLine());

        System.out.print("Nhập tỷ giá EUR -> VNĐ : ");
        double eurRate = Double.parseDouble(sc.nextLine());

        System.out.print("Nhập số lượng USD     : ");
        double usdAmount = Double.parseDouble(sc.nextLine());

        System.out.print("Nhập số lượng EUR     : ");
        double eurAmount = Double.parseDouble(sc.nextLine());

        // 2. Xử lý tính toán
        double usdToVndDouble = usdAmount * usdRate;
        double eurToVndDouble = eurAmount * eurRate;

        // FIX: Làm tròn từng khoản tiền nhỏ trước khi tính tổng
        usdToVndDouble = Math.round(usdToVndDouble * 100.0) / 100.0; // -> Ra .13
        eurToVndDouble = Math.round(eurToVndDouble * 100.0) / 100.0; // -> Ra .10

        double totalVndDouble = usdToVndDouble + eurToVndDouble;

        /*
         * Ép kiểu tường minh (Narrowing Casting) từ double sang long.
         * Giải thích: Kiểu double chứa phần thập phân, nhưng kiểu long chỉ lưu trữ số nguyên.
         * Khi ép kiểu từ double sang long, hệ thống sẽ tự động cắt bỏ phần thập phân (Truncation)
         * để khớp với không gian bộ nhớ của kiểu số nguyên.
         */
        long officialVndAmount = (long) totalVndDouble;

        // Tính tiền dư lẻ bị cắt bỏ (Truncation Loss)
        double truncationLoss = totalVndDouble - (double) officialVndAmount;

        // Ép kiểu ngầm định (Widening Casting)
        double auditReportValue = officialVndAmount;

        // Tính toán chia tờ tiền 500,000 VNĐ bằng toán tử / và %
        long note500kCount = officialVndAmount / 500000;
        long remainder = officialVndAmount % 500000;

        // 3. Xuất kết quả hiển thị
        System.out.println();
        System.out.println("+-------------------------------------------------------------------+");
        System.out.println("|               BÁO CÁO CHUYỂN ĐỔI NGOẠI TỆ HỐI ĐOÁI                |");
        System.out.println("+-------------------------------------------------------------------+");
        System.out.printf("| 1. Giá trị USD chuyển đổi (double)  : %,23.2f VNĐ |\n", usdToVndDouble);
        System.out.printf("| 2. Giá trị EUR chuyển đổi (double)  : %,23.2f VNĐ |\n", eurToVndDouble);
        System.out.printf("| 3. Tổng giá trị chính xác (double)  : %,23.2f VNĐ |\n", totalVndDouble);
        System.out.println("+-------------------------------------------------------------------+");
        System.out.println("| QUY TRÌNH ÉP KIỂU DỮ LIỆU (TYPE CASTING ANALYSIS)                 |");
        System.out.printf("| - Chốt sổ kế toán (Narrowing -> long) : %,18d VNĐ    |\n", officialVndAmount);
        System.out.printf("| - Phần dư thập phân bị cắt (Loss)    : %,20.2f VNĐ   |\n", truncationLoss);
        System.out.printf("| - Giá trị kiểm toán (Widening -> dbl) : %,18.2f VNĐ |\n", auditReportValue);
        System.out.println("+-------------------------------------------------------------------+");
        System.out.println("| PHÂN TÍCH CHI TRẢ TIỀN MẶT (MỆNH GIÁ 500,000 VNĐ)                 |");
        System.out.printf("| - Số tờ tiền 500,000 VNĐ tối đa       : %,17d tờ      |\n", note500kCount);
        System.out.printf("| - Số tiền lẻ còn lại (Toán tử %%)     : %,19d VNĐ    |\n", remainder);
        System.out.println("+-------------------------------------------------------------------+");

        sc.close();
    }
}