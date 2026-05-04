package ex03;

import java.util.Scanner;

public class ex03 {
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

        /*Sắp xếp chọn giảm dần*/
        for(int i = 0;i<n-1;i++){
            int M = arr[i];
            int indexM = i;
            for(int j = i+1;j<n;j++){
                if(M < arr[j]){
                    M = arr[j];
                    indexM = j;
                }
            }
            arr[indexM] = arr[i];
            arr[i] = M;
        }
        System.out.println("Mảng sau khi sắp xếp giảm dần:");
        for(int x:arr){
            System.out.print(x+" ");
        }

        /*Tìm kiếm tuyến tính*/
        System.out.print("\nNhập số cần tìm: ");
        int num = Integer.parseInt(sc.nextLine());
        int res1 = -9999;
        for(int i=0;i<n;i++){
            if(num == arr[i]){
                res1=i;
                break;
            }
        }
        System.out.println("Tìm kiếm tuyến tính: "+ (res1 != -9999 ? "số "+num+" có tại vị trí "+res1 : "Không tìm thấy num"));
        res1 = -9999;

        /*Tìm kiếm Binary*/
        int left = 0, right = n-1, mid = n/2;
        while(left <= right){
            if(num == arr[mid]) {
                res1 = mid;
                break;
            }else if(num < arr[mid]){
                left = mid+1;
                mid = left + (right-left)/2;
            }else{
                right = mid-1;
                mid = left + (right-left)/2;
            }
        }
        System.out.println("Tìm kiếm nhị phân: "+ (res1 != -9999 ? "số "+num+" có tại vị trí "+res1 : "Không tìm thấy num"));
    }
}
