package vn.edu.rikkei.session07.ex01;

public class Product {
        String productId;
        String productName;
        double price;
        int quantity;

        public Product(){
            this.productId = "PRD-000";
            this.productName = "Chưa đặt tên";
            this.price = 0.0;
            this.quantity = 0;
        }
        public Product(String productId, String productName, double price, int quantity) {
            this.productId = productId;
            this.productName = productName;
            this.price = price;
            this.quantity = quantity;
        }

        public double getTotalStockValue(){
            return this.price * this.quantity;
        }

        public void displayProductInfo(int index){
            System.out.printf("""
                    | [SP%d] %s | %s   | SL: %d           |
                    | -> Giá bán: %,.2f VNĐ                          |
                    | -> TỔNG GIÁ TRỊ KHO:  %,.2f VNĐ               |
                    +-------------------------------------------------------+
                    """, index, this.productId, this.productName, this.quantity, (float)this.price, (float)getTotalStockValue());
        }
}
