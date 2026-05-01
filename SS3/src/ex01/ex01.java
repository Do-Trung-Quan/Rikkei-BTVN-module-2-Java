package ex01;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Scanner;

public class ex01 {
    public class Order{
        private String customer, product;
        private float price,discount, vat;
        private int quantity;
        private boolean membership;


        public Order(String customer, String product, float price, int quantity, boolean membership){
            this.customer = customer;
            this.product = product;
            this.price = price;
            this.quantity = quantity;
            this.membership = membership;
            this.discount = 0;
            this.vat = quantity*price*0.08f;
        }

        public void detail(){
            DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.GERMANY);
            symbols.setGroupingSeparator('.');
            symbols.setDecimalSeparator(',');
            DecimalFormat df = new DecimalFormat("#,##0.00", symbols);

            float totalProductPrice = quantity * price;
            if (membership) {
                discount = totalProductPrice * 0.1f;
            }
            float finalAmount = totalProductPrice - discount + vat;

            System.out.printf("Khách hàng: %s\n", customer);
            System.out.printf("Sản phẩm: %s\n", product);
            System.out.printf("Giá: %s VNĐ\n", df.format(price));
            System.out.printf("Số lượng: %d\n", quantity);
            System.out.printf("Thành tiền: %s VNĐ\n", df.format(totalProductPrice));
            System.out.printf("Giảm giá: %s VNĐ\n", df.format(discount));
            System.out.printf("Tiền VAT: %s VNĐ\n", df.format(vat));
            System.out.printf("Tổng tiền thanh toán: %s VNĐ\n", df.format(finalAmount));
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ex01 outer = new ex01();
        Order order = outer.new Order(scanner.nextLine(), scanner.nextLine(), Float.parseFloat(scanner.nextLine()), Integer.parseInt(scanner.nextLine()), Boolean.parseBoolean(scanner.nextLine()));
        order.detail();
    }
}
