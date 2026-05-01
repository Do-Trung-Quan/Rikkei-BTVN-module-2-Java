package ex04;

import java.util.Scanner;

public class ex04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        if(a+b <= c || c+a <= b || b+c <= a){
            System.err.println("Ba cạnh không tạo thành tam giác.");
        }else{
            if(a == b && c == b) System.out.println("Đây là tam giác đều.");
            else if(a==b || b==c || a==c) System.out.println("Đây là tam giác cân.");
            else if(a*a + b*b == c*c || a*a + c*c == b*b || b*b + c*c == a*a) System.out.println("Đây là tam giác vuông.");
            else System.out.println("Đây là tam giác thường.");
        }
    }
}
