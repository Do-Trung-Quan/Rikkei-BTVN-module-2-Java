package vn.edu.rikkei.session07.ex06;

public class Main {
    public static void main(String[] args) {
        Point2D A = new Point2D('A', 1.5, 2.0);
        Point2D B = new Point2D('B', 4.5, 6.0);
        System.out.print("""
                +-------------------------------------------------------+
                |         BÁO CÁO KHOẢNG CÁCH EUCLID TỌA ĐỘ GIS         |
                +-------------------------------------------------------+
                """);
        A.displayPoint();
        B.displayPoint();
        System.out.printf("""
                |-------------------------------------------------------|
                | KHOẢNG CÁCH ĐƯỜNG CHIM BAY (%c -> %c): %.2f đơn vị      |
                +-------------------------------------------------------+
                """, A.name, B.name, A.distanceTo(B));
    }
}
