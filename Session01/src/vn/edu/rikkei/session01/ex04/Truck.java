package vn.edu.rikkei.session01.ex04;

public class Truck {
    private String truckId;
    private double currentFuel;
    private double efficiency;
    private double currentWeight;
    private double maxWeight;
    private boolean isMaintained;

    public Truck(String truckId, double currentFuel, double efficiency, double currentWeight, double maxWeight, boolean isMaintained) {
        this.truckId = truckId;
        this.currentFuel = currentFuel;
        this.efficiency = efficiency;
        this.currentWeight = currentWeight;
        this.maxWeight = maxWeight;
        this.isMaintained = isMaintained;
    }

    public double getMaxDistance() {
        return this.currentFuel * this.efficiency;
    }

    public boolean isFuelOk() {
        return getMaxDistance() >= 200.0;
    }

    public boolean isWeightOk() {
        return this.currentWeight <= this.maxWeight;
    }

    public boolean isReadyToDepart() {
        return isFuelOk() && isWeightOk() && this.isMaintained;
    }

    public boolean isWarning() {
        return (this.currentWeight > this.maxWeight) || (this.currentFuel < 30.0);
    }

    // Getters and Setters
    public String getTruckId() {
        return truckId;
    }

    public void setTruckId(String truckId) {
        this.truckId = truckId;
    }

    public double getCurrentFuel() {
        return currentFuel;
    }

    public void setCurrentFuel(double currentFuel) {
        this.currentFuel = currentFuel;
    }

    public double getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(double efficiency) {
        this.efficiency = efficiency;
    }

    public double getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(double currentWeight) {
        this.currentWeight = currentWeight;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public boolean isMaintained() {
        return isMaintained;
    }

    public void setMaintained(boolean maintained) {
        isMaintained = maintained;
    }
}