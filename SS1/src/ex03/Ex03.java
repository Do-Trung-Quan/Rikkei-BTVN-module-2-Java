package ex03;

import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tu1, mau1, tu2, mau2, tong_tu, tong_mau;

        System.out.println("Nhập tử và mẫu của phân số 1:");
        tu1 = scanner.nextInt();
        mau1 = scanner.nextInt();

        System.out.println("Nhập tử và mẫu của phân số 2:");
        tu2 = scanner.nextInt();
        mau2 = scanner.nextInt();

        tong_tu = tu1*mau2 + tu2*mau1;
        tong_mau = mau1*mau2;
        System.out.printf("Kết quả: %d/%d", tong_tu, tong_mau);
    }
}
