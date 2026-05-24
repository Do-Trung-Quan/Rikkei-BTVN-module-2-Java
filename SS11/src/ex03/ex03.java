package ex03;

abstract class Employee {
    protected int id;
    protected String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public abstract double calculateSalary();

    public void showInfo() {
        System.out.println("ID: " + id + " | Tên: " + name);
    }
}

interface BonusEligible {
    double calculateBonus();
}

class FullTimeEmployee extends Employee implements BonusEligible {
    private double baseSalary;

    public FullTimeEmployee(int id, String name, double baseSalary) {
        super(id, name);
        this.baseSalary = baseSalary;
    }

    @Override
    public double calculateSalary() {
        return baseSalary;
    }

    @Override
    public double calculateBonus() {
        return baseSalary * 0.10;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Lương cơ bản: " + baseSalary);
    }
}

class PartTimeEmployee extends Employee {
    private int workingHours;
    private double hourlyRate;

    public PartTimeEmployee(int id, String name, int workingHours, double hourlyRate) {
        super(id, name);
        this.workingHours = workingHours;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return workingHours * hourlyRate;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Số giờ làm: " + workingHours + " | Lương theo giờ: " + hourlyRate);
    }
}

public class ex03 {
    public static void main(String[] args) {
        // Khởi tạo mảng nhân viên
        Employee[] employees = new Employee[]{
                new FullTimeEmployee(1, "Nguyễn Văn A", 20000),
                new PartTimeEmployee(2, "Trần Thị B", 120, 50),
                new FullTimeEmployee(3, "Lê Văn C", 15000)
        };

        // Duyệt qua mảng nhân viên
        for (Employee emp : employees) {
            System.out.println("-------------------------");
            emp.showInfo();
            System.out.println("Tổng lương: " + emp.calculateSalary());

            // Kiểm tra điều kiện nhận thưởng
            if (emp instanceof BonusEligible) {
                double bonus = ((BonusEligible) emp).calculateBonus();
                System.out.println("Thưởng: " + bonus);
            } else {
                System.out.println("Không có thưởng");
            }
        }
    }
}
