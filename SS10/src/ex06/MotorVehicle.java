package ex06;

public class MotorVehicle extends Vehicle{
    protected String fuelType;

    public MotorVehicle(String brand, int year, String fuelType){
        super(brand, year);
        this.fuelType = fuelType;
    }

    @Override
    public void showInfo(){
        System.out.printf("Brand: %s, Year: %d\n", brand, year);
        System.out.println("Fuel Type: " + fuelType);
    }
}
