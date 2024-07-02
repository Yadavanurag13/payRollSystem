import java.util.ArrayList;

abstract class Employee {
    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }   

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "Employee[name="+name+", id="+id+", salary="+calculateSalary()+"]";
    }

}
class FullTimeEmployee extends Employee{

    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
} 
class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee (String name, int id, int hoursWorked, double hourlyRate) {
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }
}


class Payrollsystem {
    private ArrayList<Employee> employeeList;

    public Payrollsystem() {
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public void removeEmployee(int id) {
        Employee employeeToRemove = null;

        for(Employee employee : employeeList) {
            if(employee.getId() == id) {
                employeeToRemove = employee;
                break;
            }
        }

        if(employeeToRemove != null) {
            employeeList.remove(employeeToRemove);
        }
    }

    public void displayEmployee() {
        for(Employee employee : employeeList) {
            System.out.println(employee);
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Payrollsystem payrollsystem= new Payrollsystem();

        FullTimeEmployee emp1 = new FullTimeEmployee("Vikas", 1, 70000);
        PartTimeEmployee emp2 = new PartTimeEmployee("Love", 2, 46, 100);

        payrollsystem.addEmployee(emp1);
        payrollsystem.addEmployee(emp2);
        System.out.println("Intial Employee Details: ");
        payrollsystem.displayEmployee();
        System.out.println("Remove Employee");
        payrollsystem.removeEmployee(2);
        System.out.println("Remaining employee");
        payrollsystem.displayEmployee();
    }
}

