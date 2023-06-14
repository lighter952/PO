import java.util.ArrayList;

public class Company implements Calculation{
    ArrayList<Employee> listEmployees = new ArrayList<Employee>();

    public double calculate() {
        return calculateSalary();
    }

    public double calculateSalary() {
        double summarySalary = 0;

        for (Employee employee : listEmployees) {
            summarySalary += employee.calculate();
        }

        return summarySalary;
    }

    public void appendEmployeeToList(Employee emp) {
        listEmployees.add(emp);
    }

    public double avarageSalary() {
        double sum = 0;

        for (Employee employee : listEmployees) {
            sum += employee.calculate();
        }

        return sum / listEmployees.size();
    }
}
