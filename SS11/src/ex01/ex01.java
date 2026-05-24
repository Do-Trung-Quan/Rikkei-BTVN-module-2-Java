package ex01;

abstract class Shape{
    protected String name;

    Shape(String name){
        this.name=name;
    }

    public abstract double getArea();
    public abstract double getPerimeter();
    public void displayInfo(){
        System.out.println("Tên hình: " + name);
    }
}

interface Drawable{
    public void draw();
}

class Rectangle extends Shape implements Drawable{
    private double width;
    private double height;

    Rectangle(String name, double width, double height){
        super(name);
        this.width = width;
        this.height = height;
    }

    public double getArea(){
        return width*height;
    }

    public double getPerimeter(){
        return 2*width+2*height;
    }

    public void draw(){
        displayInfo();
    }
}

class Circle extends Shape implements Drawable{
    private double radius;

    Circle(String name, double radious){
        super(name);
        this.radius = radious;
    }

    public double getArea(){
        return radius*radius*Math.PI;
    }

    public double getPerimeter(){
        return 2*radius*Math.PI;
    }

    public void draw(){
        displayInfo();
    }
}

public class ex01 {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle("Rectangle", 10, 10);
        Circle circle = new Circle("Circle", 10);

        rectangle.draw();
        System.out.printf("Dien tích hình: %.2f\n", rectangle.getArea());
        System.out.printf("Chu vi hình: %.2f\n", rectangle.getPerimeter());

        System.out.println("==========================");

        circle.draw();
        System.out.printf("Dien tích hình: %.2f\n", circle.getArea());
        System.out.printf("Chu vi hình: %.2f\n", circle.getPerimeter());
    }
}
