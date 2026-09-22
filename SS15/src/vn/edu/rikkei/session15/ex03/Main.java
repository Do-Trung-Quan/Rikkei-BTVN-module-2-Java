package vn.edu.rikkei.session15.ex03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    // Khởi tạo Collection quản lý theo yêu cầu
    private static final List<Product> productList = new ArrayList<>();
    private static final Map<String, Order> orderMap = new HashMap<>();

    public static void main(String[] args) {
        while (true) {
            // Menu hiển thị dựa trên giao diện chuẩn[cite: 11]
            System.out.println("\n================ MENU ================");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Xóa sản phẩm");
            System.out.println("3. Hiển thị sản phẩm");
            System.out.println("4. Tạo đơn hàng");
            System.out.println("5. Thêm sản phẩm vào đơn hàng");
            System.out.println("6. Hiển thị đơn hàng");
            System.out.println("0. Thoát");
            System.out.println("======================================");
            System.out.print("Lựa chọn của bạn: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    addProduct();
                    break;
                case "2":
                    deleteProduct();
                    break;
                case "3":
                    displayProducts();
                    break;
                case "4":
                    createOrder();
                    break;
                case "5":
                    addProductToOrder();
                    break;
                case "6":
                    displayOrder();
                    break;
                case "0":
                    System.out.println("Thoát chương trình.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại!");
            }
        }
    }

    // 1. Thêm sản phẩm
    private static void addProduct() {
        try {
            System.out.print("Nhập ID sản phẩm (số nguyên): ");
            int id = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Nhập tên sản phẩm: ");
            String name = scanner.nextLine().trim();

            System.out.print("Nhập giá sản phẩm: ");
            double price = Double.parseDouble(scanner.nextLine().trim());

            // Ném ngoại lệ Checked Exception nếu giá <= 0
            Product newProduct = new Product(id, name, price);
            productList.add(newProduct);
            System.out.println("=> Thêm sản phẩm thành công!");

        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Nhập sai định dạng số!");
        } catch (InvalidPriceException e) {
            System.out.println(e.getMessage());
        }
    }

    // 2. Xóa sản phẩm
    private static void deleteProduct() {
        try {
            System.out.print("Nhập ID sản phẩm cần xóa: ");
            int id = Integer.parseInt(scanner.nextLine().trim());

            boolean removed = productList.removeIf(p -> p.getId() == id);

            if (!removed) {
                throw new ProductNotFoundException("Lỗi: Sản phẩm không tồn tại!");
            }

            System.out.println("=> Đã xóa sản phẩm thành công!");

        } catch (NumberFormatException e) {
            System.out.println("Lỗi: ID phải là số nguyên!");
        } catch (ProductNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    // 3. Hiển thị sản phẩm
    private static void displayProducts() {
        if (productList.isEmpty()) {
            System.out.println("Danh sách sản phẩm trống.");
            return;
        }
        System.out.println("--- DANH SÁCH SẢN PHẨM ---");
        for (Product p : productList) {
            System.out.println(p);
        }
    }

    // 4. Tạo đơn hàng
    private static void createOrder() {
        try {
            System.out.print("Nhập mã đơn hàng mới (số nguyên): ");
            int orderId = Integer.parseInt(scanner.nextLine().trim());
            String orderKey = String.valueOf(orderId);

            if (orderMap.containsKey(orderKey)) {
                System.out.println("Lỗi: Mã đơn hàng đã tồn tại!");
                return;
            }

            orderMap.put(orderKey, new Order(orderId));
            System.out.println("=> Tạo đơn hàng thành công!");

        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Mã đơn hàng phải là số nguyên!");
        }
    }

    // 5. Thêm sản phẩm vào đơn hàng
    private static void addProductToOrder() {
        try {
            System.out.print("Nhập mã đơn hàng: ");
            String orderKey = scanner.nextLine().trim();

            if (!orderMap.containsKey(orderKey)) {
                throw new OrderNotFoundException("Lỗi: Đơn hàng không tồn tại!");
            }

            System.out.print("Nhập ID sản phẩm muốn thêm: ");
            int productId = Integer.parseInt(scanner.nextLine().trim());

            Product foundProduct = null;
            for (Product p : productList) {
                if (p.getId() == productId) {
                    foundProduct = p;
                    break;
                }
            }

            if (foundProduct == null) {
                throw new ProductNotFoundException("Lỗi: Sản phẩm không tồn tại trong hệ thống!");
            }

            // Thêm sản phẩm vào danh sách của đơn hàng
            Order order = orderMap.get(orderKey);
            order.addProduct(foundProduct);
            System.out.println("=> Thêm sản phẩm vào đơn hàng thành công!");

        } catch (NumberFormatException e) {
            System.out.println("Lỗi: ID sản phẩm phải là số nguyên!");
        } catch (OrderNotFoundException | ProductNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    // 6. Hiển thị đơn hàng
    private static void displayOrder() {
        try {
            System.out.print("Nhập mã đơn hàng cần xem: ");
            String orderKey = scanner.nextLine().trim();

            if (!orderMap.containsKey(orderKey)) {
                throw new OrderNotFoundException("Lỗi: Đơn hàng không tồn tại!");
            }

            Order order = orderMap.get(orderKey);
            System.out.println("\n" + order.toString());

        } catch (OrderNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}