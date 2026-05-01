package ex02;

import java.util.Locale;
import java.util.Scanner;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class ex02 {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in).useLocale(Locale.US);
        int cnt = 0;
        double avg = 0,Min = 999, Max = 0;
        int n;

        do{
            System.out.println("====MENU====");
            System.out.println("1. Nhập điểm học viên");
            System.out.println("2. Hiển thị thống kê");
            System.out.println("3. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            n = scanner.nextInt();

            if(n==1){
                System.out.println("----- Nhập điểm học viên (nhập -1 để dừng) -----");
                while(true){
                    System.out.print("Nhập điểm: ");
                    double m = scanner.nextDouble();
                    if(m==-1) break;
                    if(m < 0 || m>10){
                        System.err.println("Điểm không hợp lệ. Nhập lại.");
                        continue;
                    }
                    if(m <= 5) System.out.println("Học lực: Yếu");
                    else if(m <= 7) System.out.println("Học lực: Trung Bình");
                    else if(m <= 8) System.out.println("Học lực: Khá");
                    else if(m <= 9) System.out.println("Học lực: Giỏi");
                    else System.out.println("Học lực: Xuất sắc");

                    cnt++;
                    avg = (avg+m)/cnt;
                    Max = max(Max, m);
                    Min = min(Min, m);
                }
            } else if (n == 2) {
                if(cnt == 0){
                    System.out.println("Chưa có dữ liệu");
                    continue;
                }
                System.out.println("---- KẾT QUẢ ---");
                System.out.printf("Số học viên đã nhập: %d\n", cnt);
                System.out.printf("Điểm trung bình: %.2f\n", avg);
                System.out.printf("Điểm cao nhất: %.2f\n", Max);
                System.out.printf("Điểm thấp nhất: %.2f\n", Min);
            }else System.out.println("Kết thúc chương trình.");
        }while(n!=3);
        System.exit(0);

    }
}
