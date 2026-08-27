package vn.edu.rikkei.session07.ex04;

public class Student {
    String studentId;
    String fullName;
    double mathScore;
    double literatureScore;
    double englishScore;

    public Student(String studentId, String fullName,  double mathScore, double literatureScore, double englishScore) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.mathScore = mathScore;
        this.literatureScore = literatureScore;
        this.englishScore = englishScore;
    }

    public double getAverageScore() {
        return (this.mathScore + this.literatureScore + this.englishScore) / 3;
    }

    public String getAcademicStanding(){
        if(getAverageScore() >= 8) return "Giỏi";
        if(getAverageScore() >= 6.5) return "Khá";
        if(getAverageScore()>=5) return "Trung Bình";
        return "Yếu";
    }

    public void displayStudentProfile(){
        System.out.printf("""
                +-------------------------------------------------------+
                |             HỒ SƠ HỌC TẬP SINH VIÊN                   |
                +-------------------------------------------------------+
                | Mã SV: %s         | Họ tên: %s         |
                | Điểm thi: Toán (%.1f)  | Văn (%.1f)   | Anh (%.1f)       |
                |-------------------------------------------------------|
                | ĐIỂM TRUNG BÌNH:      %.2f điểm                       |
                | XẾP LOẠI HỌC LỰC:     %s                |
                +-------------------------------------------------------+
                """, this.studentId, this.fullName, this.mathScore, this.literatureScore, this.englishScore, getAverageScore(), getAcademicStanding());
    }
}
