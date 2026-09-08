package vn.edu.rikkei.session10.ex01;

public class Employee {
    private String empId;
    private String fullName;
    private double baseSalary;

    public Employee(String empId, String fullName, double baseSalary) {
        this.empId = empId;
        this.fullName = fullName;
        this.baseSalary = baseSalary;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }
}