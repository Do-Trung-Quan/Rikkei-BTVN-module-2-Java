package vn.edu.rikkei.session15.ex03;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Order {
    private int orderId;
    private List<Product> products;

    public Order(int orderId) {
        this.orderId = orderId;
        this.products = new ArrayList<>(); // Khởi tạo ArrayList lưu trữ sản phẩm
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public double calculateTotal() {
        double total = 0;
        for (Product p : products) {
            total += p.getPrice();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order{orderId=").append(orderId).append(", totalProducts=").append(products.size()).append("}\n");
        sb.append("--- Danh sách sản phẩm trong đơn ---\n");
        if (products.isEmpty()) {
            sb.append("  (Đơn hàng chưa có sản phẩm nào)\n");
        } else {
            for (Product p : products) {
                sb.append("  - ").append(p.toString()).append("\n");
            }
        }
        sb.append(String.format(Locale.US, "=> Tổng tiền: %,.2f", calculateTotal()));
        return sb.toString();
    }
}