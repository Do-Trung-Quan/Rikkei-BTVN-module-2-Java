package ex06;

public class Truck extends MotorVehicle{
    public Truck(String brand, int year, String fuelType) {
        super(brand, year, fuelType);
    }

    @Override
    public void startEngine(){
        System.out.printf("%s (Truck) engine starts: RRRRRR!\n", brand);
    }

    public void loadCargo(){
        System.out.printf("%s is loading cargo\n", brand);
    }
}
