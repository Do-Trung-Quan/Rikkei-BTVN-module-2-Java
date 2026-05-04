package ex01;

import java.util.Scanner;

public class ex01 {
    public static void main(String[] args) {
        System.out.print("Nhập số lượng phần tử của mảng: ");
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] arr = new int[n];

        System.out.println("Nhập các phần tử của mảng: ");
        for(int i=0;i<n;i++){
            System.out.printf("Phần tử thứ %d: ", i+1);
            arr[i] = Integer.parseInt(sc.nextLine());
        }

        for(int i=0;i<n;i++){
            int ok = 0;
            for(int j=1;j<n-i;j++){
                if(arr[j-1] > arr[j]){
                    int num = arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=num;

                    ok++;
                }
            }
            if(ok==0) break;
        }
        System.out.println("Mảng sau khi sắp xếp giảm dần: ");
        for(int x:arr){
            System.out.print(x+" ");
        }

    }
}
