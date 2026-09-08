package vn.edu.rikkei.session08.ex05;

import java.util.Locale;

public class Account {
    private static int autoId = 1001;
    private String accountNumber;
    private String customerName;
    private double balance;

    public Account(String customerName, double balance) {
        this.accountNumber = "ACC-" + autoId;
        autoId++;
        this.customerName = customerName;
        this.balance = balance;
    }

    public void displayAccount() {
        String line1 = String.format("Mã TK: %s | Chủ TK: %s", this.accountNumber, this.customerName);
        String line2 = String.format(Locale.US, "-> Số dư hiện tại: %,.0f VNĐ", this.balance);

        System.out.printf("| %-53s |\n", line1);
        System.out.printf("| %-53s |\n", line2);
    }
}