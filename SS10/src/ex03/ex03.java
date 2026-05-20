package ex03;

class Computer{
    public double calculatePrice(double basePrice){
        System.out.println("[Using basePrice only]");
        return basePrice;
    }

    public double calculatePrice(double basePrice, double tax){
        System.out.println("[Using basePrice + tax]");
        return basePrice+tax;
    }

    public double calculatePrice(double basePrice, double tax, double discount){
        System.out.println("[Using basePrice + tax + discount]");
        return basePrice+tax-discount;
    }
}

public class ex03 {
    public static void main(String[] args) {
        Computer comp = new Computer();
        System.out.printf("Final Price = %.1f\n",comp.calculatePrice(1000));
        System.out.printf("Final Price = %.1f\n",comp.calculatePrice(1000, 100));
        System.out.printf("Final Price = %.1f\n",comp.calculatePrice(1000, 100, 50));
    }
}
