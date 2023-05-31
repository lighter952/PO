public class Main {
    public static void main(String[] args) {

    Student Alex = new Student("Alex", 23, "WSB", Student.StudyProgram.COMPUTER_SCIENCE);
    Student Bob = new Student("Bob", 22, "WSH", Student.StudyProgram.ECONOMICS);
    Student Jhon = new Student("Bob", 22, "WSH", Student.StudyProgram.ECONOMICS);

    System.out.println(compareStudents(Alex, Bob));
    System.out.println(Jhon.equals(Bob));




    }



    public static int compareStudents(Student a, Student b) {
        return a.getAge() - b.getAge();
    }
}