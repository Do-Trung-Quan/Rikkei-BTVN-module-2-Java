package ex01;

import java.util.Scanner;

public class ex01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n<=0) System.err.println("Số nhập vào không hợp lệ");
        else{
            int res = 0;
            for(int i=1;i<=n;i++){
                res+=i;
            }
            System.out.println(res);
        }
    }
}
