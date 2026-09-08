package vn.edu.rikkei.session08.ex04;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        double usdAmount = 100.0;

        System.out.println("--- CHUYỂN ĐỔI NGOẠI TỆ RIKKEI FINANCE ---");
        System.out.println("Số tiền: 100 USD");
        System.out.println("Tỷ giá 1: 25,450 VNĐ/USD");
        System.out.println("Tỷ giá 2: 25,600 VNĐ/USD");
        System.out.println();

        System.out.println("+-------------------------------------------------------+");
        System.out.println("|          BẢNG TÍNH CHUYỂN ĐỔI NGOẠI TỆ USD/VND        |");
        System.out.println("+-------------------------------------------------------+");

        String currentRateStr = String.format(Locale.US, "[Tỷ giá hiện tại] 1 USD = %,.2f VNĐ", CurrencyConverter.exchangeRate);
        String currentCalcStr = String.format(Locale.US, "-> %,.2f USD = %,.2f VNĐ", usdAmount, CurrencyConverter.toVND(usdAmount));

        System.out.printf("| %-53s |\n", currentRateStr);
        System.out.printf("| %-53s |\n", currentCalcStr);
        System.out.println("|-------------------------------------------------------|");

        CurrencyConverter.setExchangeRate(25600.0);

        String updatedRateStr = String.format(Locale.US, "[Cập nhật tỷ giá] 1 USD = %,.2f VNĐ", CurrencyConverter.exchangeRate);
        String updatedCalcStr = String.format(Locale.US, "-> %,.2f USD = %,.2f VNĐ", usdAmount, CurrencyConverter.toVND(usdAmount));

        System.out.printf("| %-53s |\n", updatedRateStr);
        System.out.printf("| %-53s |\n", updatedCalcStr);
        System.out.println("+-------------------------------------------------------+");
    }
}