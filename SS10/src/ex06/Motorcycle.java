package ex06;

public class Motorcycle extends MotorVehicle {
    public Motorcycle(String brand, int year, String fuelType) {
        super(brand, year, fuelType);
    }

    @Override
    public void startEngine(){
        System.out.printf("%s (Motorcycle) engine starts: Brum Brum!\n", brand);
    }

    public void doWheelie(){
        System.out.printf("%s is doing a wheelie\n", brand);
    }
}
