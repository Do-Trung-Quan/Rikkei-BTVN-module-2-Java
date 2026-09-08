package vn.edu.rikkei.session09.ex01;

public class InventoryItem {
    private String itemCode;
    private String itemName;
    private double price;
    private int quantity;

    public InventoryItem(String itemCode, String itemName, double price, int quantity) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
        this.setQuantity(quantity);
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity >= 0) {
            this.quantity = quantity;
        } else {
            System.out.println("LỖI: Số lượng tồn kho không được âm!          |");
        }
    }

    public void displayItem() {
        System.out.printf("| Mặt hàng: %-6s | %-32s |\n", this.itemCode, this.itemName);
    }
}