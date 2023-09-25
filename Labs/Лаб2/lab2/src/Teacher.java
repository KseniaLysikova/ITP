public class Teacher extends Human {
    private int experience;
    private String subjectTaught;
    private String department;

    public void startTeaching() {
        System.out.println("Teacher has started teaching");
    }

    public void stopTeaching() {
        System.out.println("Teacher has stopped teaching");
    }

    public Teacher(String name, String gender, int age, int exp, String subject, String dep) {
        super(name, gender, age);
        experience = exp;
        subjectTaught = subject;
        department = dep;
    }

    public Teacher() {
        this("John Doe", "male", 27, 2, " ", " ");
    }

    public int getExperience() {
        return experience;
    }

    public String getSubjectTaught() {
        return subjectTaught;
    }

    public String getDepartment() {
        return department;
    }

    public void setExperience(int value) {
        experience = value;
    }

    public void setSubjectTaught(String value) {
        subjectTaught = value;
    }

    public void setDepartment(String value) {
        department = value;
    }
}
