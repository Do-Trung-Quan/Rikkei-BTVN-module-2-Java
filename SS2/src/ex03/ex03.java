package ex03;

import java.util.Scanner;

import static java.lang.Math.abs;

public class ex03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = abs(scanner.nextInt());
        int res = 0;
        while(n>0){
            res += n%10;
            n/=10;
        }

        System.out.printf("Tổng các chữ số là: %d\n",res);
    }
}
