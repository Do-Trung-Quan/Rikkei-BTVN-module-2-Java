package vn.edu.rikkei.session01.ex06;

public class Employee {
    private String empID;
    private String empName;
    private double workHours;
    private double salPerHour;
    private double allowance;

    private final double BHXH = 0.08;
    private final double BHYT = 0.015;
    private final double BHTN = 0.01;
    private final double feeCD = 150000;

    public Employee(String empID, String empName, double workHours, double salPerHour, double allowance) {
        this.empID = empID;
        this.empName = empName;
        this.workHours = workHours;
        this.salPerHour = salPerHour;
        this.allowance = allowance;
    }

    public double getBaseSal(){
        return this.salPerHour * this.workHours;
    }

    public double getGrossSal(){
        return getBaseSal() + this.allowance;
    }

    public double getNetSal(){
        return getGrossSal() - (getBaseSal()*this.BHXH) - (getBaseSal()*this.BHYT) - (getBaseSal()*this.BHTN) - (this.feeCD);
    }

    public double getSumKT(){
        return (getBaseSal()*this.BHXH) + (getBaseSal()*this.BHYT) + (getBaseSal()*this.BHTN) + (this.feeCD);
    }


    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public double getWorkHours() {
        return workHours;
    }

    public void setWorkHours(double workHours) {
        this.workHours = workHours;
    }

    public double getSalPerHour() {
        return salPerHour;
    }

    public void setSalPerHour(double salPerHour) {
        this.salPerHour = salPerHour;
    }

    public double getAllowance() {
        return allowance;
    }

    public void setAllowance(double allowance) {
        this.allowance = allowance;
    }

    public double getBHXH() {
        return BHXH;
    }

    public double getBHYT() {
        return BHYT;
    }

    public double getBHTN() {
        return BHTN;
    }

    public double getFeeCD() {
        return feeCD;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }
}
