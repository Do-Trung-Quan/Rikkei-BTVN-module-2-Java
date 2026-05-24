package ex02;

interface Refundable {
    void refund();
}

abstract class Payment {
    protected double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public abstract void pay();

    public void printAmount() {
        System.out.println("Amount: " + amount);
    }
}

class CashPayment extends Payment {
    public CashPayment(double amount) {
        super(amount);
    }

    @Override
    public void pay() {
        System.out.println("Paying " + amount + " in Cash.");
    }
}

class CreditCardPayment extends Payment implements Refundable {
    public CreditCardPayment(double amount) {
        super(amount);
    }

    @Override
    public void pay() {
        System.out.println("Paying " + amount + " using Credit Card.");
    }

    @Override
    public void refund() {
        System.out.println("Refunding " + amount + " to Credit Card.");
    }
}

class EWalletPayment extends Payment implements Refundable {
    public EWalletPayment(double amount) {
        super(amount);
    }

    @Override
    public void pay() {
        System.out.println("Paying " + amount + " using E-Wallet.");
    }

    @Override
    public void refund() {
        System.out.println("Refunding " + amount + " to E-Wallet.");
    }
}

public class ex02 {
    public static void main(String[] args) {
        Payment[] payments = new Payment[]{
                new CashPayment(150.0),
                new CreditCardPayment(500.0),
                new EWalletPayment(200.5)
        };

        for (Payment payment : payments) {
            System.out.println("--------------------");
            payment.printAmount();
            payment.pay();

            if (payment instanceof Refundable) {
                ((Refundable) payment).refund();
            }
        }
    }
}
