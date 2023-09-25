public class Student extends Human {
    private String studentFaculty;
    private String studentGroup;
    private String studentNumber;
    static int numberOfObjects;

    {
        numberOfObjects += 1;
    }

    @Override
    public void walk() {
        System.out.println("Student is walking");
    }

    public void startLearning() {
        System.out.println("Student has started learning");
    }

    public Student(String name, String gender, int age, String faculty, String group, String number) {
        super(name, gender, age);
        studentFaculty = faculty;
        studentGroup = group;
        studentNumber = number;
    }

    public Student() {
        this("John Doe", "male", 1, " ", " ", " ");
    }

    public String getStudentFaculty() {
        return studentFaculty;
    }

    public String getStudentGroup() {
        return studentGroup;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentFaculty(String value) {
        studentFaculty = value;
    }

    public void setStudentGroup(String value) {
        studentGroup = value;
    }

    public void setStudentNumber(String value) {
        studentNumber = value;
    }
}
