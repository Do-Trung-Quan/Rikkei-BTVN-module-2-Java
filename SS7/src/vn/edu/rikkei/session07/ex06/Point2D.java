package vn.edu.rikkei.session07.ex06;

public class Point2D {
    char name;
    double x, y;
    public Point2D(char name, double x, double y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public double distanceTo(Point2D other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }

    public void displayPoint(){
        System.out.printf("| Tọa độ Điểm nguồn %c:      (%.2f, %.2f)                |\n", this.name, this.x, this.y);
    }
}
