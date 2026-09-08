package vn.edu.rikkei.session10.ex01;

import java.util.Locale;

public class FullTimeEmployee extends Employee {
    private double allowance;

    public FullTimeEmployee(String empId, String fullName, double baseSalary, double allowance) {
        super(empId, fullName, baseSalary);
        this.allowance = allowance;
    }

    public double getTotalSalary() {
        return getBaseSalary() + allowance;
    }

    public void displayInfo() {
        System.out.println("+-------------------------------------------------------+");
        System.out.println("|             HỒ SƠ NHÂN VIÊN CHÍNH THỨC                |");
        System.out.println("+-------------------------------------------------------+");
        System.out.printf("| Mã NV: %-13s | Họ tên: %-22s |\n", getEmpId(), getFullName());

        String salaryStr = String.format(Locale.US, "%,.0f VNĐ", getBaseSalary());
        System.out.printf("| Lương cơ bản:        %-30s |\n", salaryStr);

        String allowanceStr = String.format(Locale.US, "%,.0f VNĐ", allowance);
        System.out.printf("| Phụ cấp thâm niên:   %-30s |\n", allowanceStr);

        System.out.println("|-------------------------------------------------------|");

        String totalStr = String.format(Locale.US, "%,.0f VNĐ", getTotalSalary());
        System.out.printf("| -> TỔNG THU NHẬP:    %-30s |\n", totalStr);
        System.out.println("+-------------------------------------------------------+");
    }

    public double getAllowance() {
        return allowance;
    }

    public void setAllowance(double allowance) {
        this.allowance = allowance;
    }
}