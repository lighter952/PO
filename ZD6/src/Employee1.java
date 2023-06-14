public class Employee1 extends Employee {
    private double hourlyRate;
    private int mountlyHours;

    public Employee1(String firstName, String secondName, int ID, double hourlyRate, int monthlyHours) {
        super(firstName, secondName, ID);
        this.hourlyRate = hourlyRate;
        this.mountlyHours = monthlyHours;
    }


    @Override
    public double calculateSalary() {
        return hourlyRate * mountlyHours + mountlyHours * 2;
    }
}
