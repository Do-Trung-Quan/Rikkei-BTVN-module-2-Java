package ex04;

import java.util.Random;
import java.util.Scanner;

public class ex04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        if(n>0 && n<=1000){
            StringBuilder sb = new StringBuilder(n);
            String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
            Random random = new Random();
            for(int i=0;i<n;i++){
                sb.append(characters.charAt(random.nextInt(characters.length())));
            }
            System.out.println(sb);
        }
    }
}
