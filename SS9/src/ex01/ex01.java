package ex01;

import java.util.Scanner;

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

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return (width + height) * 2;
    }

    public void printInfo() {
        System.out.println("Hình chữ nhật [Width=" + width + ", Height=" + height + "]");
        System.out.println("Diện tích: " + getArea());
        System.out.println("Chu vi: " + getPerimeter());
    }
}

public class ex01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập chiều rộng (width): ");
        double width = scanner.nextDouble();

        System.out.print("Nhập chiều cao (height): ");
        double height = scanner.nextDouble();

        Rectangle rect = new Rectangle(width, height);

        rect.printInfo();

        scanner.close();
    }
}
