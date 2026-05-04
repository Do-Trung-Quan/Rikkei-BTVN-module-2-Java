package ex02;

import java.util.Scanner;

public class ex02 {
    public static void main(String[] args) {
        System.out.print("Nhập số hàng của mảng: ");
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập số cột của mảng: ");
        int m = Integer.parseInt(sc.nextLine());
        int[][] arr = new int[n][m];

        int even = 0, odd = 0;

        System.out.println("Nhập các phần tử của mảng: ");
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.printf("Phần tử [%d][%d]: ",i,j);
                arr[i][j] = Integer.parseInt(sc.nextLine());
                if(arr[i][j]%2==0) even+=arr[i][j];
                else odd+=arr[i][j];
            }
        }

        System.out.println("Tổng các số chẵn: "+even);
        System.out.println("Tổng các số lẻ: "+odd);
    }
}
