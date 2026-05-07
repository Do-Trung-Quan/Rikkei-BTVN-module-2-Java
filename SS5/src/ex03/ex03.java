package ex03;

import java.util.Scanner;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.matches;

public class ex03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String pass = sc.nextLine();
        Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
        boolean ok = pattern.matcher(pass).matches();
        if(ok) System.out.println("Mật khẩu hợp lệ");
        else System.out.println("Mật khẩu không hợp lệ");
    }
}
