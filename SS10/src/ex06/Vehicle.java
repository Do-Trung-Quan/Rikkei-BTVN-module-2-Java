package ex06;

public class Vehicle {
    protected String brand;
    protected int year;

    public Vehicle(String brand, int year){
        this.brand = brand;
        this.year = year;
    }

    public void showInfo(){
//        System.out.printf("Brand: %s, Year: %d\n", brand, year);
    }

    public void startEngine(){
//        System.out.println("Vehicle engine starts");
    }

    public void move(){
        System.out.println("Vehicle is moving.");
    }

    public void move(int speed){
        System.out.printf("Vehicle is moving at %d km/h\n", speed);
    }
}
