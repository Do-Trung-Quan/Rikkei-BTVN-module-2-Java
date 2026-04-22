package ex06;

import java.util.Scanner;

public class Ex06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int speed;
        double time;

        while(true){
            System.out.println("Nhập vận tốc (km/h):");
            speed = Integer.parseInt(scanner.nextLine());
            if (speed >= 0) break;
            System.out.println("Vận tốc không được nhỏ hơn 0");
        }
        while(true){
            System.out.println("Nhập thời gian đi (giờ):");
            time = Double.parseDouble(scanner.nextLine());
            if (time >= 0) break;
            System.out.println("thời gian không được nhỏ hơn 0");
        }

        System.out.printf("Quãng đường đi được: %.2f (km)", time*speed);
    }
}
