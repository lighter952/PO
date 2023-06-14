public class Main {
    public static void main(String[] args) {
        Employee1 emp = new Employee1("Pete", "Mitchell", 1, 22.5, 168);
        Employee2 emp2 = new Employee2("Tom", "Kazansky", 2, 4202.50);
        Employee1 emp3 = new Employee1("Bradley", "Bradshaw", 3, 30.0, 140);
        Employee2 emp4 = new Employee2("Penny", "Benjamin", 4, 5543.50);

        Company cmp = new Company();
        cmp.appendEmployeeToList(emp);
        cmp.appendEmployeeToList(emp2);
        cmp.appendEmployeeToList(emp3);
        cmp.appendEmployeeToList(emp4);

        System.out.println(emp.calculate());
        System.out.println(emp2.calculate());

        System.out.println(cmp.calculate());
        System.out.println(cmp.avarageSalary());

    }
}