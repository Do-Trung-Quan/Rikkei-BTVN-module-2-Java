package ex05;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ex05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = "";
        while(true){
            System.out.println("****************************** MENU ******************************");
            System.out.println("1. Nhập chuỗi");
            System.out.println("2. Đếm số ký tự thường, hoa, số, đặc biệt");
            System.out.println("3. Đảo ngược chuỗi");
            System.out.println("4. Kiểm tra Palindrome");
            System.out.println("5. Chuẩn hóa chuỗi (xóa khoảng trắng dư thừa, viết hoa chữ cái đầu)");
            System.out.println("6. Thoát");
            System.out.println("******************************************************************");
            System.out.print("Lựa chọn của bạn: ");

            int  n = Integer.parseInt(sc.nextLine());
            System.out.println("Chọn:"+n);
            if(n==1) {
                System.out.print("Nhập chuỗi: ");
                str = sc.nextLine();
            }
            else if(n==2){
                int num1 = 0, num2 = 0, num3 = 0, num4 = 0;
                for(int i=0;i<str.length();i++){
                    char a = str.charAt(i);
                    Pattern pat1 = Pattern.compile("[a-z]");
                    Pattern pat2 = Pattern.compile("[A-Z]");
                    Pattern pat3 = Pattern.compile("\\d");
                    Pattern pat4 = Pattern.compile("[@$!%*?&]");
                    if(pat1.matcher(Character.toString(a)).matches()) num1++;
                    if(pat2.matcher(Character.toString(a)).matches()) num2++;
                    if(pat3.matcher(Character.toString(a)).matches()) num3++;
                    if(pat4.matcher(Character.toString(a)).matches()) num4++;
                }
                System.out.println("Số ký tự thường: " + num1);
                System.out.println("Số ký tự hoa: " + num2);
                System.out.println("Số ký tự số: " + num3);
                System.out.println("Số ký tự đặc biệt: " + num4);
            }else if(n==3){
                StringBuilder sb = new StringBuilder(str);
                System.out.println("Chuỗi đảo ngược: "+ sb.reverse());
            }else if(n==4){
                StringBuilder sb = new StringBuilder(str);
                if(sb.reverse().toString().equals(str)){
                    System.out.println("Chuỗi là Palindrome");
                }else System.out.println("Chuỗi không phải Palindrome");
            }else if(n==5){
                str = str.substring(0,1).toUpperCase() + str.substring(1);
                System.out.println("Chuỗi sau khi chuẩn hóa: "+str);
            }else break;
        }
        System.out.println("Tạm biệt!");
    }
}
