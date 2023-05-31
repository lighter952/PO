 public final class Student {
    private String name;
    private int age;
    private String university;
    private StudyProgram studyProgram;
    enum StudyProgram {
        COMPUTER_SCIENCE,
        ECONOMICS,
        LITERATURE
    }

    public Student(String name, int age, String university, StudyProgram studyProgram) {
        this.name = name;
        this.age = age;
        this.university = university;
        this.studyProgram = studyProgram;
    }


    public boolean equals(Student student) {
        if(this.name == student.name && this.age == student.age &&
                this.university == student.university &&
                this.studyProgram == student.studyProgram) {
            return true;
        }
        return false;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public void setStudyProgram(StudyProgram studyProgram) {
        this.studyProgram = studyProgram;
    }

    public StudyProgram getStudyProgram() {
        return this.studyProgram;
    }
}


