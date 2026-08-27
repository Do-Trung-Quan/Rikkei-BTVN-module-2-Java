package vn.edu.rikkei.session07.ex01;

public class Main {
    public static void main(String[] args) {
        Product product1 = new Product();
        Product product2 = new Product("PRD-001", "Bàn phím cơ Dell", 1250000, 15);
        System.out.printf("""
                +-------------------------------------------------------+
                |             THÔNG TIN CHI TIẾT SẢN PHẨM               |
                +-------------------------------------------------------+
                """);
        product1.displayProductInfo(1);
        product2.displayProductInfo(2);
    }
}
