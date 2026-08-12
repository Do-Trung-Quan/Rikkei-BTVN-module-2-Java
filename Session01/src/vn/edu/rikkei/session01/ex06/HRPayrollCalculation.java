package vn.edu.rikkei.session01.ex06;

import java.util.Scanner;

public class HRPayrollCalculation {

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        System.out.println("--- HỆ THỐNG TÍNH LƯƠNG NHÂN SỰ RIKKEI SOFT ---");

        System.out.print("Nhập mã nhân viên            : ");
        String empId = inp.nextLine();

        System.out.print("Nhập họ và tên nhân viên     : ");
        String empName = inp.nextLine();

        System.out.print("Nhập số giờ làm việc thực tế : ");
        double workHours = Double.parseDouble(inp.nextLine());

        System.out.print("Nhập mức lương theo giờ (VNĐ): ");
        double salPerHours = Double.parseDouble(inp.nextLine());

        System.out.print("Nhập phụ cấp hàng tháng (VNĐ): ");
        double allowance = Double.parseDouble(inp.nextLine());

        Employee emp = new Employee(empId, empName, workHours, salPerHours, allowance);
        System.out.printf("""
                +-------------------------------------------------------------------+
                |               PHIẾU LƯƠNG NHÂN VIÊN (PAYROLL SLIP)                |
                +-------------------------------------------------------------------+
                | Mã nhân viên   : %s                                     |
                | Họ và tên      : %s                                  |
                | Số giờ làm việc: %.1f giờ  | Lương giờ: %,18.2f VNĐ   |
                +-------------------------------------------------------------------+
                | I. THU NHẬP (EARNINGS)                                            |
                | - Lương cơ bản theo giờ               : %,18.2f VNĐ  |
                | - Phụ cấp cố định                     : %,18.2f VNĐ  |
                | -> TỔNG THU NHẬP GỘP (GROSS)          : %,18.2f VNĐ  |
                +-------------------------------------------------------------------+
                | II. KHẤU TRỪ BẢO HIỂM & ĐOÀN PHÍ (DEDUCTIONS)                     |
                | - BHXH (8.0%%)                         : %,18.2f VNĐ  |
                | - BHYT (1.5%%)                         : %,18.2f VNĐ  |
                | - BHTN (1.0%%)                         : %,18.2f VNĐ  |
                | - Đoàn phí Công đoàn (Cố định)        : %,18.2f VNĐ  |
                | -> TỔNG KHẤU TRỪ                      : %,18.2f VNĐ  |
                +-------------------------------------------------------------------+
                | III. THỰC NHẬN (NET PAY)                                          |
                | -> LƯƠNG THỰC NHẬN CUỐI CÙNG          : %,18.2f VNĐ  |
                +-------------------------------------------------------------------+
                
                """, emp.getEmpID(), emp.getEmpName(), emp.getWorkHours(), emp.getSalPerHour(), emp.getBaseSal(), emp.getAllowance(), emp.getGrossSal(), emp.getBaseSal()*emp.getBHXH(), emp.getBaseSal()*emp.getBHYT(), emp.getBaseSal()*emp.getBHTN(), emp.getFeeCD(), emp.getSumKT(), emp.getNetSal());

    }
}
