package vn.edu.rikkei.session09.ex01;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- KIỂM DUYỆT ĐÓNG GÓI INVENTORY ITEM ---");
        System.out.println("Mặt hàng ban đầu: \"INV-01\", \"Chuột không dây\", Giá: 250000, SL: 20");
        System.out.println("Lần 1: Cập nhật số lượng = 35 (Hợp lệ)");
        System.out.println("Lần 2: Cập nhật số lượng = -5 (Không hợp lệ)");
        System.out.println();

        System.out.println("+-------------------------------------------------------+");
        System.out.println("|             NHẬT KÝ KIỂM DUYỆT KHO HÀNG               |");
        System.out.println("+-------------------------------------------------------+");

        InventoryItem item = new InventoryItem("INV-01", "Chuột không dây", 250000.0, 20);
        item.displayItem();

        System.out.println("|-------------------------------------------------------|");

        item.setQuantity(35);
        System.out.printf("| [Lần 1] Cập nhật SL = 35 => Thành công (Tồn kho: %d)  |\n", item.getQuantity());

        System.out.print("| [Lần 2] ");
        item.setQuantity(-5);
        System.out.printf("| -> Số lượng tồn kho được giữ nguyên: %d sản phẩm      |\n", item.getQuantity());

        System.out.println("+-------------------------------------------------------+");
    }
}