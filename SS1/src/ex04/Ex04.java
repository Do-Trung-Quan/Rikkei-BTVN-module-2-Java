package ex04;

import java.util.Scanner;

public class Ex04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float width, height, area, perimeter;

        while(true){
            System.out.println("Nhập chiều dài:");
            height = Float.parseFloat(scanner.nextLine());
            if (height >= 0) break;
            System.out.println("chiều dài không được nhỏ hơn 0");
        }
        while(true){
            System.out.println("Nhập chiều rộng:");
            width = Float.parseFloat(scanner.nextLine());
            if (width >= 0) break;
            System.out.println("chiều rộng không được nhỏ hơn 0");
        }

        perimeter = (height + width)*2;
        area = height*width;
        System.out.printf("Diện tích: %.2f \nChu vi: %.2f", area, perimeter);
    }
}
