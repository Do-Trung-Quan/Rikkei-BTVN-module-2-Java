package ex04;

import java.util.Scanner;

public class ex04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n == 0){
            System.out.println("Mảng không có phần tử");
            return;
        }
        int[] arr = new int[n];
        int[] arr2 = new int[n];

        int cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if(num%2==0) arr[cnt1++] = num;
            else arr2[cnt2++] = num;
        }
        for(int i=0;i<n;i++){
            if(i>=cnt1) arr[i]=arr2[i-cnt1];
            System.out.print(arr[i]+" ");
        }
    }
}
