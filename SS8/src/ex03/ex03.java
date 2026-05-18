package ex03;

class CurrencyConverter {
    private static double rate;

    public static void setRate(double r) {
        if (r > 0) {
            rate = r;
        } else {
            System.out.println("Tỉ giá không hợp lệ! Vui lòng nhập giá trị lớn hơn 0.");
        }
    }

    public static double getRate() {
        return rate;
    }

    public static double toUSD(int vnd) {
        if (rate <= 0) {
            System.out.println("Lỗi: Chưa thiết lập tỉ giá!");
            return 0;
        }
        return (double) vnd / rate;
    }

    public static String formatUSD(double usd) {
        return String.format("%.2f", usd);
    }
}

public class ex03 {
    public static void main(String[] args) {
        // Thiết lập tỉ giá (ví dụ: 1 USD = 25000 VND)
        CurrencyConverter.setRate(25000.0);

        int vnd = 500000;
        double usd = CurrencyConverter.toUSD(vnd);

        System.out.println("Tỉ giá hiện tại: " + CurrencyConverter.getRate());
        System.out.println(vnd + " VND = $" + CurrencyConverter.formatUSD(usd));
    }
}
