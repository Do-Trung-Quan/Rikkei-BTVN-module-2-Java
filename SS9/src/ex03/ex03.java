package ex03;

class Student {
    private String id;
    private String fullName;
    private int age;
    private double gpa;

    private static int count = 0;

    public static final double MIN_GPA = 0.0;
    public static final double MAX_GPA = 4.0;

    public Student(String id, String fullName, int age, double gpa) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;

        // Đảm bảo GPA nằm trong khoảng cho phép
        if (gpa >= MIN_GPA && gpa <= MAX_GPA) {
            this.gpa = gpa;
        } else {
            this.gpa = MIN_GPA; // Giá trị mặc định nếu nhập sai
        }

        count++;
    }

    public void printInfo() {
        System.out.println("ID: " + id + " | Tên: " + fullName + " | Tuổi: " + age + " | GPA: " + gpa);
    }

    public static int getCount() {
        return count;
    }
}

public class ex03 {
    public static void main(String[] args) {
        // Tạo 3 object Student
        Student st1 = new Student("SV01", "Nguyễn Văn A", 20, 3.5);
        Student st2 = new Student("SV02", "Trần Thị B", 21, 3.8);
        Student st3 = new Student("SV03", "Lê Văn C", 19, 2.9);

        // In thông tin từng sinh viên
        System.out.println("--- DANH SÁCH SINH VIÊN ---");
        st1.printInfo();
        st2.printInfo();
        st3.printInfo();

        // In ra tổng số sinh viên được tạo
        System.out.println("\nTổng số sinh viên đã tạo: " + Student.getCount());
    }
}
