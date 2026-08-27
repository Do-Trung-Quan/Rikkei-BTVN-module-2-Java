package vn.edu.rikkei.session07.ex02;

public class BankAccount {
    String accountNumber;
    String accountHolder;
    double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if(amount > 0) {
            this.balance += amount;
            System.out.printf("""
                    
                    | [Nạp tiền] +%,.2f VNĐ => Thành công            |
                    | -> Số dư mới: %,.2f VNĐ                        |
                    """, amount, this.balance);
        }else{
            System.out.printf("\n| [Nạp tiền] %,.2f VNĐ => LỖI: SỐ TIỀN NẠP KHÔNG HỢP LỆ\n", amount);
        }
    }

    public void withdraw(double amount) {
        if(amount > 0 && amount <= this.balance) {
            this.balance -= amount;
            System.out.printf("""
                    
                    | [Rút tiền] -%,.2f VNĐ => Thành công            |
                    | -> Số dư hiện tại: %,.2f VNĐ                   |
                    """, amount, this.balance);
        }else if(amount > this.balance) {
            System.out.printf("\n| [Rút tiền] -%,.2f VNĐ => LỖI: SỐ DƯ KHÔNG ĐỦ  |\n", amount);
        }else{
            System.out.printf("\n| [Rút tiền] -%,.2f VNĐ => LỖI: SỐ TIỀN RÚT KHÔNG HỢP LỆ  |\n", amount);
        }
    }
}
