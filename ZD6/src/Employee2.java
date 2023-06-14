public class Employee2 extends Employee {
    private double salary;

    public Employee2(String firstName, String secondName, int ID, double salary) {
        super(firstName, secondName, ID);
        this.salary = salary;
    }


    @Override
    public double calculateSalary(){
        return salary;
    }
}

