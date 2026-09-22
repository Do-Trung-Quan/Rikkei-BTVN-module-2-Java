package vn.edu.rikkei.session15.ex03;

import java.util.Locale;

public class Product {
    private int id;
    private String name;
    private double price;

    public Product() {
    }

    public Product(int id, String name, double price) throws InvalidPriceException {
        this.id = id;
        this.name = name;
        this.setPrice(price); // Tận dụng setter để kiểm tra logic giá
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws InvalidPriceException {
        if (price <= 0) {
            throw new InvalidPriceException("Lỗi: Giá sản phẩm phải lớn hơn 0!");
        }
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "Product{id=%d, name='%s', price=%,.2f}", id, name, price);
    }
}