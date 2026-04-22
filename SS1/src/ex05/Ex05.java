package ex05;

import java.util.Scanner;

public class Ex05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double weight, height;

        while(true){
            System.out.println("Nhập cân nặng (kg):");
            weight = Double.parseDouble(scanner.nextLine());
            if (weight >= 0) break;
            System.out.println("cân nặng không được nhỏ hơn 0");
        }
        while(true){
            System.out.println("Nhập chiều cao (m):");
            height = Double.parseDouble(scanner.nextLine());
            if (height >= 0) break;
            System.out.println("chiều cao không được nhỏ hơn 0");
        }

        System.out.printf("chỉ số BMI: %.2f", weight / (height*height));
    }
}
