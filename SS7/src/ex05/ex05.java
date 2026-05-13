package ex05;

public class ex05 {
    public class Customer{
        public int id;
        public String name;
        public String email;

        public void showInfo(){
            System.out.println("Customer ID: "+id);
            System.out.println("Customer name: "+name);
            System.out.println("Customer email: "+email);
        }
    }

    public class Order{
        public int orderId;
        public Customer customer;
        public double total;

        public void printOrder(){
            System.out.println("Order ID: "+orderId);
            System.out.println("Customer ID: "+customer.id);
            System.out.println("Customer name: "+customer.name);
            System.out.println("Customer email: "+customer.email);
            System.out.println("Total price: "+total);
        }
    }
}
