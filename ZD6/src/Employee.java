abstract public class Employee implements Calculation {
    private String firstName;
    private String secondName;
    private int ID;

    public Employee(String firstName, String secondName, int ID) {
        this.firstName = firstName;
        this.secondName =secondName;
        this.ID = ID;
    }

    abstract public double calculateSalary();

    @Override
    public double calculate() {
        return calculateSalary();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
