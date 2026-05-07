package ex02;

public class ex02 {
    public static void main(String[] args) {
        String str = "Hello";

        long start = System.currentTimeMillis();
        for(int i=1;i<=100000;i++){  //giảm thành 100000 vì quá lâu
            str+="World";
        }
        long end = System.currentTimeMillis();
        System.out.printf("Thời gian thực hiện với String: %d ms\n", end-start);

        str = "Hello";
        StringBuilder sb = new StringBuilder(str);
        start = System.currentTimeMillis();
        for(int i=1;i<=100000;i++){
            sb.append("World");
        }
        end = System.currentTimeMillis();
        System.out.printf("Thời gian thực hiện với StringBuilder: %d ms\n", end-start);

        StringBuffer sbuff = new StringBuffer(str);
        start = System.currentTimeMillis();
        for(int i=1;i<=100000;i++){
            sbuff.append("World");
        }
        end = System.currentTimeMillis();
        System.out.printf("Thời gian thực hiện với StringBuffer: %d ms\n", end-start);

    }
}
