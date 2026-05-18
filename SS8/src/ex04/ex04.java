package ex04;

import java.util.ArrayList;
import java.util.List;

class Rectangle {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public String toString() {
        return "Rectangle(width=" + width + ", height=" + height +
                ", area=" + getArea() + ", perimeter=" + getPerimeter() + ")";
    }
}

public class ex04 {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(3.0, 4.0);
        Rectangle r2 = new Rectangle(5.0, 2.0);
        Rectangle r3 = new Rectangle(4.5, 3.5);

        Rectangle[] rectangles = {r1, r2, r3};

        for (int i = 0; i < rectangles.length; i++) {
            Rectangle r = rectangles[i];
            System.out.println("Rectangle " + (i + 1) + ": width=" + r.getWidth() +
                    ", height=" + r.getHeight() +
                    ", area=" + r.getArea() +
                    ", perimeter=" + r.getPerimeter());
        }

        System.out.println();

        double maxArea = -1;
        List<Integer> maxIndices = new ArrayList<>();

        for (int i = 0; i < rectangles.length; i++) {
            double currentArea = rectangles[i].getArea();
            if (currentArea > maxArea) {
                maxArea = currentArea;
                maxIndices.clear();
                maxIndices.add(i);
            } else if (currentArea == maxArea) {
                maxIndices.add(i);
            }
        }

        if (maxIndices.size() > 1) {
            System.out.println("Có nhiều hình cùng diện tích lớn nhất là " + maxArea);
        } else {
            int maxIdx = maxIndices.get(0);
            Rectangle maxRect = rectangles[maxIdx];
            System.out.println("Largest area = " + maxArea + " (Rectangle " + (maxIdx + 1) +
                    ": width=" + maxRect.getWidth() + ", height=" + maxRect.getHeight() + ")");
        }
    }
}